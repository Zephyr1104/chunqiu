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
      style="top:5%;height: 85%;">
      <template slot="footer">
        <a-button key="back" v-if="isReadOnly" @click="handleCancel">
          取消
        </a-button>
      </template>
      <a-spin :spinning="confirmLoading">
        <a-form :form="form" id="driverModal">
          <a-form-item label="登录账号" :labelCol="labelCol" :wrapperCol="wrapperCol">
            <a-input placeholder="请输入登录账号" v-decorator.trim="[ 'loginName', validatorRules.loginName]" :readOnly="!!model.id"
             suffix="初始密码：123456" />
          </a-form-item>
          <a-form-item label="司机姓名" :labelCol="labelCol" :wrapperCol="wrapperCol" >
            <a-input placeholder="请输入司机姓名" v-decorator.trim="[ 'driverName', validatorRules.driverName]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="车牌号">
            <a-input placeholder="请输入车牌号" v-decorator.trim="[ 'carNumber' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="承运商">
            <a-input placeholder="请输入承运商" v-decorator.trim="[ 'carrier' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="电话号码">
            <a-input placeholder="请输入电话号码" v-decorator.trim="[ 'phonenum' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="电子邮箱">
            <a-input placeholder="请输入电子邮箱" v-decorator.trim="[ 'email' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="用户描述">
            <a-textarea :rows="2" placeholder="请输入用户描述" v-decorator="[ 'description' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="备注">
            <a-input placeholder="请输入备注" v-decorator.trim="[ 'remark' ]" />
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
  import pick from 'lodash.pick'
  import {addDriver,editDriver} from '@/api/api'
  import {autoJumpNextInput} from "@/utils/util"
  import {mixinDevice} from '@/utils/mixin'
  export default {
    name: "driverModal",
    mixins: [mixinDevice],
    data () {
      return {
        title:"操作",
        visible: false,
        modalWidth:800,
        drawerWidth:700,
        isReadOnly: false,
        disableSubmit:false,
        dateFormat:"YYYY-MM-DD",
        validatorRules:{
          loginName:{
            rules: [{
              required: true, message: '请输入登录账号!'
            }]
          },
          driverName:{
            rules: [{
              required: true, message: '请输入司机姓名!'
            }]
          },
        },
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },
        confirmLoading: false,
        headers:{},
        form:this.$form.createForm(this)
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
        this.visible = true;
        this.model = Object.assign({}, record);
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'loginName','driverName','carNumber','carrier',
            'phonenum','email','description','remark'))
          autoJumpNextInput('driverModal')
        });
      },
      close() {
        this.$emit('close');
        this.visible = false;
        this.disableSubmit = false;
      },
      handleOk() {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let formData = Object.assign(this.model, values);
            let obj;
            if(!this.model.id){
              obj=addDriver(formData);
            }else{
              obj=editDriver(formData);
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
      handleCancel() {
        this.close()
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