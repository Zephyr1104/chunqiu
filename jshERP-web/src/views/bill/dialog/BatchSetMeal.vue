<template>
  <div ref="container">
    <a-modal
      :title="title"
      :width="500"
      :visible="visible"
      :confirmLoading="confirmLoading"
      :getContainer="() => $refs.container"
      :maskStyle="{'top':'93px','left':'154px'}"
      :wrapClassName="wrapClassNameInfo()"
      :mask="isDesktop()"
      :maskClosable="false"
      @ok="handleOk"
      @cancel="handleCancel"
      cancelText="关闭"
      style="top:30%;height: 35%;">
      <template slot="footer">
        <a-button key="back" v-if="isReadOnly" @click="handleCancel">
          关闭
        </a-button>
      </template>
      <a-spin :spinning="confirmLoading">
        <a-form :form="form" id="batchSetMeal">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐次名称">
            <a-select placeholder="请选择餐次" v-decorator="[ 'mealId', validatorRules.mealId ]" showSearch optionFilterProp="children">
              <a-select-option v-for="(meal,index) in mealList" :value="meal.id">
                {{ meal.name }}
              </a-select-option>
            </a-select>
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
  import pick from 'lodash.pick'
  import { getAction } from '@/api/manage'
  import {mixinDevice} from '@/utils/mixin'
  export default {
    name: "BatchSetMeal",
    mixins: [mixinDevice],
    data () {
      return {
        title:"操作",
        visible: false,
        model: {},
        mealList: [],
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
          mealId:{
            rules: [
              { required: true, message: '请选择餐次!' }
            ]
          }
        },
      }
    },
    created () {
    },
    methods: {
      getMealData() {
        getAction('/meal/getAllList').then((res)=>{
          if(res.code === 200){
            this.mealList = res.data;
          }else{
            this.$message.info(res.data);
          }
        })
      },
      add () {
        this.edit({});
        this.getMealData()
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'mealId'))
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
            let mealId = formData.mealId
            that.$emit('ok', mealId);
            that.confirmLoading = false;
            that.close();
          }
        })
      },
      handleCancel () {
        this.close()
      }
    }
  }
</script>

<style scoped>

</style>