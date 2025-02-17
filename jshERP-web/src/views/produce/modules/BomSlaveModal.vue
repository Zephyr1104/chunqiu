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
                <a-form :form="form" id="BomSlaveModal">
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="主BOM">
                        <a-select placeholder="选择主BOM" v-decorator.trim="['bomMasterId', validatorRules.required]"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in bomMasterList" :key="item.id" :value="item.id">
                                {{ item.name }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="物料名称">
                        <a-select showSearch @search="handleMaterialSearch" placeholder="选择物料名称"
                            v-decorator.trim="['materialId', validatorRules.required]"
                            :dropdownMatchSelectWidth="false">
                            <a-select-option v-for="(item, index) in materialList" :key="item.barCode"
                                :value="item.barCode">
                                {{ item.materialStr }}
                            </a-select-option>
                        </a-select>
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="数量">
                        <a-input v-decorator.trim="['quantity', validatorRules.required]" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="单位">
                        <a-input placeholder="请输入单位" v-decorator.trim="['unit']" />
                    </a-form-item>
                    <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="价格">
                        <a-input v-decorator.trim="['unitPrice', validatorRules.required]" />
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
import { mixinDevice } from '@/utils/mixin'
import { addBomSlave, editBomSlave, getBomSlaveList } from '@/api/api'
import { getMaterialByParam } from '@/api/api'
import { getAction } from '@/api/manage'
export default {
    name: "BomSlaveModal",
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

            bomMasterList: [],
            materialList: [],

            confirmLoading: false,
            form: this.$form.createForm(this),
            validatorRules: {
                required: {
                    rules: [
                        { required: true, message: '此项为必填项' }
                    ]
                },
            },
        }
    },
    created() {
        this.initBomMasterList();
    },
    methods: {
        add() {
            this.edit({});
        },
        edit(record) {
            this.form.resetFields();
            this.model = Object.assign({}, record);
            this.visible = true;
            console.log(this.model);
            
            this.$nextTick(() => {
                this.form.setFieldsValue(pick(this.model,
                    'bomMasterId','bomMasterName','materialId','materialName','quantity','unit','unitPrice','remark'))
            });
            this.initBomMasterList();
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
                        obj = addBomSlave(formData);
                    } else {
                        obj = editBomSlave(formData);
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
        initBomMasterList() {
            getAction('/bomMaster/getAllList').then((res) => {
                this.bomMasterList = res.data;
            })
        },
        fetchMaterialList(value) {
            getMaterialByParam({ q: value }).then((res) => {
                if (res && res.code === 200) {
                    this.materialList = res.data;
                } else {
                    // 处理错误情况，例如显示错误消息给用户
                    this.$message.error('获取物料列表失败');
                }
            }).catch((error) => {
                // 处理网络错误或其他异常
                console.error('获取物料列表时发生错误:', error);
                this.$message.error('获取物料列表时发生错误');
            });
        },
        handleMaterialSearch(value) {
            this.fetchMaterialList(value);
        },

    },
}
</script>
<style scoped></style>