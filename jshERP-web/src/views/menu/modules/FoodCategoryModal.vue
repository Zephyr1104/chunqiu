<template>
  <div ref="container">
    <a-modal :title="title" :width="800" :visible="visible" :confirmLoading="confirmLoading"
      :getContainer="() => $refs.container" :maskStyle="{ 'top': '93px', 'left': '154px' }"
      :wrapClassName="wrapClassNameInfo()" :mask="isDesktop()" :maskClosable="false" @ok="handleOk"
      @cancel="handleCancel" cancelText="取消" okText="保存" style="top:10%;height: 70%;">
      <template slot="footer">
        <a-button key="back" v-if="isReadOnly" @click="handleCancel">
          取消
        </a-button>
      </template>
      <a-spin :spinning="confirmLoading">
        <a-form :form="form" id="FoodCategoryModal">
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜品名称">
            <a-input placeholder="请输入名称" v-decorator.trim="['name', validatorRules.name]" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="烹饪">
            <a-switch checked-children="启用" un-checked-children="关闭" v-model="cookingSwitch"
              @change="onCookingChange"></a-switch>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="采购">
            <a-switch checked-children="启用" un-checked-children="关闭" v-model="purchaseSwitch"
              @change="onPurchaseChange"></a-switch>
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="排序">
            <a-input placeholder="请输入排序" v-decorator.trim="['sort']" />
          </a-form-item>
          <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="备注">
            <a-textarea :rows="2" placeholder="请输入备注" v-decorator.trim="['remark']" />
          </a-form-item>
        </a-form>
      </a-spin>
    </a-modal>
  </div>
</template>
<script>
import pick from 'lodash.pick'
import { addFoodCategory, editFoodCategory, checkFoodCategory } from '@/api/api'
import { mixinDevice } from '@/utils/mixin'
export default {
  name: "FoodCategoryModal",
  mixins: [mixinDevice],
  data() {
    return {
      title: "操作",
      visible: false,
      model: {},
      cookingSwitch: false, //烹饪权限状态
      purchaseSwitch: false, //采购权限状态
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
      validatorRules: {
        name: {
          rules: [
            { required: true, message: '请输入名称!' },
            { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' },
            { validator: this.validateMealName }
          ]
        }
      },
    }
  },
  created() {
  },
  methods: {
    add() {
      this.edit({});
    },
    edit(record) {
      this.form.resetFields();
      this.model = Object.assign({}, record);
      this.visible = true;
      this.$nextTick(() => {
        if(this.model.cooking == 1){
          this.cookingSwitch = true;
        }
        if(this.model.purchase == 1){
          this.purchaseSwitch = true;
        }
        this.form.setFieldsValue(pick(this.model,
          'name', 'sort', 'remark'))
      });
    },
    close() {
      this.$emit('close');
      this.visible = false;
    },
    onCookingChange(checked) {
      this.model.cooking = checked ? '1' : '0'
    },
    onPurchaseChange(checked) {
      this.model.purchase = checked ? '1' : '0'
    },
    handleOk() {
      const that = this;
      // 触发表单验证
      this.form.validateFields((err, values) => {
        if (!err) {
          that.confirmLoading = true;
          let formData = Object.assign(this.model, values);
          let obj;
          if (!this.model.id) {
            obj = addFoodCategory(formData);
          } else {
            obj = editFoodCategory(formData);
          }
          obj.then((res) => {
            if (res.code === 200) {
              that.$emit('ok');
            } else {
              that.$message.warning(res.data.message);
            }
          }).finally(() => {
            that.confirmLoading = false;
            that.cookingSwitch = false;
            that.purchaseSwitch = false;
            that.close();
          })
        }
      })
    },
    handleCancel() {
      this.close()
    },
    validateMealName(rule, value, callback) {
      let params = {
        name: value,
        id: this.model.id ? this.model.id : 0
      };
      checkFoodCategory(params).then((res) => {
        if (res && res.code === 200) {
          if (!res.data.status) {
            callback();
          } else {
            callback("名称已经存在");
          }
        } else {
          callback(res.data);
        }
      });
    },
  }
}
</script>
<style scoped></style>