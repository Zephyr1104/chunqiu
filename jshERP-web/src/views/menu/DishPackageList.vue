<template>
    <a-row :gutter="24">
        <a-col :md="24">
            <a-card :style="cardStyle" :bordered="false">
                <!-- 查询区域 -->
                <div class="table-page-search-wrapper">
                    <!-- 搜索区域 -->
                    <a-form layout="inline" @keyup.enter.native="searchQuery">
                        <a-row :gutter="24">
                            <a-col :md="6" :sm="24">
                                <a-form-item label="名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-input placeholder="请输入名称查询" v-model="queryParam.name"></a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :md="6" :sm="24">
                                <a-form-item label="餐次类型" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-select placeholder="选择餐次类型" showSearch optionFilterProp="children"
                                        v-model="queryParam.mealType">
                                        <a-select-option v-for="(item, index) in mealList" :key="index"
                                            :value="item.id">
                                            {{ item.name }}
                                        </a-select-option>
                                    </a-select>
                                </a-form-item>
                            </a-col>
                            <span style="float: left;overflow: hidden;" class="table-page-search-submitButtons">
                                <a-col :md="6" :sm="24">
                                    <a-button type="primary" @click="searchQuery">查询</a-button>
                                    <a-button style="margin-left: 8px" @click="searchReset">重置</a-button>
                                </a-col>
                            </span>
                        </a-row>
                    </a-form>
                </div>
                <!-- 操作按钮区域 -->
                <div class="table-operator" style="margin-top: 5px">
                    <a-button v-if="btnEnableList.indexOf(1) > -1" @click="handleAdd" type="primary"
                        icon="plus">新增</a-button>
                    <a-button v-if="btnEnableList.indexOf(1) > -1" @click="batchDel" icon="delete">删除</a-button>
                </div>
                <!-- table区域-begin -->
                <div>
                    <a-table ref="table" size="middle" bordered rowKey="id" :columns="columns" :dataSource="dataSource"
                        :pagination="ipagination" :scroll="scroll" :loading="loading"
                        :rowSelection="{ selectedRowKeys: selectedRowKeys, onChange: onSelectChange }"
                        @change="handleTableChange">
                        <span slot="action" slot-scope="text, record">
                            <a @click="handleEdit(record)">编辑</a>
                            <a-divider v-if="btnEnableList.indexOf(1) > -1" type="vertical" />
                            <a-popconfirm v-if="btnEnableList.indexOf(1) > -1" title="确定删除吗?"
                                @confirm="() => handleDelete(record.id)">
                                <a>删除</a>
                            </a-popconfirm>
                        </span>
                        <!-- 状态渲染模板 -->
                    </a-table>
                </div>
                <!-- table区域-end -->
                <!-- 表单区域 -->
                <dish-package-modal ref="modalForm" @ok="modalFormOk" />
            </a-card>
        </a-col>
    </a-row>
</template>
<script>
import DishPackageModal from './modules/DishPackageModal.vue'
import { JeecgListMixin } from '@/mixins/JeecgListMixin'
import { getMealList } from '@/api/api'
import JDate from '@/components/jeecg/JDate'
import { postAction } from '@api/manage'
export default {
    name: "DishPackageList",
    mixins: [JeecgListMixin],
    components: {
        JDate,
        DishPackageModal,
    },
    data() {
        return {
            labelCol: {
                span: 5
            },
            wrapperCol: {
                span: 18,
                offset: 1
            },

            mealList:{},

            // 查询条件
            queryParam: { name: '', mealType: '' },
            // 表头
            columns: [
                {
                    title: '#',
                    dataIndex: '',
                    key: 'rowIndex',
                    width: 40,
                    align: "center",
                    customRender: function (t, r, index) {
                        return parseInt(index) + 1;
                    }
                },
                {
                    title: '操作',
                    dataIndex: 'action',
                    align: "center",
                    width: 200,
                    scopedSlots: { customRender: 'action' },
                },
                { title: '名称', dataIndex: 'name', },
                { title: '餐次', dataIndex: 'mealName', },
                { title: '套餐菜品类别明细', dataIndex: 'dishDetailStr', },
                { title: '创建时间', dataIndex: 'createTimeStr', width: 150, align: "center"},
            ],
            url: {
                list: "/dishPackage/list",
                delete: "/dishPackage/delete",
                deleteBatch: "/dishPackage/deleteBatch",
            }
        }
    },
    created() {
        this.initMealList();
    },
    computed: {

    },
    methods: {
        handleEdit: function (record) {
            this.$refs.modalForm.edit(record);
            this.$refs.modalForm.title = "编辑";
            this.$refs.modalForm.disableSubmit = false;
        },
        initMealList() {
            getMealList({}).then((res) => {
                if (res.code === 200) {
                    this.mealList = res.data;
                }
            });
        },
    }
}
</script>
<style scoped>
@import '~@assets/less/common.less'
</style>