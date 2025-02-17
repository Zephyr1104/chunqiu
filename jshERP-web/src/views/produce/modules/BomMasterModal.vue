<template>
    <div ref="container">
        <a-modal :title="title" :width="1200" :visible="visible" :confirmLoading="confirmLoading"
            :getContainer="() => $refs.container" :maskStyle="{ 'top': '93px', 'left': '154px' }"
            :wrapClassName="wrapClassNameInfo()" :mask="isDesktop()" :maskClosable="false" @ok="handleOk"
            @cancel="handleCancel" cancelText="取消" okText="保存" style="top:10%;height: 70%;">
            <template slot="footer">
                <a-button key="back" v-if="isReadOnly" @click="handleCancel">
                    取消
                </a-button>
            </template>
            <a-spin :spinning="confirmLoading">
                <a-form :form="form" id="BomMasterModal">
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="BOM类别">
                        <a-select placeholder="选择BOM类别" v-model="bomTypeList.value"
                            v-decorator.trim="['bomType', validatorRules.required]">
                            <a-select-option v-for="(item, index) in bomTypeList.options" :key="index" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="BOM商品">
                        <a-select placeholder="选择BOM商品" v-decorator.trim="['materialId', validatorRules.required]"
                            :dropdownMatchSelectWidth="false" @change="handleDishNameChange">
                            <a-select-option v-for="(item, index) in dishNameList" :key="index" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="BOM名称">
                        <a-input v-decorator.trim="['name', validatorRules.name]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="BOM编码">
                        <a-input v-decorator.trim="['bomCode', validatorRules.required]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="总出成率">
                        <a-input-number v-decorator.trim="['cookYieldRate', { initialValue: 100 }]" :min="1" :max="100" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="描述">
                        <a-textarea :rows="2" placeholder="请输入描述" v-decorator.trim="['remark']" />
                    </a-form-item>



                </a-form>
            </a-spin>
        </a-modal>
    </div>
</template>
<script>
import pick from 'lodash.pick'
import JSelectMultiple from '@/components/jeecg/JSelectMultiple'
import { addBomMaster, editBomMaster, getBomMasterList, getDishNameList } from '@/api/api'
import { mixinDevice } from '@/utils/mixin'
import { getAction } from '@/api/manage'
import { pinyin } from 'pinyin-pro'
export default {
    name: "BomMasterModal",
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

            dishNameList: [],
            randomCode: 0,
            // BOM类别
            bomTypeList: {
                value: '',
                options: [
                    { id: 1, name: '单品BOM' },
                    { id: 2, name: '组合BOM' },
                    { id: 3, name: '包装BOM' },
                ]
            },
            confirmLoading: false,
            form: this.$form.createForm(this),
            validatorRules: {
                name: {
                    rules: [
                        { required: true, message: '请输入名称!' },
                        { min: 2, max: 30, message: '长度在 2 到 30 个字符', trigger: 'blur' },
                        { validator: this.validateDishName }
                    ]
                },
                required: {
                    rules: [
                        { required: true, message: '此项为必填项' }
                    ]
                },
            },
        }
    },
    created() {
        this.initDishNameList();
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
                    'bomType','name','bomCode','cookYieldRate','remark'))
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
                    if (!this.model.id) {
                        obj = addBomMaster(formData);
                    } else {
                        obj = editBomMaster(formData);
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
        // 加载DishName列表
        initDishNameList() {
            getDishNameList().then(res => {
                if (res.code === 200) {
                    this.dishNameList = res.data;
                }
            })
        },
        handleDishNameChange(value) {
            let dishName = "";
            let params = {
                id: value
            }
            getAction('/dishName/getDishNameById', params).then((res) => {
                dishName = res.data.name;
                this.changeNameAndCode(dishName);
            })
        },
        // 改变名称和编码
        changeNameAndCode(name) {
            // 用于存储名字的拼音首字母，初始化为空字符串
            let nameInitialsLower = "";

            if (name.length > 0) {
                try {
                    // 使用pinyin库获取名字的拼音首字母，设置模式为'initial'获取首字母，去除首尾空格，替换连续空格为单个空格，再转换为小写
                    nameInitialsLower = pinyin(name, {
                        pattern: 'initial',
                    }).trim().replace(/\s+/g, '').toLowerCase();
                } catch (error) {
                    // 如果pinyin函数执行出错，打印错误信息并将nameInitialsLower设置为空字符串
                    console.error("获取拼音首字母时出错：", error);
                    nameInitialsLower = "";
                }
            }
            // 生成随机码，这里假设this.randomCode已经在其他地方正确定义和生成
            const randomCode = this.getRandomCode();
            // 写入name和由拼音首字母小写形式与随机码拼接而成的bomCode到表单字段中
            this.form.setFieldsValue({
                "name": name,
                "bomCode": nameInitialsLower + randomCode
            });
        },
        // 生成Code
        getRandomCode(min = 1000, max = 9999) {
            if (min > max) {
                throw new Error("最小值不能大于最大值");
            }
            // 获取指定范围内的随机整数（包括最小值和最大值）
            var randomInt = Math.floor(Math.random() * (max - min + 1)) + min;
            let randomCode = randomInt.toString();
            return randomCode;
        }
    },
}
</script>
<style scoped></style>