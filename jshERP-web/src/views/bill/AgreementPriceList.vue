<!-- f r o m 7 5  2 7 1  8 9 2 0 -->
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
                <a-form-item label="协议单号" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-input placeholder="请输入协议单号查询" v-model="queryParam.batch_number"></a-input>
                </a-form-item>
              </a-col>
              <a-col :md="6" :sm="24">
                <a-form-item label="商品编码" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-input placeholder="请输入商品编码查询" v-model="queryParam.material_id"></a-input>
                </a-form-item>
              </a-col>
              <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
                <a-col :md="6" :sm="24">
                  <a-button type="primary" @click="searchQuery">查询</a-button>
                  <a-button style="margin-left: 8px" @click="searchReset">重置</a-button>
                </a-col>
              </span>
              <a-col :lg="6" :md="12" :sm="24">
            <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="批量导入" data-step="3" data-title="批量导入">
              <a-button type="primary" @click="onImportAgreementPrice(prefixNo)"><a-icon type="import" />导入采购协议价信息</a-button>
            </a-form-item>
          </a-col>
            </a-row>
          </a-form>
        </div>
        <!-- 操作按钮区域 -->
        <div class="table-operator"  style="margin-top: 5px">
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="handleAdd" type="primary" icon="plus">新增</a-button>
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="batchDel" icon="delete">删除</a-button>
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="batchSetStatus(true)" icon="check-square">启用</a-button>
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="batchSetStatus(false)" icon="close-square">禁用</a-button>
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
            :pagination="ipagination"
            :scroll="scroll"
            :loading="loading"
            :rowSelection="{selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
            @change="handleTableChange">
            <span slot="action" slot-scope="text, record">
              <a-popconfirm v-if="btnEnableList.indexOf(1)>-1" title="确定设为默认吗?" @confirm="() => handleSetDefault(record.id)">
                <a>设为默认</a>
              </a-popconfirm>
              <a-divider v-if="btnEnableList.indexOf(1)>-1" type="vertical" />
              <a @click="handleEdit(record)">编辑</a>
              <a-divider v-if="btnEnableList.indexOf(1)>-1" type="vertical" />
              <a-popconfirm v-if="btnEnableList.indexOf(1)>-1" title="确定删除吗?" @confirm="() => handleDelete(record.id)">
                <a>删除</a>
              </a-popconfirm>
            </span>
            <!-- 状态渲染模板 -->
            <template slot="customRenderEnabledFlag" slot-scope="enabled">
              <a-tag v-if="enabled" color="green">启用</a-tag>
              <a-tag v-if="!enabled" color="orange">禁用</a-tag>
            </template>
            <template slot="customRenderFlag" slot-scope="isDefault">
              <a-tag v-if="isDefault" color="green">是</a-tag>
              <a-tag v-if="!isDefault" color="orange">否</a-tag>
            </template>
          </a-table>
        </div>
        <!-- table区域-end -->
        <!-- 表单区域 -->
        <agreementPrice-modal ref="modalForm" @ok="modalFormOk"></agreementPrice-modal>
        <import-agreement-price-modal ref="importAgreementPriceModalForm" @ok="importAgreementPriceModalFormOk"></import-agreement-price-modal>
      </a-card>
    </a-col>
  </a-row>
  
</template>
<!-- BY cao_yu_li -->
<script>
  import ImportAgreementPriceModal from './dialog/ImportAgreementPriceModal.vue'  //引入批量导入页面
  import AgreementPriceModal from './modules/AgreementPriceModal.vue'             //引入新增编辑页面
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'                        //新增编辑页面js
  import { BillModalMixin } from './mixins/BillModalMixin'                        //批量导入页面js
  import { postAction } from '@api/manage'
  export default {
    name: "agreementPriceList",
    mixins:[JeecgListMixin,BillModalMixin],
    components: {
      ImportAgreementPriceModal,
      AgreementPriceModal,
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
        queryParam: {batch_number:'',material_id:''},
        // 表头
        columns: [
          {
            title: '#',
            dataIndex: '',
            key:'rowIndex',
            width:40,
            align:"center",
            customRender:function (t,r,index) {
              return parseInt(index)+1;
            }
          },
          {
            title: '操作',
            dataIndex: 'action',
            align:"center",
            width: 200,
            scopedSlots: { customRender: 'action' },
          },
          {title: '协议单号', dataIndex: 'batchNumber', width: 100,align:"center"},
          {title: '商品编码', dataIndex: 'materialId', width: 100,align:"center"},
          {title: '商品名称', dataIndex: 'sku', width: 200,align:"center"},
          {title: '商品单位', dataIndex: 'materialUnit', width: 80,align:"center"},
          {title: '供应商名称', dataIndex: 'supplier', width: 120,align:"center"},
          {title: '商品类型', dataIndex: 'materialType', width: 80,align:"center"},
          {title: '税率', dataIndex: 'taxRate', width: 60,align:"center"},
          {title: '含税单价', dataIndex: 'taxUnitPrice', width: 80,align:"center"},
          {title: '创建日期', dataIndex: 'createDate', width: 100,align:"center"},
          {title: '有效日期', dataIndex: 'expirationDate', width: 100,align:"center"},
          {title: '状态',dataIndex: 'enabled',width:60,align:"center",
            scopedSlots: { customRender: 'customRenderEnabledFlag' }
          },
          {title: '是否默认',dataIndex: 'isDefault',width:80,align:"center",
            scopedSlots: { customRender: 'customRenderFlag' }
          }
        ],
        url: {
          list: "/agreementPrice/list",
          delete: "/agreementPrice/delete",
          deleteBatch: "/agreementPrice/deleteBatch",
          setDefault: "/agreementPrice/updateIsDefault",
          batchSetStatusUrl: "/agreementPrice/batchSetStatus",
        }
      }
    },
    computed: {

    },
    methods: {
      handleSetDefault: function (id) {
        if(!this.url.setDefault){
          this.$message.error("请设置url.default属性!")
          return
        }
        let that = this;
        postAction(that.url.setDefault, {id: id}).then((res) => {
          if(res.code === 200){
            that.loadData();
          } else {
            that.$message.warning(res.data.message);
          }
        });
      },
      handleEdit: function (record) {
        this.$refs.modalForm.edit(record);
        this.$refs.modalForm.title = "编辑";
        this.$refs.modalForm.disableSubmit = false;
        if(this.btnEnableList.indexOf(1)===-1) {
          this.$refs.modalForm.isReadOnly = true
        }
      }
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>