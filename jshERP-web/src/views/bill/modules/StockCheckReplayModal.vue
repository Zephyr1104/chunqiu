<template>
    <j-modal :title="title" :width="width" :visible="visible" :confirmLoading="confirmLoading" :keyboard="false"
        :forceRender="true" switchFullscreen @cancel="handleCancel" style="top:20px;height: 95%;">
        <template slot="footer">
            <a-button @click="handleCancel">取消</a-button>
            <a-button v-if="checkFlag && isCanCheck" :loading="confirmLoading"
                @click="handleOkAndCheck">保存并审核</a-button>
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
                        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="关联订单" data-step="3"
                            data-title="关联订单" data-intro="盘点复盘单据可以通过关联订单来选择已录入的盘点录入，选择之后会自动加载订单的内容，
            提交之后原来的盘点录入会对应的改变单据状态。另外本系统支持分批多次关联">
                            <a-input-search placeholder="请选择关联盘点录入" v-decorator="['linkNumber']"
                                @search="onSearchLinkNumber" :readOnly="true" />
                        </a-form-item>
                    </a-col>
                    <!-- <a-col :lg="6" :md="12" :sm="24">
                        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="批量导入" data-step="3"
                            data-title="批量导入">
                            <a-button type="primary"><a-icon type="import" />导入盘点实存信息</a-button>
                        </a-form-item>
                    </a-col> -->
                </a-row>
                <j-editable-table id="billModal" :ref="refKeys[0]" :loading="materialTable.loading"
                    :columns="materialTable.columns" :dataSource="materialTable.dataSource" :minWidth="minWidth"
                    :maxHeight="300" :rowNumber="false" :rowSelection="true" :actionButton="true" :dragSort="true"
                    @valueChange="onValueChange" @added="onAdded" @deleted="onDeleted">
                    <template #buttonAfter>
                        <a-row :gutter="24" style="float:left;" data-step="4" data-title="扫码录入"
                            data-intro="此功能支持扫码枪扫描商品条码进行录入">
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
                    <template #depotAdd>
                        <a-divider v-if="isTenant" style="margin: 4px 0;" />
                        <div v-if="isTenant" style="padding: 4px 8px; cursor: pointer;" @click="addDepot"><a-icon
                                type="plus" /> 新增仓库
                        </div>
                    </template>
                </j-editable-table>
                <a-row class="form-row" :gutter="24">
                    <a-col :lg="24" :md="24" :sm="24">
                        <a-form-item :labelCol="labelCol" :wrapperCol="{ xs: { span: 24 }, sm: { span: 24 } }" label="">
                            <a-textarea :rows="1" placeholder="请输入备注" v-decorator="['remark']"
                                style="margin-top:8px;" />
                        </a-form-item>
                    </a-col>
                </a-row>
            </a-form>
        </a-spin>
        <depot-modal ref="depotModalForm" @ok="depotModalFormOk"></depot-modal>
        <batch-set-depot ref="batchSetDepotModalForm" @ok="batchSetDepotModalFormOk"></batch-set-depot>
        <batch-set-another-depot ref="batchSetAnotherDepotModalForm"
            @ok="batchSetAnotherDepotModalFormOk"></batch-set-another-depot>
        <workflow-iframe ref="modalWorkflow"></workflow-iframe>
        <link-bill-list ref="linkBillList" @ok="linkBillListOk"></link-bill-list>
    </j-modal>
</template>
<script>
import pick from 'lodash.pick'
import DepotModal from '../../system/modules/DepotModal'
import BatchSetDepot from '../dialog/BatchSetDepot'
import BatchSetAnotherDepot from '../dialog/BatchSetDepot'
import WorkflowIframe from '@/components/tools/WorkflowIframe'
import LinkBillList from '../dialog/LinkBillList'
import { FormTypes } from '@/utils/JEditableTableUtil'
import { JEditableTableMixin } from '@/mixins/JEditableTableMixin'
import { BillModalMixin } from '../mixins/BillModalMixin'
import { getMpListShort } from "@/utils/util"
import JUpload from '@/components/jeecg/JUpload'
import JDate from '@/components/jeecg/JDate'
import Vue from 'vue'
export default {
    name: "StockCheckEnterModal",
    mixins: [JEditableTableMixin, BillModalMixin],
    components: {
        LinkBillList,
        DepotModal,
        BatchSetDepot,
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
            prefixNo: 'PDFP',
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
                    { title: '规格', key: 'standard', width: '9%', type: FormTypes.normal },
                    { title: '原库存', key: 'stock', width: '5%', type: FormTypes.normal },
                    { title: '单位', key: 'unit', width: '4%', type: FormTypes.normal },
                    {
                        title: '实存', key: 'currentStock', width: '5%', type: FormTypes.inputNumber, statistics: true,
                        validateRules: [{ required: true, message: '${title}不能为空' }]
                    },
                    {
                        title: '数量', key: 'operNumber', width: '5%', type: FormTypes.inputNumber,
                        validateRules: [{ required: true, message: '${title}不能为空' }]
                    },
                    { title: '单价', key: 'unitPrice', width: '5%', type: FormTypes.inputNumber },
                    { title: '金额', key: 'allPrice', width: '5%', type: FormTypes.inputNumber, statistics: true },
                    { title: '备注', key: 'remark', width: '8%', type: FormTypes.input }
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
        },
        //提交单据时整理成formData
        classifyIntoFormData(allValues) {
            let totalPrice = 0
            let billMain = Object.assign(this.model, allValues.formValue)
            let detailArr = allValues.tablesValue[0].values
            billMain.type = '其它'
            billMain.subType = '盘点复盘'
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
        onSearchLinkNumber() {
            this.$refs.linkBillList.stockShow('其它', '盘点录入', '1')
            this.$refs.linkBillList.title = "选择盘点录入"
        },
        linkBillListOk(selectBillDetailRows, linkNumber, organId) {
            this.rowCanEdit = false
            this.materialTable.columns[0].type = FormTypes.normal
            this.changeFormTypes(this.materialTable.columns, 'preNumber', 1)
            this.changeFormTypes(this.materialTable.columns, 'finishNumber', 1)
            if (selectBillDetailRows && selectBillDetailRows.length > 0) {
                let discountLastMoney = 0
                for (let j = 0; j < selectBillDetailRows.length; j++) {
                    let info = selectBillDetailRows[j];
                    if (info.preNumber) {
                        // 数量
                        info.operNumber = info.preNumber - info.finishNumber
                        // 实存
                        info.currentStock = info.stock + info.preNumber

                        info.unitPrice = info.purchaseDecimal
                        info.allPrice = (info.operNumber * info.unitPrice).toFixed(2) - 0;
                        info.taxRate = 0
                        info.taxMoney = 0
                        info.taxLastMoney = info.allPrice
                        discountLastMoney += info.allPrice
                    }
                    info.linkId = info.id
                }
                this.$nextTick(() => {
                    this.form.setFieldsValue({
                        'linkNumber': linkNumber
                    })
                })
                //给优惠后金额重新赋值
                discountLastMoney = discountLastMoney ? discountLastMoney : 0
                this.$nextTick(() => {
                    this.form.setFieldsValue({
                        'discountLastMoney': discountLastMoney.toFixed(2),
                        'changeAmount': discountLastMoney
                    })
                })
                this.materialTable.dataSource = selectBillDetailRows
            }
        },

    }
}
</script>
<style scoped></style>