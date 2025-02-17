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
                                <a-form-item label="过敏原" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-input placeholder="请输入过敏原查询" v-model="queryParam.allergen"></a-input>
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
                <dish-name-modal ref="modalForm" @ok="modalFormOk"></dish-name-modal>
            </a-card>
        </a-col>
    </a-row>
</template>
<script>
import DishNameModal from './modules/DishNameModal.vue'
import { JeecgListMixin } from '@/mixins/JeecgListMixin'
import JDate from '@/components/jeecg/JDate'
import { postAction } from '@api/manage'
export default {
    name: "DishNameList",
    mixins: [JeecgListMixin],
    components: {
        JDate,
        DishNameModal
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
            queryParam: { name: '', allergen: '' },
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
                { title: '菜品类型', dataIndex: 'nameTypeName', },
                {
                    title: '烹饪主工艺', dataIndex: 'cookingType',
                    customRender: function (t, r, index) {
                        let cookingTypeName = '';
                        switch (t) {
                            case '1':
                                cookingTypeName = '炒'
                                break;
                            case '2':
                                cookingTypeName = '焖'
                                break;
                            case '3':
                                cookingTypeName = '蒸'
                                break;
                            case '4':
                                cookingTypeName = '煎'
                                break;
                            case '5':
                                cookingTypeName = '卤'
                                break;
                            case '6':
                                cookingTypeName = '熘'
                                break;
                            case '7':
                                cookingTypeName = '烧'
                                break;
                            case '8':
                                cookingTypeName = '烤'
                                break;
                            case '9':
                                cookingTypeName = '炸'
                                break;
                            case '10':
                                cookingTypeName = '炖'
                                break;
                            case '11':
                                cookingTypeName = '煮'
                                break;
                            case '12':
                                cookingTypeName = '煲'
                                break;
                            case '13':
                                cookingTypeName = '烩'
                                break;
                        }
                        return cookingTypeName;
                    }
                },
                {
                    title: '主材类别', dataIndex: 'mainType',
                    customRender: function (t, r, index) {
                        let mainTypeName = '';
                        switch (t) {
                            case '1':
                                mainTypeName = '猪肉类'
                                break;
                            case '2':
                                mainTypeName = '鸡肉类'
                                break;
                            case '3':
                                mainTypeName = '鸭肉类'
                                break;
                            case '4':
                                mainTypeName = '牛肉类'
                                break;
                            case '5':
                                mainTypeName = '鱼虾类'
                                break;
                            case '6':
                                mainTypeName = '蛋类'
                                break;
                            case '7':
                                mainTypeName = '腊肉类'
                                break;
                            case '8':
                                mainTypeName = '豆腐类'
                                break;
                            case '9':
                                mainTypeName = '鹅肉类'
                                break;
                        }
                        return mainTypeName;
                    }
                },
                {
                    title: '菜系', dataIndex: 'cuisineType',
                    customRender: function (t, r, index) {
                        let cuisineTypeName = '';
                        switch (t) {
                            case '1':
                                cuisineTypeName = '粤菜'
                                break;
                            case '2':
                                cuisineTypeName = '客家菜'
                                break;
                            case '3':
                                cuisineTypeName = '闽菜'
                                break;
                            case '4':
                                cuisineTypeName = '豫菜'
                                break;
                            case '5':
                                cuisineTypeName = '湘菜'
                                break;
                        }
                        return cuisineTypeName;
                    }
                },
                // { title: '色系', dataIndex: 'colorType', },
                {
                    title: '味型', dataIndex: 'tasteType',
                    customRender: function (t, r, index) {
                        let tasteTypeName = '';
                        switch (t) {
                            case '1':
                                tasteTypeName = '咸'
                                break;
                            case '2':
                                tasteTypeName = '甜'
                                break;
                            case '3':
                                tasteTypeName = '苦'
                                break;
                            case '4':
                                tasteTypeName = '辣'
                                break;
                            case '5':
                                tasteTypeName = '酸'
                                break;
                            case '6':
                                tasteTypeName = '鲜'
                                break;
                            case '7':
                                tasteTypeName = '香'
                                break;
                        }
                        return tasteTypeName;
                    },
                },
                { title: '过敏原', dataIndex: 'allergen', },
                { title: '操作员', dataIndex: 'creatorName', },
            ],
            url: {
                list: "/dishName/list",
                delete: "/dishName/delete",
                deleteBatch: "/dishName/deleteBatch",
                batchSetStatusUrl: "/dishName/batchSetStatus"
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