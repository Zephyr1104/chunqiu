<template xmlns:background-color="http://www.w3.org/1999/xhtml">
  <a-row :gutter="10">
    <a-col :md="12" :sm="24">
      <a-card :bordered="false">

        <!-- 按钮操作区域 -->
        <a-row style="margin-left: 14px">
          <a-button v-if="btnEnableList.indexOf(1)>-1" @click="handleAdd()" type="primary">添加工厂模型</a-button>
          <a-button v-if="btnEnableList.indexOf(1)>-1" title="删除多条数据" @click="batchDel" type="default">批量删除</a-button>
          <a-button @click="refresh" type="default" icon="reload">刷新</a-button>
          <!-- <a-button type="dashed">提示：工厂模型可录入公司部门或门店</a-button> -->
        </a-row>
        <div style="background: #fff;padding-left:16px;height: 100%; margin-top: 5px">
          <a-alert type="info" :showIcon="true">
            <div slot="message">
              当前选择：<span v-if="this.currSelected.title">{{ getCurrSelectedTitle() }}</span>
              <a v-if="this.currSelected.title" style="margin-left: 10px" @click="onClearSelected">取消选择</a>
            </div>
          </a-alert>
          <!-- 树-->
          <a-col :md="10" :sm="24">
            <template>
              <a-dropdown :trigger="[this.dropTrigger]" @visibleChange="dropStatus">
               <span style="user-select: none">
                <a-tree
                  checkable
                  multiple
                  @select="onSelect"
                  @check="onCheck"
                  @rightClick="rightHandle"
                  :selectedKeys="selectedKeys"
                  :checkedKeys="checkedKeys"
                  :treeData="departTree"
                  :checkStrictly="checkStrictly"
                  :expandedKeys="iExpandedKeys"
                  :autoExpandParent="true"
                  @expand="onExpand"/>
                </span>
              </a-dropdown>
            </template>
          </a-col>
        </div>
      </a-card>
      <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>
      <div class="drawer-bootom-button">
        <a-dropdown :trigger="['click']" placement="topCenter">
          <a-menu slot="overlay">
            <a-menu-item key="1" @click="switchCheckStrictly(1)">父子关联</a-menu-item>
            <a-menu-item key="2" @click="switchCheckStrictly(2)">取消关联</a-menu-item>
            <a-menu-item key="3" @click="checkALL">全部勾选</a-menu-item>
            <a-menu-item key="4" @click="cancelCheckALL">取消全选</a-menu-item>
            <a-menu-item key="5" @click="expandAll">展开所有</a-menu-item>
            <a-menu-item key="6" @click="closeAll">合并所有</a-menu-item>
          </a-menu>
          <a-button>
            树操作 <a-icon type="up" />
          </a-button>
        </a-dropdown>
      </div>
      <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>
    </a-col>
    <a-col :md="12" :sm="24">
      <a-card :bordered="false" v-if="selectedKeys.length>0">
        <a-form :form="form">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="名称">
            <a-input placeholder="请输入名称" v-decorator="['processorAbr', validatorRules.processorAbr ]"/>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="编号">
            <a-input placeholder="请输入编号" v-decorator="['processorNo', validatorRules.processorNo ]"/>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="上级工厂模型">
            <a-tree-select style="width:100%" :dropdownStyle="{maxHeight:'200px',overflow:'auto'}"
                           allow-clear :treeDefaultExpandAll="true"
                           :treeData="treeData" v-decorator="[ 'parentId' ]" placeholder="请选择上级工厂模型">
            </a-tree-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="排序">
            <a-input v-decorator="[ 'sort' ]"/>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="备注">
            <a-textarea placeholder="请输入备注":rows="2" v-decorator.trim="[ 'remark' ]" />
          </a-form-item>
        </a-form>
        <div class="anty-form-btn">
          <a-button @click="emptyCurrForm" type="default" htmlType="button" icon="sync">重置</a-button>
          <a-button @click="submitCurrForm" type="primary" htmlType="button" icon="form">保存</a-button>
        </div>
      </a-card>
      <a-card v-else >
        <a-empty>
          <span slot="description"> 请先选择一个工厂模型! </span>
        </a-empty>
      </a-card>
    </a-col>
    <processor-modal ref="processorModal" @ok="loadTree"></processor-modal>
  </a-row>
</template>
<!-- f r o m 7 5  2 7 1  8 9 2 0 -->
<script>
import ProcessorModal from './modules/ProcessorModal'
import pick from 'lodash.pick'
import {queryProcessorTreeList,queryProcessorById, checkProcessor } from '@/api/api'
import {httpAction, deleteAction} from '@/api/manage'
import {JeecgListMixin} from '@/mixins/JeecgListMixin'
export default {
  name: 'ProcessorList',
  mixins: [JeecgListMixin],
  components: {
    ProcessorModal
  },
  data() {
    return {
      iExpandedKeys: [],
      loading: false,
      currFlowId: '',
      currFlowName: '',
      disable: true,
      treeData: [],
      visible: false,
      departTree: [],
      rightClickSelectedKey: '',
      rightClickSelectedOrgCode: '',
      hiding: true,
      model: {},
      dropTrigger: '',
      depart: {},
      disableSubmit: false,
      checkedKeys: [],
      selectedKeys: [],
      autoIncr: 1,
      currSelected: {},
      allTreeKeys:[],
      checkStrictly: true,
      form: this.$form.createForm(this),
      labelCol: {
        xs: {span: 24},
        sm: {span: 5}
      },
      wrapperCol: {
        xs: {span: 24},
        sm: {span: 16}
      },
      graphDatasource: {
        nodes: [],
        edges: []
      },
      validatorRules: {
        processorAbr: {
          rules: [
            { required: true, message: '请输入名称!'},
            { validator: this.validateName}
          ]
        },
        processorNo: {rules: [{required: true, message: '请输入编码!'}]}
      },
      url: {
        delete: '/processor/delete',
        edit: '/processor/update',
        deleteBatch: '/processor/deleteBatch'
      },
      orgCategoryDisabled:false,
    }
  },
  computed: {
    importExcelUrl: function () {
      return `${window._CONFIG['domianURL']}/${this.url.importExcelUrl}`;
    }
  },
  methods: {
    loadData() {
      this.refresh();
    },
    loadTree() {
      let that = this
      that.treeData = []
      that.departTree = []
      let params = {};
      params.id='';
      queryProcessorTreeList(params).then((res) => {
        if (res) {
          //工厂模型全选后，再添加工厂模型，选中数量增多
          this.allTreeKeys = [];
          for (let i = 0; i < res.length; i++) {
            let temp = res[i]
            that.departTree.push(temp)
            that.setThisExpandedKeys(temp)
            that.getAllKeys(temp);
          }
          this.loading = false
        }
      })
    },
    setThisExpandedKeys(node) {
      if (node.children && node.children.length > 0) {
        this.iExpandedKeys.push(node.key)
        for (let a = 0; a < node.children.length; a++) {
          this.setThisExpandedKeys(node.children[a])
        }
      }
    },
    refresh() {
      this.loading = true
      this.loadTree()
    },
    // 右键操作方法
    rightHandle(node) {
      this.dropTrigger = 'contextmenu'
      console.log(node.node.eventKey)
      this.rightClickSelectedKey = node.node.eventKey
      this.rightClickSelectedOrgCode = node.node.dataRef.orgCode
    },
    onExpand(expandedKeys) {
      console.log('onExpand', expandedKeys)
      // if not set autoExpandParent to false, if children expanded, parent can not collapse.
      // or, you can remove all expanded children keys.
      this.iExpandedKeys = expandedKeys
    },
    backFlowList() {
      this.$router.back(-1)
    },
    // 右键点击下拉框改变事件
    dropStatus(visible) {
      if (visible == false) {
        this.dropTrigger = ''
      }
    },
    // 右键店家下拉关闭下拉框
    closeDrop() {
      this.dropTrigger = ''
    },
    addRootNode() {
      this.$refs.nodeModal.add(this.currFlowId, '')
    },
    batchDel: function () {
      console.log(this.checkedKeys)
      if (this.checkedKeys.length <= 0) {
        this.$message.warning('请选择一条记录！')
      } else {
        var ids = ''
        for (var a = 0; a < this.checkedKeys.length; a++) {
          ids += this.checkedKeys[a] + ','
        }
        var that = this
        this.$confirm({
          title: '确认删除',
          content: '确定要删除所选中的 ' + this.checkedKeys.length + ' 条数据?',
          onOk: function () {
            deleteAction(that.url.deleteBatch, {ids: ids}).then((res) => {
              if (res.code == 200) {
                that.$message.success(res.data.message)
                that.loadTree()
                that.onClearSelected()
              } else {
                that.$message.warning(res.data.message)
              }
            })
          }
        })
      }
    },
    nodeModalOk() {
      this.loadTree()
    },
    nodeModalClose() {
    },
    hide() {
      console.log(111)
      this.visible = false
    },
    onCheck(checkedKeys, info) {
      console.log('onCheck', checkedKeys, info)
      this.hiding = false
      //this.checkedKeys = checkedKeys.checked
      // <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>
      if(this.checkStrictly){
        this.checkedKeys = checkedKeys.checked;
      }else{
        this.checkedKeys = checkedKeys
      }
      // <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>
    },
    onSelect(selectedKeys, e) {
      console.log('selected', selectedKeys, e)
      this.hiding = false
      let record = e.node.dataRef
      let params = {};
      params.id=record.id;
      this.getTreeByParams(params)
      queryProcessorById(params).then((res) => {
        if (res && res.code == 200) {
          if(res.data){
            record.processorAbr = res.data.processorAbr;
            record.processorNo = res.data.processorNo;
            record.parentId = res.data.parentId;
            record.sort = res.data.sort;
            record.remark = res.data.remark;
            console.log('onSelect-record', record)
            this.currSelected = Object.assign({}, record)
            this.model = this.currSelected
            this.selectedKeys = [record.key]
            this.model.parentId = record.parentId
            this.setValuesToForm(record)
          }
        }
      });
    },
    //根据工厂模型id加载工厂模型树
    getTreeByParams(params) {
      queryProcessorTreeList(params).then((res) => {
        if (res) {
          this.treeData = []
          for (let i = 0; i < res.length; i++) {
            this.treeData.push(res[i])
          }
        }
      })
    },
    // 触发onSelect事件时,为工厂模型树右侧的form表单赋值
    setValuesToForm(record) {
      this.$nextTick(() => {
        this.form.setFieldsValue(pick(record, 'processorAbr', 'processorNo', 'parentId', 'sort', 'remark'))
      })
    },
    getCurrSelectedTitle() {
      return !this.currSelected.title ? '' : this.currSelected.title
    },
    onClearSelected() {
      this.hiding = true
      this.checkedKeys = []
      this.currSelected = {}
      this.form.resetFields()
      this.selectedKeys = []
      this.$refs.departAuth.departId = ''
    },
    handleNodeTypeChange(val) {
      this.currSelected.nodeType = val
    },
    notifyTriggerTypeChange(value) {
      this.currSelected.notifyTriggerType = value
    },
    receiptTriggerTypeChange(value) {
      this.currSelected.receiptTriggerType = value
    },
    submitCurrForm() {
      this.form.validateFields((err, values) => {
        if (!err) {
          if (!this.currSelected.id) {
            this.$message.warning('请点击选择要修改工厂模型!')
            return
          }
          let formData = Object.assign(this.currSelected, values)
          console.log('Received values of form: ', formData)
          httpAction(this.url.edit, formData, 'put').then((res) => {
            if (res.code == 200) {
              this.$message.success('保存成功!')
              this.loadTree()
              let params = {}
              params.id = formData.id
              this.getTreeByParams(params)
            } else {
              this.$message.error(res.message)
            }
          })
        }
      })
    },
    emptyCurrForm() {
      this.form.resetFields()
    },
    nodeSettingFormSubmit() {
      this.form.validateFields((err, values) => {
        if (!err) {
          console.log('Received values of form: ', values)
        }
      })
    },
    openSelect() {
      this.$refs.sysDirectiveModal.show()
    },
    validateName(rule, value, callback){
      let params = {
        name: value,
        id: this.model.id?this.model.id:0
      };
      checkProcessor(params).then((res)=>{
        if(res && res.code===200) {
          if(!res.data.status){
            callback();
          } else {
            callback("名称已经存在");
          }
        } else {
          callback(res.data);
        }
      });
    },
    handleAdd() {
      this.$refs.processorModal.add()
      this.$refs.processorModal.title = '新增'
    },
    selectDirectiveOk(record) {
      console.log('选中指令数据', record)
      this.nodeSettingForm.setFieldsValue({directiveCode: record.directiveCode})
      this.currSelected.sysCode = record.sysCode
    },
    getFlowGraphData(node) {
      this.graphDatasource.nodes.push({
        id: node.id,
        text: node.flowNodeName
      })
      if (node.children.length > 0) {
        for (let a = 0; a < node.children.length; a++) {
          let temp = node.children[a]
          this.graphDatasource.edges.push({
            source: node.id,
            target: temp.id
          })
          this.getFlowGraphData(temp)
        }
      }
    },
    // <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>
    expandAll () {
      this.iExpandedKeys = this.allTreeKeys
    },
    closeAll () {
      this.iExpandedKeys = []
    },
    checkALL () {
      this.checkStriccheckStrictlytly = false
      this.checkedKeys = this.allTreeKeys
    },
    cancelCheckALL () {
      //this.checkedKeys = this.defaultCheckedKeys
      this.checkedKeys = []
    },
    switchCheckStrictly (v) {
      if(v==1){
        this.checkStrictly = false
      }else if(v==2){
        this.checkStrictly = true
      }
    },
    getAllKeys(node) {
      // console.log('node',node);
      this.allTreeKeys.push(node.key)
      if (node.children && node.children.length > 0) {
        for (let a = 0; a < node.children.length; a++) {
          this.getAllKeys(node.children[a])
        }
      }
    }
    // <!---- author:os_chengtgen -- date:20190827 --  for:切换父子勾选模式 =======------>

  },
  created() {
    this.currFlowId = this.$route.params.id
    this.currFlowName = this.$route.params.name
    // this.loadTree()
  },

}
</script>
<style scoped>
.ant-card-body .table-operator {
  margin: 15px;
}

.anty-form-btn {
  width: 100%;
  text-align: center;
}

.anty-form-btn button {
  margin: 0 5px;
}

.anty-node-layout .ant-layout-header {
  padding-right: 0
}

.header {
  padding: 0 8px;
}

.header button {
  margin: 0 3px
}

.ant-modal-cust-warp {
  height: 100%
}

.ant-modal-cust-warp .ant-modal-body {
  height: calc(100% - 110px) !important;
  overflow-y: auto
}

.ant-modal-cust-warp .ant-modal-content {
  height: 90% !important;
  overflow-y: hidden
}

#app .desktop {
  height: auto !important;
}

/** Button按钮间距 */
.ant-btn {
  margin-left: 3px
}

.drawer-bootom-button {
  /*position: absolute;*/
  bottom: 0;
  width: 100%;
  border-top: 1px solid #e8e8e8;
  padding: 10px 16px;
  text-align: left;
  left: 0;
  background: #fff;
  border-radius: 0 0 2px 2px;
}
</style>