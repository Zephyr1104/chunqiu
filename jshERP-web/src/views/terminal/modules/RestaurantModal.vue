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
        <a-form :form="form" id="restaurantModal">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐厅编号">
            <a-input placeholder="请输入餐厅编号" v-decorator.trim="[ 'code', validatorRules.code]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐厅名称">
            <a-input placeholder="请输入餐厅名称" v-decorator.trim="[ 'name', validatorRules.name]" />
          </a-form-item>
          <a-form-item label="简称" :labelCol="labelCol" :wrapperCol="wrapperCol" >
            <a-input placeholder="请输入简称" v-decorator.trim="[ 'shortName']" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="负责人">
            <a-select placeholder="选择负责人" v-decorator="[ 'headStr' ]" :dropdownMatchSelectWidth="false">
              <a-select-option v-for="(item,index) in userList" :key="index" :value="item.id">
                {{ item.userName }}
              </a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="电话号码">
            <a-input placeholder="请输入电话号码" v-decorator.trim="[ 'telephone' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐厅地址">
            <a-input placeholder="请输入餐厅地址" v-decorator.trim="[ 'addr' ]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="配送央厨">
            <a-select placeholder="请输入配送央厨" v-decorator="[ 'centralKitchenStr' ]" :dropdownMatchSelectWidth="false">
              <a-select-option v-for="(item,index) in informationList" :key="index" :value="item.id">
                {{ item.name }}
              </a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="终端类型">
            <a-select placeholder="请选择终端类型" v-decorator="[ 'terminalTypeStr' ]">
              <a-select-option value="1">单位承包型</a-select-option>
              <a-select-option value="2">园区型</a-select-option>
              <a-select-option value="3">加盟型</a-select-option>
              <a-select-option value="4">食堂转包型</a-select-option>
            </a-select>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="周菜谱模式">
            <a-select placeholder="请选择周菜谱模式" v-decorator="[ 'menuModeStr' ]">
              <a-select-option value="1">单品</a-select-option>
              <a-select-option value="2">套餐</a-select-option>
            </a-select>
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
  import pick from 'lodash.pick'
  import {addRestaurant,editRestaurant,checkRestaurant,getUserList,getInformationList} from '@/api/api'
  import {autoJumpNextInput} from "@/utils/util"
  import {mixinDevice} from '@/utils/mixin'
  export default {
    name: "restaurantModal",
    mixins: [mixinDevice],
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        maskStyle: '',
        userList: [],
        informationList: [],
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
          name:{
            rules: [
              { required: true, message: '请输入终端餐厅名称!' },
              { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' },
              { validator: this.validateRestaurantName}
            ]}
        },
      }
    },
    created () {
      this.initUser(),this.initInformation()
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
            'code','name','shortName','headStr','telephone','addr','centralKitchenStr','terminalTypeStr','menuModeStr'))
          autoJumpNextInput('restaurantModal')
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
              obj=addRestaurant(formData);
            }else{
              obj=editRestaurant(formData);
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
      validateRestaurantName(rule, value, callback){
        let params = {
          name: value,
          id: this.model.id?this.model.id:0
        };
        checkRestaurant(params).then((res)=>{
          if(res && res.code===200) {
            if(!res.data.status){
              callback();
            } else {
              callback("终端餐厅名称已经存在");
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
      },
      initInformation() {
        getInformationList({}).then((res)=>{
          if(res) {
            this.informationList = res;
          }
        });
      }
    }
  }
</script>
<style scoped>

</style>