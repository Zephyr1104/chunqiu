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
                <a-form-item label="食材名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
                  <a-input placeholder="请输入食材名称查询" v-model="queryParam.name"></a-input>
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
              <a-button type="primary" @click="onImportNutritional(prefixNo)"><a-icon type="import" />导入食材营养成分信息</a-button>
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
        <nutritional-modal ref="modalForm" @ok="modalFormOk"></nutritional-modal>
        <import-nutritional-modal ref="importNutritionalModalForm" @ok="importNutritionalModalFormOk"></import-nutritional-modal>
      </a-card>
    </a-col>
  </a-row>
  
</template>
<!-- BY zzl -->
<script>
  import ImportNutritionalModal from '@/views/bill/dialog/ImportNutritionalModal.vue'  //引入批量导入页面
  import NutritionalModal from './modules/NutritionalModal.vue'             //引入新增编辑页面
  import { JeecgListMixin } from '@/mixins/JeecgListMixin'                        //新增编辑页面js
  import { BillModalMixin } from '@/views/bill/mixins/BillModalMixin'                        //批量导入页面js
  import { postAction } from '@api/manage'
  export default {
    name: "nutritionalList",
    mixins:[JeecgListMixin,BillModalMixin],
    components: {
      ImportNutritionalModal,
      NutritionalModal,
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
          {title: '菜品名称', dataIndex: 'name', width: 60,align:"center"},
          {title: '可食部分(%)', dataIndex: 'eat', width: 60,align:"center"},
          {title: '能量(千卡)', dataIndex: 'energy', width: 60,align:"center"},
          {title: '水分(克)', dataIndex: 'water', width: 60,align:"center"},
          {title: '蛋白质(克)', dataIndex: 'protein', width: 60,align:"center"},
          {title: '脂肪(克)', dataIndex: 'fat', width: 60,align:"center"},
          {title: '膳食纤维(克)', dataIndex: 'fiber', width: 60,align:"center"},
          {title: '碳水化物(克)', dataIndex: 'carbohydrates', width: 60,align:"center"},
          {title: '维生素B1(毫克)', dataIndex: 'vitaminB1', width: 60,align:"center"},
          {title: '维生素B2(毫克)', dataIndex: 'vitaminB2', width: 60,align:"center"},
          {title: '烟酸(毫克)', dataIndex: 'niacin', width: 60,align:"center"},
          {title: '维生素E(毫克)', dataIndex: 'vitaminE', width: 60,align:"center"},
          {title: '钠(毫克)', dataIndex: 'sodium', width: 60,align:"center"},
          {title: '钙(毫克)', dataIndex: 'calcium', width: 60,align:"center"},
          {title: '铁(毫克)',dataIndex: 'iron',width: 60,align:"center"},
          {title: '维生素C(毫克)', dataIndex: 'vitaminC', width: 60,align:"center"},
          {title: '胆固醇(毫克)', dataIndex: 'cholesterol', width: 60,align:"center"},
          {title: '创建人', dataIndex: 'userId', width: 60,align:"center"},
          {title: '创建时间', dataIndex: 'createDate', width: 60,align:"center"},
          { title: '状态',dataIndex: 'enabled',width:60,align:"center",
            scopedSlots: { customRender: 'customRenderEnabledFlag' }
          },
          {title: '是否默认',dataIndex: 'isDefault',width:80,align:"center",
            scopedSlots: { customRender: 'customRenderFlag' }
          }
        ],
        url: {
          list: "/nutritional/list",
          delete: "/nutritional/delete",
          deleteBatch: "/nutritional/deleteBatch",
          setDefault: "/nutritional/updateIsDefault",
          batchSetStatusUrl: "/nutritional/batchSetStatus",
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