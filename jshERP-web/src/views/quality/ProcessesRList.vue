<!-- by zzl -->
<template>
  <a-row :gutter="24">
    <a-col :md="24">
      <a-card :style="cardStyle" :bordered="false">
        <!-- 查询区域 -->
        <div class="table-page-search-wrapper">
          <!-- 搜索区域 -->
          <a-form layout="inline" @keyup.enter.native="searchQuery">
            <a-row :gutter="24">
              <a-col :md="6" :sm="24">
                <a-form-item label="报告编号" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-input placeholder="请输入报告编号" v-model="queryParam.qualityNo"></a-input>
                </a-form-item>
              </a-col>
              <a-col :md="6" :sm="24">
                <a-form-item label="创建日期" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-range-picker
                    style="width:100%"
                    v-model="queryParam.createTime"
                    format="YYYY-MM-DD"
                    :placeholder="['开始时间', '结束时间']"
                    @change="onDateChange"
                    @ok="onDateOk"
                  />
                </a-form-item>
              </a-col>
              <a-col :md="6" :sm="24">
                <a-form-item label="供应商" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-select placeholder="选择供应商" showSearch optionFilterProp="children" v-model="queryParam.organId">
                    <a-select-option v-for="(item,index) in organList" :key="index" :value="item.organId">
                      {{ item.supplier }}
                    </a-select-option>
                  </a-select>
                </a-form-item>
              </a-col>
              <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
                <a-col :md="6" :sm="24">
                  <a-button type="primary" @click="searchQuery">查询</a-button>
                  <a-button style="margin-left: 8px" @click="searchReset">重置</a-button>
                  <a @click="handleToggleSearch" style="margin-left: 8px">
                    {{ toggleSearchStatus ? '收起' : '展开' }}
                    <a-icon :type="toggleSearchStatus ? 'up' : 'down'"/>
                  </a>
                </a-col>
              </span>
              <template v-if="toggleSearchStatus">
                <a-col :md="6" :sm="24">
                  <a-form-item label="操作人员" :labelCol="labelCol" :wrapperCol="wrapperCol">
                    <a-select placeholder="选择操作人员" showSearch optionFilterProp="children" v-model="queryParam.creator">
                      <a-select-option v-for="(item,index) in userList" :key="index" :value="item.creator">
                        {{ item.userName }}
                      </a-select-option>
                    </a-select>
                  </a-form-item>
                </a-col>
                <a-col :md="6" :sm="24">
                  <a-form-item label="审核人员" :labelCol="labelCol" :wrapperCol="wrapperCol">
                    <a-select placeholder="选择审核人员" showSearch optionFilterProp="children" v-model="queryParam.handsPersonId">
                      <a-select-option v-for="(item,index) in personList" :key="index" :value="item.auditor">
                        {{ item.name }}
                      </a-select-option>
                    </a-select>
                  </a-form-item>
                </a-col>
                <a-col :md="6" :sm="24">
                  <a-form-item label="仓库" :labelCol="labelCol" :wrapperCol="wrapperCol">
                    <a-select placeholder="选择仓库" showSearch optionFilterProp="children" v-model="queryParam.depotId">
                      <a-select-option v-for="(item,index) in accountList" :key="index" :value="item.id">
                        {{ item.name }}
                      </a-select-option>
                    </a-select>
                  </a-form-item>
                </a-col>
                <a-col :md="6" :sm="24">
                  <a-form-item label="报告状态" :labelCol="labelCol" :wrapperCol="wrapperCol">
                    <a-select placeholder="选择报告状态" v-model="queryParam.status">
                      <a-select-option value="0">未审核</a-select-option>
                      <a-select-option value="1">已审核</a-select-option>
                    </a-select>
                  </a-form-item>
                </a-col>
                <a-col :md="6" :sm="24">
                  <a-form-item label="报告备注" :labelCol="labelCol" :wrapperCol="wrapperCol">
                    <a-input placeholder="请输入报告备注" v-model="queryParam.remark"></a-input>
                  </a-form-item>
                </a-col>
              </template>
            </a-row>
          </a-form>
        </div>
        <!-- 操作按钮区域 -->
        <div class="table-operator"  style="margin-top: 5px">
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="myHandleAdd" type="primary" icon="plus">新增</a-button>
          <a-button v-if="btnEnableList.indexOf(1)>-1" icon="delete" @click="batchDel">删除</a-button>
          <a-button v-if="checkFlag && btnEnableList.indexOf(2)>-1" icon="check" @click="batchSetStatus(1)">审核</a-button>
          <a-button v-if="checkFlag && btnEnableList.indexOf(7)>-1" icon="stop" @click="batchSetStatus(0)">反审核</a-button>
          <a-button v-if="isShowExcel && btnEnableList.indexOf(3)>-1" icon="download" @click="handleExport">导出</a-button>
          <a-tooltip placement="left" title="工序质检单主要处理一些质检部门提供的工序质检报告单，便于食材加工报告溯源以及应对上级主管部门检查等。" slot="action">
            <a-icon v-if="btnEnableList.indexOf(1)>-1" type="question-circle" style="font-size:20px;float:right;" />
          </a-tooltip>
        </div>
        <!-- table区域-begin -->
        <div>
          <a-table
            ref="table"
            size="middle"
            bordered
            rowKey="id"
            :columns="columns"
            :dataSource="dataSource"
            :components="handleDrag(columns)"
            :pagination="ipagination"
            :scroll="scroll"
            :loading="loading"
            :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
            @change="handleTableChange">
            <span slot="action" slot-scope="text, record">
              <a @click="myHandleDetail(record, '工序质检报告', prefixNo)">查看</a>
              <a-divider v-if="btnEnableList.indexOf(1)>-1" type="vertical" />
              <a v-if="btnEnableList.indexOf(1)>-1" @click="myHandleEdit(record)">编辑</a>
              <a-divider v-if="btnEnableList.indexOf(1)>-1" type="vertical" />
              <a v-if="btnEnableList.indexOf(1)>-1" @click="myHandleCopyAdd(record)">复制</a>
              <a-divider v-if="btnEnableList.indexOf(1)>-1" type="vertical" />
              <a-popconfirm v-if="btnEnableList.indexOf(1)>-1" title="确定删除吗?" @confirm="() => myHandleDelete(record)">
                <a>删除</a>
              </a-popconfirm>
            </span>
            <template slot="customRenderStatus" slot-scope="status">
              <a-tag v-if="status == '0'" color="red">未审核</a-tag>
              <a-tag v-if="status == '1'" color="green">已审核</a-tag>
              <a-tag v-if="status == '9'" color="orange">审核中</a-tag>
            </template>
          </a-table>
        </div>
        <!-- table区域-end -->
        <!-- 表单区域 -->
        <processesR-modal ref="modalForm" @ok="modalFormOk" @close="modalFormClose"></processesR-modal>
      </a-card>
    </a-col>
  </a-row>
</template>
<script>
  import ProcessesRModal from './modules/ProcessesRModal'
  import FinancialDetail from '@/views/financial/dialog/FinancialDetail'
  import BillExcelIframe from '@/components/tools/BillExcelIframe'
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'
  import JDate from '@/components/jeecg/JDate'
  import { FinancialListMixin } from '@/views/financial/mixins/FinancialListMixin'
  import Vue from 'vue'
  export default {
    name: "ProcessesRList",
    mixins:[JeecgListMixin,FinancialListMixin],
    components: {
      ProcessesRModal,
      FinancialDetail,
      BillExcelIframe,
      JDate
    },
    data () {
      return {
        labelCol: {
          span: 5
        },
        wrapperCol: {
          span: 18,
          offset: 1
        },
        // 查询条件
        queryParam: {
          qualityNo: "",
          createTime: "",
          type: "工序",
          organId: "",
          creator: "",
          auditor: "",
          depotId: "",
          status: "",
          remark: ""
        },
        prefixNo: 'GX',
        // 表头
        columns: [
          {
            title: '操作',
            dataIndex: 'action',
            width:200,
            align:"center",
            scopedSlots: { customRender: 'action' },
          },
          { title: '检测单位', dataIndex: 'organName', align:"center",width:140, ellipsis:true},
          { title: '质检报告编号', dataIndex: 'qualityNo', align:"center",width:160},
          { title: '质检报告名称', dataIndex: 'qualityName', align:"center",width:160},
          { title: '报告日期 ', dataIndex: 'qualityTime', align:"center",width:160},
          { title: '商品编号', dataIndex: 'materialId', align:"center",width:160},
          { title: '商品名称', dataIndex: 'materialName', align:"center",width:160},
          { title: '数量', dataIndex: 'operNumber', align:"center",width:160},
          { title: '计量单位', dataIndex: 'materialUnit', align:"center",width:80},
          { title: '仓库', dataIndex: 'depotName', align:"center",width:80},
          { title: '采购单号', dataIndex: 'linkNumber', align:"center",width:160},
          { title: '批次号', dataIndex: 'batchNumber', align:"center",width:60},
          { title: '操作人员', dataIndex: 'userName', align:"center",width:100, ellipsis:true},
          { title: '审核人员', dataIndex: 'auditorName', align:"center",width:100},
          { title: '备注', dataIndex: 'remark', align:"center",width:200},
          { title: '状态', dataIndex: 'status', width: 80, align: "center",
            scopedSlots: { customRender: 'customRenderStatus' }
          }
        ],
        url: {
          list: "/materialR/list",
          delete: "/materialR/delete",
          deleteBatch: "/materialR/deleteBatch",
          batchSetStatusUrl: "/materialR/batchSetStatus"
        }
      }
    },
    computed: {
    },
    created () {
      this.initSystemConfig()
      this.initOrgan()
      this.initUser()
      this.initPerson()
      this.initAccount()
    },
    methods: {
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>