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
                <dish-group-modal ref="modalForm" @ok="modalFormOk"></dish-group-modal>
            </a-card>
        </a-col>
    </a-row>
</template>
<script>
import DishGroupModal from './modules/DishGroupModal.vue'
import { JeecgListMixin } from '@/mixins/JeecgListMixin'
import JDate from '@/components/jeecg/JDate'
import { postAction } from '@api/manage'
export default {
    name: "DishGroupList",
    mixins: [JeecgListMixin],
    components: {
        JDate,
        DishGroupModal
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
            // 查询条件
            queryParam: { name: '',},
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
            ],
            url: {
                list: "/dishGroup/list",
                delete: "/dishGroup/delete",
                deleteBatch: "/dishGroup/deleteBatch",
                batchSetStatusUrl: "/dishGroup/batchSetStatus"
            }
        }
    },
    computed: {

    },
    methods: {
        handleEdit: function (record) {
            this.$refs.modalForm.edit(record);
            this.$refs.modalForm.title = "编辑";
            this.$refs.modalForm.disableSubmit = false;
        },
    }
}
</script>
<style scoped>
@import '~@assets/less/common.less'
</style>