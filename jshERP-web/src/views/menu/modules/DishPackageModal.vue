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
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="套餐名称">
                        <a-input placeholder="请输入名称" v-decorator.trim="['name', validatorRules.name]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐次">
                        <a-select placeholder="选择餐次" v-decorator.trim="['mealType', validatorRules.mealType]"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in mealList" :key="index" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol"
                        style="display: flex;justify-content: center;">
                        <a-transfer 
                        :data-source="mockData"
                        :titles="['待选菜品类别', '已选菜品类别']"
                        :list-style="{
                            width: '200px',
                            height: '400px',
                        }" show-search 
                        :filter-option="filterOption" 
                        :target-keys="targetKeys"
                        :render="item => item.title" 
                        @change="handleChange" 
                        @search="handleSearch" />
                    </a-form-item>
                </a-form>
            </a-spin>
        </a-modal>
    </div>
</template>
<script>
import pick from 'lodash.pick'
import JSelectMultiple from '@/components/jeecg/JSelectMultiple'
import { addDishPackage, editDishPackage, checkDishPackage, getMealList, getFoodCategoryList } from '@/api/api'
import { mixinDevice } from '@/utils/mixin'
export default {
    name: "DishPackageModal",
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

            mealList: {},
            foodCategoryList: {},

            mockData: [],
            targetKeys: [],

            validatorRules: {
                name: {
                    rules: [
                        { required: true, message: '请输入名称!' },
                        { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' },
                        { validator: this.validateDishPackage }
                    ]
                },
                mealType: {
                    rules: [
                        { required: true, message: '请选择餐次!' },
                    ]
                }
            },
        }
    },
    created() {
        this.initMealList()
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

            // 获取穿梭框数据
            this.getMock(record);

            this.$nextTick(() => {
                this.form.setFieldsValue(pick(this.model,
                    'name', 'mealType', 'dishDetails'))
            });
            
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

                    // 处理菜品类别详情
                    let dishDetails = '';
                    this.targetKeys.forEach(item => {
                        dishDetails += item + ',';
                    });
                    formData.dishDetails = dishDetails.substring(0, dishDetails.length - 1);

                    if (!this.model.id) {
                        obj = addDishPackage(formData);
                    } else {
                        obj = editDishPackage(formData);
                    }

                    obj.then((res) => {
                        if (res.code === 200) {
                            that.$emit('ok');
                        } else {
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
        validateDishPackage(rule, value, callback) {
            let params = {
                name: value,
                id: this.model.id ? this.model.id : 0
            };
            checkDishPackage(params).then((res) => {
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
        initMealList() {
            getMealList({}).then((res) => {
                if (res.code === 200) {
                    this.mealList = res.data;
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
        getMock(record) {
            const targetKeys = [];
            const mockData = [];
            const foodCategorys = this.foodCategoryList;
            for (let i = 0; i < foodCategorys.length; i++) {
                const data = {
                    key: (foodCategorys[i].id).toString(),
                    title: foodCategorys[i].name,
                    description: foodCategorys[i].name,
                };
                mockData.push(data);
            }
            // 获取已选择的菜品类别
            let dishDetails = record.dishDetails ? record.dishDetails.split(',') : [];
            // 处理已选择的菜品类别
            dishDetails.forEach(item => {
                targetKeys.push(item);
            });
            
            this.mockData = mockData;
            this.targetKeys = targetKeys;
        },
        filterOption(inputValue, option) {
            return option.description.indexOf(inputValue) > -1;
        },
        handleChange(targetKeys, direction, moveKeys) {
            // console.log(targetKeys, direction, moveKeys);
            this.targetKeys = targetKeys;
        },
        handleSearch(dir, value) {
            console.log('search:', dir, value);
        },
    },
}
</script>
<style scoped></style>