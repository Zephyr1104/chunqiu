<template>
  <j-modal :title="title" :width="width" :visible="visible" :maskClosable="false" :keyboard="false" :forceRender="true"
    :style="modalStyle" @cancel="handleCancel" wrapClassName="ant-modal-cust-warp">
    <template slot="footer">
      <!--此处为解决缓存问题-->
      <a-button @click="Print()">针式打印机</a-button>
      <a-button v-if="financialType === '收预付款'" v-print="'#advanceInPrint'" ghost type="primary">打印</a-button>
      <a-button v-if="financialType === '转账'" v-print="'#giroPrint'" ghost type="primary">打印</a-button>
      <a-button v-if="financialType === '收入'" v-print="'#itemInPrint'" ghost type="primary">打印</a-button>
      <a-button v-if="financialType === '支出'" v-print="'#itemOutPrint'" ghost type="primary">打印</a-button>
      <a-button v-if="financialType === '收款'" v-print="'#moneyInPrint'" ghost type="primary">打印</a-button>
      <a-button v-if="financialType === '付款'" v-print="'#moneyOutPrint'" ghost type="primary">打印</a-button>
      <!-- 导出Excel -->
      <a-button v-if="financialType === '支出'" @click="itemOutExportExcel()">导出</a-button>
      <!--反审核-->
      <a-button v-if="checkFlag && isCanBackCheck && model.status === '1'" @click="handleBackCheck()">反审核</a-button>
      <a-button key="back" @click="handleCancel">取消</a-button>
    </template>
    <a-form :form="form">
      <!--收预付款-->
      <template v-if="financialType === '收预付款'">
        <section ref="print" id="advanceInPrint">
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="付款会员">
                <a-input v-decorator="['id']" hidden />
                {{ model.organName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                {{ model.handsPersonName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{ model.billTimeStr }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{ model.billNo }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="advanceInColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="合计金额">
                {{ model.totalPrice }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="收款金额">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
            <a-col :span="6"></a-col>
            <a-col :span="6"></a-col>
            <a-col :span="6"></a-col>
          </a-row>
        </section>
      </template>
      <!--转账-->
      <template v-if="financialType === '转账'">
        <section ref="print" id="giroPrint">
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                <a-input v-decorator="['id']" hidden />
                {{ model.handsPersonName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{ model.billTimeStr }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{ model.billNo }}
              </a-form-item>
            </a-col>
            <a-col :span="6"></a-col>
          </a-row>
          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="giroColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="付款账户">
                {{ model.accountName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="实付金额">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
            <a-col :span="6"></a-col>
            <a-col :span="6"></a-col>
          </a-row>
        </section>
      </template>
      <!--收入-->
      <template v-if="financialType === '收入'">
        <section ref="print" id="itemInPrint">
          <!-- <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="往来单位">
                <a-input v-decorator="['id']" hidden/>
                {{model.organName}}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                {{model.handsPersonName}}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{model.billTimeStr}}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{model.billNo}}
              </a-form-item>
            </a-col>
          </a-row> -->

          <div style="width:210mm;text-align: center;font-size: 25px;">广东厨誉餐饮管理有限公司财务收入单</div>

          <div style="width:210mm;display:flex;justify-content: space-between;">
            <div style="display:flex;flex-direction:column;">
              <span>往来单位: <a-input v-decorator="['id']" hidden />
                {{ model.organName }}</span>
              <span>单据日期:{{ model.billTimeStr }}</span>
            </div>
            <div style="display:flex;flex-direction:column;">
              <span>财务人员:{{ model.handsPersonName }}</span>
              <span>单据编号:{{ model.billNo }}</span>
            </div>
          </div>

          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="itemInColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>

          <div style="width:210mm;display: flex;justify-content: space-between;font-size: 19px;">
            <div style="display: flex;flex-direction: column;">
              <span :span="6">收入账户:{{ model.accountName }}</span>
            </div>
            <div style="display: flex;flex-direction: column;"></div>
            <div style="display: flex;flex-direction: column;">
              <span :span="6">收入金额:{{ model.changeAmount }}</span>
            </div>
          </div>

          <!-- <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="收入账户">
                {{ model.accountName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="收入金额">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
            <a-col :span="6"></a-col>
            <a-col :span="6"></a-col>
          </a-row> -->
        </section>
      </template>
      <!--支出-->
      <template v-if="financialType === '支出'">
        <section ref="print" id="itemOutPrint">
          <!-- <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="往来单位">
                <a-input v-decorator="['id']" hidden />
                {{ model.organName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                {{ model.handsPersonName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{ model.billTimeStr }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{ model.billNo }}
              </a-form-item>
            </a-col>
          </a-row> -->

          <div style="width:210mm;text-align: center;font-size: 25px;">广东厨誉餐饮管理有限公司财务支出单</div>

          <div style="width:210mm;display:flex;justify-content: space-between;">
            <div style="display:flex;flex-direction:column;">
              <span>往来单位: <a-input v-decorator="['id']" hidden />
                {{ model.organName }}</span>
              <span>单据日期:{{ model.billTimeStr }}</span>
            </div>
            <div style="display:flex;flex-direction:column;">
              <span>财务人员:{{ model.handsPersonName }}</span>
              <span>单据编号:{{ model.billNo }}</span>
            </div>
          </div>

          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="itemOutColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>

          <div style="width:210mm;display: flex;justify-content: space-between;font-size: 19px;">
            <div style="display: flex;flex-direction: column;">
              <span :span="6">支出账户:{{ model.accountName }}</span>
            </div>
            <div style="display: flex;flex-direction: column;"></div>
            <div style="display: flex;flex-direction: column;">
              <span :span="6">支出余额:{{ model.changeAmount }}</span>
            </div>
          </div>

          <!-- <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="支出账户">
                {{ model.accountName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="支出金额">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
            <a-col :span="6"></a-col>
            <a-col :span="6"></a-col>
          </a-row> -->
        </section>
      </template>
      <!--收款-->
      <template v-if="financialType === '收款'">
        <section ref="print" id="moneyInPrint">
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="客户">
                <a-input v-decorator="['id']" hidden />
                {{ model.organName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                {{ model.handsPersonName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{ model.billTimeStr }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{ model.billNo }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="moneyInColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="收款账户">
                {{ model.accountName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="合计收款">
                {{ model.totalPrice }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="优惠金额">
                {{ model.discountMoney }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="实际收款">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
          </a-row>
        </section>
      </template>
      <!--付款-->
      <template v-if="financialType === '付款'">
        <section ref="print" id="moneyOutPrint">
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="供应商">
                <a-input v-decorator="['id']" hidden />
                {{ model.organName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="财务人员">
                {{ model.handsPersonName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据日期">
                {{ model.billTimeStr }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单据编号">
                {{ model.billNo }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-table ref="table" size="middle" bordered rowKey="id" :pagination="false" :loading="loading"
            :columns="moneyOutColumns" :dataSource="dataSource">
          </a-table>
          <a-row class="form-row" :gutter="24">
            <a-col :lg="24" :md="24" :sm="24">
              <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label=""
                style="padding:20px 10px;">
                {{ model.remark }}
              </a-form-item>
            </a-col>
          </a-row>
          <a-row class="form-row" :gutter="24">
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="付款账户">
                {{ model.accountName }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="合计付款">
                {{ model.totalPrice }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="优惠金额">
                {{ model.discountMoney }}
              </a-form-item>
            </a-col>
            <a-col :span="6">
              <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="实际付款">
                {{ model.changeAmount }}
              </a-form-item>
            </a-col>
          </a-row>
        </section>
      </template>
      <template v-if="fileList && fileList.length > 0">
        <a-row class="form-row" :gutter="24">
          <a-col :span="12">
            <a-form-item :labelCol="{ xs: { span: 24 }, sm: { span: 3 } }"
              :wrapperCol="{ xs: { span: 24 }, sm: { span: 21 } }" label="附件">
              <j-upload v-model="fileList" bizPath="bill" :disabled="true" :buttonVisible="false"></j-upload>
            </a-form-item>
          </a-col>
          <a-col :span="12"></a-col>
        </a-row>
      </template>
    </a-form>
  </j-modal>
</template>
<script>
import pick from 'lodash.pick'
import { getAction, postAction } from '@/api/manage'
import { findFinancialDetailByNumber, getCurrentSystemConfig } from '@/api/api'
import { getCheckFlag,exportXlsPost } from '@/utils/util'
import JUpload from '@/components/jeecg/JUpload'

export default {
  name: 'FinancialDetail',
  components: {
    JUpload
  },
  data() {
    return {
      title: "详情",
      width: '1600px',
      visible: false,
      modalStyle: '',
      model: {},
      isCanBackCheck: true,
      financialType: '',
      fileList: [],
      /* 原始反审核是否开启 */
      checkFlag: true,
      labelCol: {
        xs: { span: 24 },
        sm: { span: 6 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 16 },
      },
      form: this.$form.createForm(this),
      loading: false,
      dataSource: [],
      url: {
        detailList: '/accountItem/getDetailList',
        batchSetStatusUrl: '/accountHead/batchSetStatus'
      },
      advanceInColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '账户名称', dataIndex: 'accountName', width: '30%' },
        { title: '金额', dataIndex: 'eachAmount', width: '30%' },
        { title: '备注', dataIndex: 'remark', width: '30%' }
      ],
      giroColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '账户名称', dataIndex: 'accountName', width: '30%' },
        { title: '金额', dataIndex: 'eachAmount', width: '30%' },
        { title: '备注', dataIndex: 'remark', width: '30%' }
      ],
      itemInColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '收入项目', dataIndex: 'inOutItemName', width: '30%' },
        { title: '金额', dataIndex: 'eachAmount', width: '30%' },
        { title: '备注', dataIndex: 'remark', width: '30%' }
      ],
      itemOutColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '支出项目', dataIndex: 'inOutItemName', width: '30%' },
        { title: '金额', dataIndex: 'eachAmount', width: '30%' },
        { title: '备注', dataIndex: 'remark', width: '30%' }
      ],
      moneyInColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '销售单据编号', dataIndex: 'billNumber', width: '20%' },
        { title: '应收欠款', dataIndex: 'needDebt', width: '10%' },
        { title: '已收欠款', dataIndex: 'finishDebt', width: '10%' },
        { title: '本次收款', dataIndex: 'eachAmount', width: '10%' },
        { title: '备注', dataIndex: 'remark', width: '20%' }
      ],
      moneyOutColumns: [
        { title: '#', dataIndex: '', width: '5%', align: 'center', customRender: function (t, r, index) { return parseInt(index) + 1; } },
        { title: '采购单据编号', dataIndex: 'billNumber', width: '20%' },
        { title: '应付欠款', dataIndex: 'needDebt', width: '10%' },
        { title: '已付欠款', dataIndex: 'finishDebt', width: '10%' },
        { title: '本次付款', dataIndex: 'eachAmount', width: '10%' },
        { title: '备注', dataIndex: 'remark', width: '20%' }
      ],
    }
  },
  created() {
    let realScreenWidth = window.screen.width
    this.width = realScreenWidth < 1500 ? '1200px' : '1550px'
  },
  methods: {
    show(record, type, prefixNo) {
      //查询单条财务信息
      findFinancialDetailByNumber({ billNo: record.billNo }).then((res) => {
        if (res && res.code === 200) {
          let item = res.data
          this.financialType = type
          this.prefixNo = prefixNo
          //附件下载
          this.fileList = item.fileName
          this.visible = true
          this.modalStyle = 'top:20px;height: 95%;'
          this.model = Object.assign({}, item)
          this.$nextTick(() => {
            this.form.setFieldsValue(pick(this.model, 'id'))
          });
          let params = {
            headerId: this.model.id,
          }
          let url = this.readOnly ? this.url.detailList : this.url.detailList;
          this.requestSubTableData(url, params);
          this.getSystemConfig()
        }
      })
    },
    requestSubTableData(url, params, success) {
      this.loading = true
      getAction(url, params).then(res => {
        if (res && res.code === 200) {
          this.dataSource = res.data.rows
          typeof success === 'function' ? success(res) : ''
        }
      }).finally(() => {
        this.loading = false
      })
    },
    getSystemConfig() {
      getCurrentSystemConfig().then((res) => {
        if (res.code === 200 && res.data) {
          let multiBillType = res.data.multiBillType
          let multiLevelApprovalFlag = res.data.multiLevelApprovalFlag
          this.checkFlag = getCheckFlag(multiBillType, multiLevelApprovalFlag, this.prefixNo)
        }
      })
    },
    handleBackCheck() {
      let that = this
      this.$confirm({
        title: "确认操作",
        content: "是否对该单据进行反审核?",
        onOk: function () {
          that.loading = true
          postAction(that.url.batchSetStatusUrl, { status: '0', ids: that.model.id }).then((res) => {
            if (res.code === 200) {
              that.$emit('ok')
              that.loading = false
              that.close()
            } else {
              that.$message.warning(res.data.message)
              that.loading = false
            }
          }).finally(() => {
          })
        }
      })
    },
    handleCancel() {
      this.close()
    },
    close() {
      this.$emit('close')
      this.visible = false
      this.modalStyle = ''
    },
    // 支出导出excel
    itemOutExportExcel(){
      let list = []
      let head = '支出项目,金额,备注'
      for (let i = 0; i < this.dataSource.length; i++) {
        let item = []
        let ds = this.dataSource[i]
        item.push(ds.inOutItemName,ds.eachAmount,ds.remark)
        list.push(item)
      }
      console.log(this.model);
      let tip = '单据日期：' + this.model.billTimeStr + '，单据编号：' + this.model.billNo +',往来单位:' +this.model.organName
      exportXlsPost(this.model.type + '_' + this.model.billNo, '单据导出', head, tip, list)
    },
    Print() {
      // 创建一个隐藏的iframe
      const iframe = document.createElement('iframe');
      iframe.style.display = 'none';
      document.body.appendChild(iframe);

      // 获取要打印的内容
      const printContent = this.$refs.print;
      console.log(printContent.innerHTML);

      // 访问要打印的页面
      iframe.contentWindow.document.open();
      iframe.contentWindow.document.write(`
        <html>
        <head>
            <style>
            /* 在这里修改打印的CSS样式 */
            @page {
              size: A5; /* 设置纸张尺寸为A5 */
              margin: 0mm; /* 设置页面边距为0毫米 */
              size: auto; /* 设置页面宽度自动调整以适应内容 */
            //   orientation: landscape; /* 设置页面方向为横向 */
            }
            
            body { 
                font-family: Microsoft YaHei;
                color: #000;
                overflow: hidden;
            }

              /* 表格样式设置 */
            table {
                width:210mm; /* 设置表格宽度固定为 */
                font-size: 15px; /* 设置表格字体大小为 12 像素 */
                border: 2px solid #000000;
                border-collapse: collapse;
            }
            th, td {
                border: 2px solid #000000;
                border-collapse: collapse;
                padding: 5px;
            }
            </style>
            
        </head>
        <body>
            ${printContent.innerHTML}
        </body>
        </html>
    `);
      iframe.contentWindow.document.close();

      // 打印访问的页面
      iframe.contentWindow.print();
      iframe.contentWindow.close();
    },
  }
}
</script>

<style scoped></style>