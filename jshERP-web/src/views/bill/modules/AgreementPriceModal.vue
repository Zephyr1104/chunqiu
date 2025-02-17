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
        <a-form :form="form" id="agreementPriceModal">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="协议单号">
            <a-input placeholder="请输入协议单号" v-decorator.trim="[ 'batchNumber', validatorRules.batchNumber]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="商品编码">
            <a-input placeholder="请输入商品编码" v-decorator.trim="[ 'materialId' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="商品单位">
            <a-textarea :rows="2" placeholder="请输入商品单位" v-decorator.trim="[ 'materialUnit' ]" />
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
  import pick from 'lodash.pick'
  import {addAgreementPrice,editAgreementPrice,checkAgreementPrice} from '@/api/api'
  import {autoJumpNextInput} from "@/utils/util"
  import {mixinDevice} from '@/utils/mixin'
  export default {
    name: "agreementPriceModal",
    mixins: [mixinDevice],
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        maskStyle: '',
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
          batchNumber:{
            rules: [
              { required: true, message: '请输入协议单号!' },
              { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' },
              { validator: this.validateAgreementPricebatchNumber}
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
            'batchNumber','materialId', 'materialUnit'))
          autoJumpNextInput('agreementPriceModal')
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
            if(!this.model.id){
              obj=addAgreementPrice(formData);
            }else{
              obj=editAgreementPrice(formData);
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
      validateAgreementPricebatchNumber(rule, value, callback){
        let params = {
          batchNumber: value,
          id: this.model.id?this.model.id:0
        };
        checkAgreementPrice(params).then((res)=>{
          if(res && res.code===200) {
            if(!res.data.status){
              callback();
            } else {
              callback("协议单号已经存在");
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