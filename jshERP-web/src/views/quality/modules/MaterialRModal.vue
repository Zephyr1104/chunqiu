<template>
  <j-modal
    :title="title"
    :width="width"
    :visible="visible"
    :confirmLoading="confirmLoading"
    :keyboard="false"
    :forceRender="true"
    v-bind:prefixNo="prefixNo"
    switchHelp
    switchFullscreen
    @cancel="handleCancel"
    :id="prefixNo"
    style="top:20px;height: 95%;">
    <template slot="footer">
      <a-button @click="handleCancel">取消</a-button>
      <a-button v-if="checkFlag && isCanCheck" :loading="confirmLoading" @click="handleOkAndCheck">保存并审核</a-button>
      <a-button type="primary" :loading="confirmLoading" @click="handleOk">保存</a-button>
      <!--发起多级审核-->
      <a-button v-if="!checkFlag" @click="handleWorkflow()" type="primary">提交流程</a-button>
    </template>
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-row class="form-row" :gutter="24">
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="供应商" data-step="1" data-title="供应商"
            data-intro="供应商必须选择，如果发现需要选择的供应商尚未录入，可以在下拉框中点击新增供应商进行录入">
               <a-select placeholder="选择供应商" v-decorator="[ 'organId', validatorRules.organId ]" :disabled="!rowCanEdit"
                :dropdownMatchSelectWidth="false" showSearch optionFilterProp="children">
                <div slot="dropdownRender" slot-scope="menu">
                  <v-nodes :vnodes="menu" />
                  <a-divider style="margin: 4px 0;" />
                  <div v-if="isTenant" style="padding: 4px 8px; cursor: pointer;"
                       @mousedown="e => e.preventDefault()" @click="addSupplier"><a-icon type="plus" /> 新增供应商</div>
                </div>
                <a-select-option v-for="(item,index) in supList" :key="index" :value="item.id">
                  {{ item.supplier }}
                </a-select-option>
              </a-select>
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="报告日期">
              <j-date v-decorator="['operTime', validatorRules.operTime ]" :show-time="true"/>
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="报告编号" data-step="2" data-title="单据编号"
            data-intro="报告编号自动生成、自动累加、开头是报告类型的首字母缩写，累加的规则是每次打开页面会自动占用一个新的编号">
              <a-input placeholder="请输入报告编号" v-decorator.trim="[ 'number' ]" :readOnly="true"/>
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="关联采购入库单" data-step="3" data-title="关联采购入库单"
              data-intro="原料质检报告可以通过关联采购入库单来选择已录入的入库单，选择之后会自动加载入库单的内容，然后继续录入仓库等信息完成报告的提交，
              提交之后原来的原料质检报告会对应的改变报告状态。另外本系统支持入库单多次检测，只需选择入库单之后修改对应的商品数量即可">
              <a-input-search placeholder="请选择关联入库单" v-decorator="[ 'linkNumber' ]" @search="onSearchLinkNumber" :readOnly="true"/>
            </a-form-item>
          </a-col>
        </a-row>
        <j-editable-table id="materialRModal"
        :ref="refKeys[0]"
          :loading="materialTable.loading"
          :columns="materialTable.columns"
          :dataSource="materialTable.dataSource"
          :minWidth="minWidth"
          :maxHeight="300"
          :rowNumber="false"
          :rowSelection="rowCanEdit"
          :actionButton="rowCanEdit"
          :dragSortAndNumber="rowCanEdit"
          @valueChange="onValueChange"
          @added="onAdded"
          @deleted="onDeleted">
          <template #buttonAfter>
            <a-row v-if="rowCanEdit" :gutter="24" style="float:left;" data-step="4" data-title="扫码录入" data-intro="此功能支持扫码枪扫描商品条码进行录入">
              <a-col v-if="scanStatus" :md="6" :sm="24">
                <a-button @click="scanEnter">扫码录入</a-button>
              </a-col>
              <a-col v-if="!scanStatus" :md="16" :sm="24" style="padding: 0 8px 0 12px">
                <a-input placeholder="请扫描商品条码并回车" v-model="scanBarCode" @pressEnter="scanPressEnter" ref="scanBarCode"/>
              </a-col>
              <a-col v-if="!scanStatus" :md="6" :sm="24" style="padding: 0px 12px 0 0">
                <a-button @click="stopScan">收起扫码</a-button>
              </a-col>
            </a-row>
            <a-row v-if="rowCanEdit" :gutter="24" style="float:left;padding-bottom: 5px;padding-left:20px;">
              <a-button icon="import" @click="onImport(prefixNo)">导入明细</a-button>
            </a-row>
          </template>
          <template #depotBatchSet>
            <a-icon type="down" @click="handleBatchSetDepot" />
          </template>
          <template #depotAdd>
            <a-divider v-if="isTenant" style="margin: 4px 0;" />
            <div v-if="isTenant" style="padding: 4px 8px; cursor: pointer;" @click="addDepot"><a-icon type="plus" /> 新增仓库</div>
          </template>
        </j-editable-table>
        <a-row class="form-row" :gutter="24">
          <a-col :lg="24" :md="24" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="{xs: { span: 24 },sm: { span: 24 }}" label="">
              <a-textarea :rows="1" placeholder="请输入备注" v-decorator="[ 'remark' ]" style="margin-top:8px;"/>
            </a-form-item>
          </a-col>
        </a-row>
        <a-row class="form-row" :gutter="24">
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="附件" data-step="11" data-title="附件"
            data-intro="可以上传与单据相关的图片、文档，支持多个文件">
              <j-upload v-model="fileList" bizPath="bill"></j-upload>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
    </a-spin>
    <import-item-modal ref="importItemModalForm" @ok="importItemModalFormOk"></import-item-modal>
    <wait-bill-list ref="waitBillList" @ok="waitBillListOk"></wait-bill-list>
    <vendor-modal ref="vendorModalForm" @ok="vendorModalFormOk"></vendor-modal>
    <depot-modal ref="depotModalForm" @ok="depotModalFormOk"></depot-modal>
    <batch-set-depot ref="batchSetDepotModalForm" @ok="batchSetDepotModalFormOk"></batch-set-depot>
    <workflow-iframe ref="modalWorkflow"></workflow-iframe>
  </j-modal>
</template>
<script>
  import pick from 'lodash.pick'
  import VendorModal from '../../system/modules/VendorModal'
  import DepotModal from '../../system/modules/DepotModal'
  import BatchSetDepot from '@/views/bill/dialog/BatchSetDepot'
  import ImportItemModal from '@/views/bill/dialog/ImportItemModal'
  import WorkflowIframe from '@/components/tools/WorkflowIframe'
  import { FormTypes } from '@/utils/JEditableTableUtil'
  import { JEditableTableMixin } from '@/mixins/JEditableTableMixin'
  import { BillModalMixin } from '@/views/bill/mixins/BillModalMixin'
  import { getMpListShort } from "@/utils/util"
  import JUpload from '@/components/jeecg/JUpload'
  import JDate from '@/components/jeecg/JDate'
  import Vue from 'vue'
  import WaitBillList from '@/views/bill/dialog/WaitBillList'
  export default {
    name: "MaterialRModal",
    mixins: [JEditableTableMixin, BillModalMixin],
    components: {
      VendorModal,
      DepotModal,
      BatchSetDepot,
      ImportItemModal,
      WaitBillList,
      WorkflowIframe,
      JUpload,
      JDate,
      VNodes: {
        functional: true,
        render: (h, ctx) => ctx.props.vnodes,
      }
    },
    data () {
      return {
        title:"操作",
        width: '1600px',
        moreStatus: false,
        // 新增时子表默认添加几行空数据
        addDefaultRowNum: 1,
        visible: false,
        operTimeStr: '',
        prefixNo: 'YL',
        model: {},
        fileList:[],
        rowCanEdit: true,
        labelCol: {
          xs: { span: 24 },
          sm: { span: 8 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        refKeys: ['materialDataTable', ],
        activeKey: 'materialDataTable',
        materialTable: {
          loading: false,
          dataSource: [],
          columns: [
          { title: '仓库名称', key: 'depotId', width: '8%', type: FormTypes.select, placeholder: '请选择${title}', options: [],
              allowSearch:true, validateRules: [{ required: true, message: '${title}不能为空' }]
            },
            { title: '条码', key: 'barCode', width: '12%', type: FormTypes.popupJsh, kind: 'material', multi: true,
              validateRules: [{ required: true, message: '${title}不能为空' }]
            },
            { title: '名称', key: 'name', width: '10%', type: FormTypes.normal },
            { title: '入库数量', key: 'basicNumber', width: '9%', type: FormTypes.normal },
            { title: '型号', key: 'model', width: '9%', type: FormTypes.normal },
            { title: '颜色', key: 'color', width: '5%', type: FormTypes.normal },
            { title: '扩展信息', key: 'materialOther', width: '5%', type: FormTypes.normal },
            { title: '单位', key: 'unit', width: '4%', type: FormTypes.normal },
            { title: '报告名称', key: 'qualityName', width: '10%', type: FormTypes.normal },
            { title: '批号', key: 'batchNumber', width: '7%', type: FormTypes.input },
            { title: '检测日期', key: 'qualityTime',width: '7%', type: FormTypes.date },
            { title: '多属性', key: 'sku', width: '9%', type: FormTypes.normal },
            { title: '检测数量', key: 'operNumber', width: '8%', type: FormTypes.inputNumber, statistics: true,
              validateRules: [{ required: true, message: '${title}不能为空' }]
            },
            { title: '备注', key: 'remark', width: '5%', type: FormTypes.input },
            { title: '关联id', key: 'linkId', width: '5%', type: FormTypes.hidden },
          ]
        },
        confirmLoading: false,
        validatorRules:{
          operTime:{
            rules: [
              { required: true, message: '请输入报告日期!' }
            ]
          },
          organId:{
            rules: [
              { required: true, message: '请选择供应商！' }
            ]
          }
        },
        url: {
          add: '/materialR/addMaterialR',
          edit: '/materialR/updateMaterialR',
          detailList: '/materialR/getDetailList'
        }
      }
    },
    created () {
    },
    methods: {
      //调用完edit()方法之后会自动调用此方法
      editAfter(model) {
        this.billStatus = '0'
        this.currentSelectDepotId = ''
        this.rowCanEdit = true
        this.materialTable.columns[1].type = FormTypes.popupJsh
        this.changeColumnHide()
        this.changeFormTypes(this.materialTable.columns, 'batchNumber', 0)
        this.changeFormTypes(this.materialTable.columns, 'qualityName', 0)
        if (this.action === 'add') {
          console.log("add")
          this.addInit(this.prefixNo)
          this.fileList = []
        } else {
          if(this.model.linkNumber) {
            console.log("编辑")
            this.rowCanEdit = false
            this.materialTable.columns[1].type = FormTypes.normal
          }
          this.model.operTime = this.model.qualityTime
          this.model.number = this.model.qualityNo
          this.fileList = this.model.fileName
          this.$nextTick(() => {
            this.form.setFieldsValue(pick(this.model,'organId', 'operTime', 'number', 'linkNumber', 'remark',))
          }); 
          // 加载子表数据
          let params = {
           headerId: this.model.id,
           mpList: getMpListShort(Vue.ls.get('materialPropertyList')),  //扩展属性
           linkType: 'basic'
          }
          let url = this.readOnly ? this.url.detailList : this.url.detailList;
          this.requestSubTableData(url, params, this.materialTable);
        }
        //复制新增单据-初始化单号和日期
        if(this.action === 'copyAdd') {
          console.log("复制新增单据-初始化单号和日期")
          this.model.id = ''
          this.model.tenantId = ''
          this.copyAddInit(this.prefixNo)
        }
        this.initSystemConfig()
        this.initSupplier()
        this.initDepot() 
      },
      //提交报告时整理成formData
      classifyIntoFormData(allValues) {
        console.log("进入classifyIntoFormData函数")
        let billMain = Object.assign(this.model, allValues.formValue)
        let detailArr = allValues.tablesValue[0].values
        billMain.type = '原料'
        billMain.qualityName = '原料质检报告'
        billMain.qualityNo = billMain.number
        billMain.qualityTime = billMain.operTime
        if(this.fileList && this.fileList.length > 0) {
          billMain.fileName = this.fileList
        } else {
          billMain.fileName = ''
        }
        if(this.model.id){
          billMain.id = this.model.id
        }
        billMain.status = this.billStatus
        return {
          info: JSON.stringify(billMain),
          rows: JSON.stringify(detailArr),
        }
      },
      onSearchLinkNumber() {
        console.log("onSearchLinkNumber")
        this.$refs.waitBillList.show('入库', '采购,销售退货', "1,3")
        this.$refs.waitBillList.title = "选择采购入库或销售退货"
      },
      waitBillListOk(selectBillDetailRows, linkNumber,organId,remark,depotId) {
        console.log("===========waitBillListOk")
        this.rowCanEdit = false
        this.materialTable.columns[1].type = FormTypes.normal
        this.changeFormTypes(this.materialTable.columns, 'basicNumber', 1)
        this.changeFormTypes(this.materialTable.columns, 'operNumber', 1)
        if(selectBillDetailRows && selectBillDetailRows.length>0) {
          let listEx = []
          for(let j=0; j<selectBillDetailRows.length; j++) {
            let info = selectBillDetailRows[j];
            info.linkId = info.id
            listEx.push(info)
            this.changeColumnShow(info)
          }
          this.materialTable.dataSource = listEx
          this.$nextTick(() => {
            this.form.setFieldsValue({
              'organId': organId,
              'linkNumber': linkNumber,
              'remark': remark
            })
          })
          //判断后进行仓库的切换
          if(depotId) {
            console.log("===========判断后进行仓库的切换")
            setTimeout(function () {
              that.batchSetDepotModalFormOk(depotId)
            },1000)
          }
        }
      }
    }
  }
</script>
<style scoped>

</style>