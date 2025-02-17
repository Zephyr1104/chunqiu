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
                <a-form-item label="央厨名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-input placeholder="请输入央厨名称查询" v-model="queryParam.name"></a-input>
                </a-form-item>
              </a-col>
              <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
                <a-col :md="6" :sm="24">
                  <a-button type="primary" @click="searchQuery">查询</a-button>
                  <a-button style="margin-left: 8px" @click="searchReset">重置</a-button>
                </a-col>
              </span>
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
        <information-modal ref="modalForm" @ok="modalFormOk"></information-modal>
      </a-card>
    </a-col>
  </a-row>
  
</template>
<!-- BY zzl -->
<script>
  import InformationModal from './modules/InformationModal.vue'             //引入新增编辑页面
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'                        //新增编辑页面js
  import { postAction } from '@api/manage'
  export default {
    name: "InformationList",
    mixins:[JeecgListMixin],
    components: {
      InformationModal,
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
        queryParam: {name:''},
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
          {title: '央厨编码', dataIndex: 'code', width: 200,align:"center"},
          {title: '央厨名称', dataIndex: 'name', width: 200,align:"center"},
          {title: '央厨简称', dataIndex: 'shortName', width: 100,align:"center"},
          {title: '央厨类型', dataIndex: 'kitchenTypeStr', width: 100,align:"center"},
          {title: '菜谱终端', dataIndex: 'recipeTerminalStr', width: 100,align:"center"},
          {title: '负责人', dataIndex: 'headStr', width: 60,align:"center"},
          {title: '联系电话', dataIndex: 'telephone', width: 120,align:"center"},
          {title: '地址',dataIndex: 'addr',width: 240,align:"center"},
          {title: '包装线', dataIndex: 'packagingLineStr', width: 100,align:"center"},
          {title: '创建时间', dataIndex: 'createDate', width: 120,align:"center"},
          { title: '状态',dataIndex: 'enabled',width:60,align:"center",
            scopedSlots: { customRender: 'customRenderEnabledFlag' }
          },
          {title: '是否默认',dataIndex: 'isDefault',width:80,align:"center",
            scopedSlots: { customRender: 'customRenderFlag' }
          }
        ],
        url: {
          list: "/information/list",
          delete: "/information/delete",
          deleteBatch: "/information/deleteBatch",
          setDefault: "/information/updateIsDefault",
          batchSetStatusUrl: "/information/batchSetStatus",
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