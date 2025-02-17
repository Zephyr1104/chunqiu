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
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐标价格">
                        <a-input placeholder="请输入餐标价格" v-decorator.trim="['diningPrice', validatorRules.diningPrice]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="选择日期">
                        <j-date v-decorator.trim="['diningDate', validatorRules.diningDate]" :show-time="true" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="餐次">
                        <a-select placeholder="选择餐次" v-decorator.trim="['mealId', validatorRules.mealId]"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in mealList" :key="index" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol"
                        style="display: flex;justify-content: center;">
                        <a-transfer :data-source="mockData" :titles="['待选菜品名称', '已选菜品名称']" :list-style="{
                            width: '200px',
                            height: '400px',
                        }" show-search :filter-option="filterOption" :target-keys="targetKeys"
                            :render="item => item.title" @change="handleChange" @search="handleSearch" />
                    </a-form-item>
                </a-form>
            </a-spin>
        </a-modal>
    </div>
</template>
<script>
import pick from 'lodash.pick'
import JSelectMultiple from '@/components/jeecg/JSelectMultiple'
import { addDishMealRel, editDishMealRel, getMealList, getDishNameList } from '@/api/api'
import { mixinDevice } from '@/utils/mixin'
import JDate from '@/components/jeecg/JDate'
export default {
    name: "MenusModal",
    mixins: [mixinDevice],
    components: {
        JDate,
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
            dishNameList: {},

            mockData: [],
            targetKeys: [],

            validatorRules: {
                diningPrice: {
                    rules: [
                        { required: true, message: '请输入餐标!' },
                        { pattern: /^\d+$/, message: '请输入数字', trigger: 'blur' },
                        { min: 1, max: 30, message: '长度在 1 到 30 个字符', trigger: 'blur' },
                    ]
                },
                mealId: {
                    rules: [
                        { required: true, message: '请选择餐次!' },
                    ]
                },
                diningDate: {
                    rules: [
                        { required: true, message: '请选择日期!' },
                    ]
                }
            },
        }
    },
    created() {
        this.initMealList()
        this.initDishNameList()
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
                    'name', 'mealId', 'diningPrice', 'diningDate',))
            });
            //复制新增单据-初始化单号和日期
            if (this.action === 'copyAdd') {
                this.model.id = ''
                this.model.tenantId = ''
            }
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
                    if (this.targetKeys.length > 0) {
                        let dishNameId = '';
                        this.targetKeys.forEach(item => {
                            dishNameId += item + ',';
                        });
                        formData.dishNameId = dishNameId.substring(0, dishNameId.length - 1);
                    }

                    if (!this.model.id) {
                        obj = addDishMealRel(formData);
                    } else {
                        obj = editDishMealRel(formData);
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
        initMealList() {
            getMealList({}).then((res) => {
                if (res.code === 200) {
                    this.mealList = res.data;
                }
            });
        },
        initDishNameList() {
            getDishNameList({}).then((res) => {
                if (res.code === 200) {
                    this.dishNameList = res.data;
                }
            });
        },
        getMock(record) {
            const targetKeys = [];
            const mockData = [];
            const list = this.dishNameList;
            for (let i = 0; i < list.length; i++) {
                const data = {
                    key: (list[i].id).toString(),
                    title: list[i].name,
                    description: list[i].name,
                };
                mockData.push(data);
            }
            // 获取已选择的菜品类别
            let IdList = record.dishNameId ? record.dishNameId.split(',') : [];
            // 处理已选择的菜品类别
            IdList.forEach(item => {
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