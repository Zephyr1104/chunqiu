<template>
  <j-modal :title="title" :width="width" :visible="visible" :confirmLoading="confirmLoading" :keyboard="false"
    :forceRender="true" switchFullscreen @cancel="handleCancel" style="top:20px;height: 95%;">
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
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
              <j-date v-decorator="['operTime', validatorRules.operTime]" :show-time="true" />
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
              <a-input placeholder="请输入单据编号" v-decorator.trim="['number']" :readOnly="true" />
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="批量导入" data-step="3" data-title="批量导入">
              <a-button type="primary" @click="onImportTransfer(prefixNo)"><a-icon type="import" />导入调拨出库信息</a-button>
            </a-form-item>
          </a-col>
          <a-col :lg="6" :md="12" :sm="24"></a-col>
        </a-row>
        <j-editable-table id="billModal" :ref="refKeys[0]" :loading="materialTable.loading"
          :columns="materialTable.columns" :dataSource="materialTable.dataSource" :minWidth="minWidth" :maxHeight="300"
          :rowNumber="false" :rowSelection="true" :actionButton="true" :dragSortAndNumber="true"
          @valueChange="onValueChange" @added="onAdded" @deleted="onDeleted">
          <template #buttonAfter>
            <a-row :gutter="24" style="float:left;" data-step="4" data-title="扫码录入" data-intro="此功能支持扫码枪扫描商品条码进行录入">
              <a-col v-if="scanStatus" :md="6" :sm="24">
                <a-button @click="scanEnter">扫码录入</a-button>
              </a-col>
              <a-col v-if="!scanStatus" :md="16" :sm="24" style="padding: 0 6px 0 12px">
                <a-input placeholder="请扫描商品条码并回车" v-model="scanBarCode" @pressEnter="scanPressEnter"
                  ref="scanBarCode" />
              </a-col>
              <a-col v-if="!scanStatus" :md="6" :sm="24" style="padding: 0px">
                <a-button @click="stopScan">收起扫码</a-button>
              </a-col>
            </a-row>
          </template>
          <template #depotBatchSet>
            <a-icon type="down" @click="handleBatchSetDepot" />
          </template>
          <template #mealBatchSet>
            <a-icon type="down" @click="handleBatchSetMeal" />
          </template>
          <template #anotherDepotBatchSet>
            <a-icon type="down" @click="handleBatchSetAnotherDepot" />
          </template>
          <template #depotAdd>
            <a-divider v-if="isTenant" style="margin: 4px 0;" />
            <div v-if="isTenant" style="padding: 4px 8px; cursor: pointer;" @click="addDepot"><a-icon type="plus" />
              新增仓库</div>
          </template>
        </j-editable-table>
        <a-row class="form-row" :gutter="24">
          <a-col :lg="24" :md="24" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label="">
              <a-textarea :rows="1" placeholder="请输入备注" v-decorator="['remark']" style="margin-top:8px;" />
            </a-form-item>
          </a-col>
        </a-row>
        <a-row class="form-row" :gutter="24">
          <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="附件">
              <j-upload v-model="fileList" bizPath="bill"></j-upload>
            </a-form-item>
          </a-col>
        </a-row>
      </a-form>
    </a-spin>
    <depot-modal ref="depotModalForm" @ok="depotModalFormOk"></depot-modal>
    <meal-modal ref="mealModalForm" @ok="mealModalFormOk"></meal-modal>
    <batch-set-depot ref="batchSetDepotModalForm" @ok="batchSetDepotModalFormOk"></batch-set-depot>
    <batch-set-meal ref="batchSetMealModalForm" @ok="batchSetMealModalFormOk"></batch-set-meal>
    <batch-set-another-depot ref="batchSetAnotherDepotModalForm"
      @ok="batchSetAnotherDepotModalFormOk"></batch-set-another-depot>
    <workflow-iframe ref="modalWorkflow"></workflow-iframe>
    <ImportTransferModal ref="importTransferModal" @ok="importTransferModalOk"></ImportTransferModal>
  </j-modal>
</template>
<script>
import ImportTransferModal from '../dialog/ImportTransferModal'
import pick from 'lodash.pick'
import DepotModal from '../../system/modules/DepotModal'
import MealModal from '../../system/modules/MealModal'
import BatchSetDepot from '../dialog/BatchSetDepot'
import BatchSetMeal from '../dialog/BatchSetMeal'
import BatchSetAnotherDepot from '../dialog/BatchSetAnotherDepot'
import WorkflowIframe from '@/components/tools/WorkflowIframe'
import { FormTypes } from '@/utils/JEditableTableUtil'
import { JEditableTableMixin } from '@/mixins/JEditableTableMixin'
import { BillModalMixin } from '../mixins/BillModalMixin'
import { getMpListShort } from "@/utils/util"
import JUpload from '@/components/jeecg/JUpload'
import JDate from '@/components/jeecg/JDate'
import Vue from 'vue'
export default {
  name: "AllocationOutModal",
  mixins: [JEditableTableMixin, BillModalMixin],
  components: {
    ImportTransferModal,
    DepotModal,
    MealModal,
    BatchSetDepot,
    BatchSetMeal,
    BatchSetAnotherDepot,
    WorkflowIframe,
    JUpload,
    JDate
  },
  data() {
    return {
      title: "操作",
      width: '1600px',
      moreStatus: false,
      // 新增时子表默认添加几行空数据
      addDefaultRowNum: 1,
      visible: false,
      operTimeStr: '',
      prefixNo: 'DBCK',
      fileList: [],
      model: {},
      labelCol: {
        xs: { span: 24 },
        sm: { span: 8 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 16 },
      },
      refKeys: ['materialDataTable',],
      activeKey: 'materialDataTable',
      materialTable: {
        loading: false,
        dataSource: [],
        columns: [
          {
            title: '仓库名称', key: 'depotId', width: '8%', type: FormTypes.select, placeholder: '请选择${title}', options: [],
            allowSearch: true, validateRules: [{ required: true, message: '${title}不能为空' }]
          },
          {
            title: '条码', key: 'barCode', width: '12%', type: FormTypes.popupJsh, kind: 'material', multi: true,
            validateRules: [{ required: true, message: '${title}不能为空' }]
          },
          { title: '名称', key: 'name', width: '10%', type: FormTypes.normal },
          {
            title: '餐次选择', key: 'mealId', width: '8%', type: FormTypes.select, placeholder: '请选择${title}', options: [],
          },
          { title: '规格', key: 'standard', width: '9%', type: FormTypes.normal },
          { title: '型号', key: 'model', width: '9%', type: FormTypes.normal },
          { title: '颜色', key: 'color', width: '5%', type: FormTypes.normal },
          { title: '扩展信息', key: 'materialOther', width: '5%', type: FormTypes.normal },
          { title: '库存', key: 'stock', width: '5%', type: FormTypes.normal },
          {
            title: '调入仓库', key: 'anotherDepotId', width: '8%', type: FormTypes.select, placeholder: '请选择${title}', options: [],
            allowSearch: true, validateRules: [{ required: true, message: '${title}不能为空' }]
          },
          { title: '单位', key: 'unit', width: '4%', type: FormTypes.normal },
          { title: '多属性', key: 'sku', width: '9%', type: FormTypes.normal },
          {
            title: '数量', key: 'operNumber', width: '5%', type: FormTypes.inputNumber, statistics: true,
            validateRules: [{ required: true, message: '${title}不能为空' }]
          },
          { title: '单价', key: 'unitPrice', width: '5%', type: FormTypes.inputNumber },
          { title: '金额', key: 'allPrice', width: '5%', type: FormTypes.inputNumber, statistics: true },
          { title: '备注', key: 'remark', width: '5%', type: FormTypes.input }
        ]
      },
      confirmLoading: false,
      validatorRules: {
        operTime: {
          rules: [
            { required: true, message: '请输入单据日期!' }
          ]
        },
        type: {
          rules: [
            { required: true, message: '请选择类型!' }
          ]
        }
      },
      url: {
        add: '/depotHead/addDepotHeadAndDetail',
        edit: '/depotHead/updateDepotHeadAndDetail',
        detailList: '/depotItem/getDetailList'
      }
    }
  },
  created() {
  },
  methods: {
    //调用完edit()方法之后会自动调用此方法
    editAfter() {
      this.billStatus = '0'
      this.currentSelectDepotId = ''
      this.changeColumnHide()
      this.changeFormTypes(this.materialTable.columns, 'snList', 0)
      this.changeFormTypes(this.materialTable.columns, 'batchNumber', 0)
      this.changeFormTypes(this.materialTable.columns, 'expirationDate', 0)
      if (this.action === 'add') {
        this.addInit(this.prefixNo)
        this.fileList = []
      } else {
        this.model.operTime = this.model.operTimeStr
        this.fileList = this.model.fileName
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'organId', 'operTime', 'number', 'remark',
            'discount', 'discountMoney', 'discountLastMoney', 'otherMoney', 'accountId', 'changeAmount'))
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
      if (this.action === 'copyAdd') {
        this.model.id = ''
        this.model.tenantId = ''
        this.copyAddInit(this.prefixNo)
      }
      this.initSystemConfig()
      this.initDepot()
      this.initMeal()
    },
    //提交单据时整理成formData
    classifyIntoFormData(allValues) {
      let totalPrice = 0
      let billMain = Object.assign(this.model, allValues.formValue)
      let detailArr = allValues.tablesValue[0].values
      billMain.type = '出库'
      billMain.subType = '调拨'
      billMain.defaultNumber = billMain.number
      for (let item of detailArr) {
        totalPrice += item.allPrice - 0
      }
      billMain.totalPrice = totalPrice
      if (this.fileList && this.fileList.length > 0) {
        billMain.fileName = this.fileList
      } else {
        billMain.fileName = ''
      }
      if (this.model.id) {
        billMain.id = this.model.id
      }
      billMain.status = this.billStatus
      return {
        info: JSON.stringify(billMain),
        rows: JSON.stringify(detailArr),
      }
    },
  }
}
</script>
<style scoped></style>