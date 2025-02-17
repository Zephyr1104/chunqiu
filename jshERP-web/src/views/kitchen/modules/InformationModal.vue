<template>
  <div ref="container">
    <a-modal
      :title="title"
      :width="800"
      :visible="visible"
      :confirmLoading="confirmLoading"
      :getContainer="() => $refs.container"
      :maskStyle="{'top':'93px','left':'154px'}"
      :wrapClassName="wrapClassNameInfo()"
      :mask="isDesktop()"
      :maskClosable="false"
      @ok="handleOk"
      @cancel="handleCancel"
      cancelText="取消"
      okText="保存"
      style="top:10%;height: 70%;">
      <template slot="footer">
        <a-button key="back" v-if="isReadOnly" @click="handleCancel">
          取消
        </a-button>
      </template>
      <a-spin :spinning="confirmLoading">
        <a-form :form="form" id="informationModal">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="央厨编号">
            <a-input placeholder="请输入央厨编号" v-decorator.trim="[ 'code', validatorRules.code]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="央厨名称">
            <a-input placeholder="请输入央厨名称" v-decorator.trim="[ 'name', validatorRules.name]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="简称（别名）">
            <a-input placeholder="请输入简称（别名）" v-decorator.trim="[ 'shortName']" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="央厨类型">
            <a-select placeholder="请选择央厨类型" v-decorator="[ 'kitchenTypeStr' ]">
              <a-select-option value=1>全能央厨</a-select-option>
              <a-select-option value=2>热链央厨</a-select-option>
              <a-select-option value=3>冷链央厨</a-select-option>
              <a-select-option value=4>冷热混合</a-select-option>
              <a-select-option value=5>净菜央厨</a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜谱终端">
            <a-select placeholder="请选择菜谱终端" v-decorator="[ 'recipeTerminalStr' ]">
              <a-select-option value="1">终端模式</a-select-option>
              <a-select-option value="2">菜谱分组模式</a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="负责人">
            <a-select placeholder="选择负责人" v-decorator="[ 'headStr' ]" :dropdownMatchSelectWidth="false">
              <a-select-option v-for="(item,index) in userList" :key="index" :value="item.id">
                {{ item.userName }}
              </a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="联系电话">
            <a-input placeholder="请输入联系电话" v-decorator.trim="[ 'telephone']" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="联系地址">
            <a-input placeholder="请输入联系地址" v-decorator.trim="[ 'addr']" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="包装线">
            <a-select placeholder="请选择包装线" v-decorator="[ 'packagingLineStr' ]">
              <a-select-option value="1">依终端</a-select-option>
              <a-select-option value="2">依套餐类型</a-select-option>
            </a-select>
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
  import pick from 'lodash.pick'
  import {addInformation,editInformation,checkInformation,getUserList} from '@/api/api'
  import {autoJumpNextInput} from "@/utils/util"
  import {mixinDevice} from '@/utils/mixin'
  export default {
    name: "informationModal",
    mixins: [mixinDevice],
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        maskStyle: '',
        userList: [],
        isReadOnly: false,
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        form: this.$form.createForm(this),
        validatorRules:{
          code:{
            rules: [
              { required: true, message: '请输入央厨编号!' },
              { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' }
            ]},
          name:{
            rules: [
              { required: true, message: '请输入央厨名称!' },
              { min: 2, max: 30, message: '长度在 2 到 10 个字符', trigger: 'blur' },
              { validator: this.validateInformationName}
            ]}
        },
      }
    },
    created () {
      this.initUser()
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,
            'code','name','shortName','kitchenTypeStr','recipeTerminalStr','headStr',
            'telephone','addr','packagingLineStr'))
          autoJumpNextInput('informationModal')
        });
      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let formData = Object.assign(this.model, values);
            let obj;
            console.log(formData);
            if(!this.model.id){
              obj=addInformation(formData);
            }else{
              obj=editInformation(formData);
            }
            obj.then((res)=>{
              if(res.code === 200){
                that.$emit('ok');
              }else{
                that.$message.warning(res.data.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })
          }
        })
      },
      handleCancel () {
        this.close()
      },
      validateInformationName(rule, value, callback){
        let params = {
          name: value,
          id: this.model.id?this.model.id:0
        };
        checkInformation(params).then((res)=>{
          if(res && res.code===200) {
            if(!res.data.status){
              callback();
            } else {
              callback("央厨名称已经存在");
            }
          } else {
            callback(res.data);
          }
        });
      },
      initUser() {
        getUserList({}).then((res)=>{
          if(res) {
            this.userList = res;
          }
        });
      }
    }
  }
</script>
<style scoped>

</style>