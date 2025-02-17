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
                <a-form :form="form" id="DishNameModal">
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜品名称">
                        <a-input placeholder="请输入名称" v-decorator.trim="['name', validatorRules.name]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜品类别">
                        <a-select placeholder="选择菜品类别" v-decorator.trim="['nameTypeName', validatorRules.nameType]"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in foodCategoryList" :key="index" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="烹饪主工艺">
                        <a-select placeholder="选择烹饪主工艺" v-model="cookingTypeList.value"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in cookingTypeList.options" :key="index"
                                :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="主材类别">
                        <a-select placeholder="选择主材类别" v-model="mainTypeList.value" :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in mainTypeList.options" :key="index"
                                :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="菜系">
                        <a-select placeholder="选择菜系" v-model="cuisineTypeList.value" :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in cuisineTypeList.options" :key="index"
                                :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="味型">
                        <a-select placeholder="选择味型" v-model="tasteTypeList.value" :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in tasteTypeList.options" :key="index"
                                :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="过敏原">
                        <a-textarea :rows="2" placeholder="请输入过敏源" v-decorator.trim="['allergen']" />
                    </a-form-item>
                </a-form>
            </a-spin>
        </a-modal>
    </div>
</template>
<script>
import pick from 'lodash.pick'
import JSelectMultiple from '@/components/jeecg/JSelectMultiple'
import { addDishName, editDishName, checkDishName, getFoodCategoryList } from '@/api/api'
import { mixinDevice } from '@/utils/mixin'
export default {
    name: "DishNameModal",
    mixins: [mixinDevice],
    components: {
        JSelectMultiple
    },
    data() {
        return {
            title: "操作",
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

            foodCategoryList: {},

            // 烹饪工艺
            cookingTypeList: {
                options: [
                    { id: 1, name: '炒' },
                    { id: 2, name: '焖' },
                    { id: 3, name: '蒸' },
                    { id: 4, name: '煎' },
                    { id: 5, name: '卤' },
                    { id: 6, name: '熘' },
                    { id: 7, name: '烧' },
                    { id: 8, name: '烤' },
                    { id: 9, name: '炸' },
                    { id: 10, name: '炖' },
                    { id: 11, name: '煮' },
                    { id: 12, name: '煲' },
                    { id: 13, name: '烩' },
                ],
                value: ''
            },
            // 主材类别
            mainTypeList: {
                value: '',
                options: [
                    { id: 1, name: '猪肉类' },
                    { id: 2, name: '鸡肉类' },
                    { id: 3, name: '鸭肉类' },
                    { id: 4, name: '牛肉类' },
                    { id: 5, name: '鱼虾类' },
                    { id: 6, name: '蛋类' },
                    { id: 7, name: '腊肉类' },
                    { id: 8, name: '豆腐类' },
                    { id: 9, name: '鹅肉类' },
                ]
            },
            // 菜系
            cuisineTypeList: {
                value: '',
                options: [
                    { id: 1, name: '粤菜' },
                    { id: 2, name: '客家菜' },
                    { id: 3, name: '闽菜' },
                    { id: 4, name: '豫菜' },
                    { id: 5, name: '湘菜' },
                ]
            },
            // 味型
            tasteTypeList: {
                value: '',
                options: [
                    { id: 1, name: '咸' },
                    { id: 2, name: '甜' },
                    { id: 3, name: '苦' },
                    { id: 4, name: '辣' },
                    { id: 5, name: '酸' },
                    { id: 6, name: '鲜' },
                    { id: 7, name: '香' },
                ]
            },

            validatorRules: {
                name: {
                    rules: [
                        { required: true, message: '请输入名称!' },
                        { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' },
                        { validator: this.validateDishName }
                    ]
                },
                nameType: {
                    rules: [
                        { required: true, message: '请选择菜品类别!' },
                    ]
                }
            },
        }
    },
    created() {
        this.initFoodCategoryList()
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
                this.form.setFieldsValue(pick(this.model,
                    'name', 'nameTypeName', 'allergen'))
            });

            // 显示当前菜品的烹饪工艺
            this.handleListValue(this.cookingTypeList, this.model.cookingType)
            // 显示当前菜品的主材类别
            this.handleListValue(this.mainTypeList, this.model.mainType)
            // 显示当前菜品的菜系
            this.handleListValue(this.cuisineTypeList,this.model.cuisineType)
            // 显示当前菜品的味型
            this.handleListValue(this.tasteTypeList,this.model.tasteType)
        },
        close() {
            this.$emit('close');
            this.visible = false;
        },
        handleOk() {
            const that = this;
            // 触发表单验证
            this.form.validateFields((err, values) => {
                if (!err) {
                    that.confirmLoading = true;
                    let formData = Object.assign(this.model, values);
                    let obj;

                    // 得到nameType值
                    that.foodCategoryList.forEach(element => {
                        if (element.name == that.model.nameTypeName) {
                            formData.nameType = element.id;
                        }
                        if (element.id == that.model.nameTypeName) {
                            formData.nameType = that.model.nameTypeName;
                        }
                    });

                    // 得到cookingType值
                    formData.cookingType = this.handleListId(that.cookingTypeList);
                    // 得到mainType值
                    formData.mainType = this.handleListId(that.mainTypeList);
                    // 得到cuisineType值
                    formData.cuisineType = this.handleListId(that.cuisineTypeList);
                    // 得到tasteType值
                    formData.tasteType = this.handleListId(that.tasteTypeList);
                    
                    if (!this.model.id) {
                        obj = addDishName(formData);
                    } else {
                        obj = editDishName(formData);
                    }
                    obj.then((res) => {
                        if (res.code === 200) {
                            that.$emit('ok');
                        } else {
                            that.$message.warning(res.data.message);
                        }
                    }).finally(() => {
                        this.handleDefaultValues(that.cookingTypeList)
                        this.handleDefaultValues(that.mainTypeList)
                        this.handleDefaultValues(that.cuisineTypeList)
                        this.handleDefaultValues(that.tasteTypeList)

                        that.confirmLoading = false;
                        that.close();
                    })
                }
            })
        },
        handleCancel() {
            this.close()
        },

        validateDishName(rule, value, callback) {
            let params = {
                name: value,
                id: this.model.id ? this.model.id : 0
            };
            checkDishName(params).then((res) => {
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
        initFoodCategoryList() {
            getFoodCategoryList({}).then((res) => {
                if (res.code === 200) {
                    this.foodCategoryList = res.data;
                }
            });
        },

        // 显示当前值
        handleListValue(list, value) {
            list.options.forEach(element => {
                if (element.id == value) {
                    list.value = element.name;
                }
            });
            return list.value;
        },
        // 得到值
        handleListId(list) {
            list.options.forEach(element => {
                if (element.name == list.value) {
                    list.value = element.id;
                }
            });
            return list.value;
        },
        handleDefaultValues(list) {
            list.value = '';
        }
    },
}
</script>
<style scoped></style>