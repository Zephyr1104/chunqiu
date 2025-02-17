<template>
    <a-row :gutter="24">
        <a-col :md="24">
            <a-card :style="cardStyle" :bordered="false">
                <!-- 查询区域 -->
                <div class="table-page-search-wrapper">
                    <!-- 搜索区域 -->
                    <a-form layout="inline" @keyup.enter.native="searchQuery">
                        <a-row :gutter="24">
                            <a-col :md="4" :sm="24">
                                <a-form-item label="菜名" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                <a-select placeholder="请选择餐品名称" showSearch optionFilterProp="children"
                                        v-model="queryParam.dishNameId">
                                        <a-select-option v-for="(item, index) in dishNameList" :key="index"
                                            :value="item.id">
                                            {{ item.name }}
                                        </a-select-option>
                                    </a-select>
                                </a-form-item>
                            </a-col>
                            <a-col :md="4" :sm="24">
                                <a-form-item label="餐标" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-input placeholder="请输入餐标价格" v-model="queryParam.diningPrice"></a-input>
                                </a-form-item>
                            </a-col>
                            <a-col :md="4" :sm="24">
                                <a-form-item label="餐次类型" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-select placeholder="选择餐次类型" showSearch optionFilterProp="children"
                                        v-model="queryParam.mealId">
                                        <a-select-option v-for="(item, index) in mealList" :key="index"
                                            :value="item.id">
                                            {{ item.name }}
                                        </a-select-option>
                                    </a-select>
                                </a-form-item>
                            </a-col>
                            <a-col :md="6" :sm="24">
                                <a-form-item label="用餐日期" :labelCol="labelCol" :wrapperCol="wrapperCol">
                                    <a-range-picker style="width:100%" v-model="queryParam.createTimeRange"
                                        format="YYYY-MM-DD" :placeholder="['开始时间', '结束时间']" @change="onDateChange"
                                        @ok="onDateOk" />
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
                            <a v-if="btnEnableList.indexOf(1) > -1" @click="myHandleCopyAdd(record)">复制</a>
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
                <menus-modal ref="menusModal" @ok="modalFormOk" />
            </a-card>
        </a-col>
    </a-row>
</template>
<script>
import MenusModal from './modules/MenusModal.vue'
import { JeecgListMixin } from '@/mixins/JeecgListMixin'
import { getMealList,getDishNameList } from '@/api/api'
import JDate from '@/components/jeecg/JDate'
import { postAction } from '@api/manage'
export default {
    name: "Menus",
    mixins: [JeecgListMixin],
    components: {
        JDate,
        MenusModal,
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

            mealList: {},
            dishNameList: {},

            // 查询条件
            queryParam: { dishNameId:'',diningPrice: '', mealId: '' },
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
                { title: '餐标价格', dataIndex: 'diningPrice', width: 80, align: "center" },
                { title: '用餐日期', dataIndex: 'diningDateStr', width: 150, align: "center" },
                { title: '星期', dataIndex: 'weekDay', width: 100, align: "center" },
                { title: '餐次名称', dataIndex: 'mealName', width: 100, align: "center" },
                { title: '菜品名称明细', dataIndex: 'dishName', },
                { title: '创建时间', dataIndex: 'createTimeStr', width: 150, align: "center" },
            ],
            url: {
                list: "/dishMealRel/list",
                delete: "/dishMealRel/delete",
                deleteBatch: "/dishMealRel/deleteBatch",
            }
        }
    },
    created() {
        this.initMealList();
        this.initDishNameList();
    },
    computed: {

    },
    methods: {
        handleAdd() {
            this.$refs.menusModal.action = "add";
            if (this.btnEnableList.indexOf(2) === -1) {
                this.$refs.menusModal.isCanCheck = false
            }
            this.$refs.menusModal.add();
            this.$refs.menusModal.title = "新增";
            this.$refs.menusModal.disableSubmit = false;
        },
        handleEdit: function (record) {
            this.$refs.menusModal.action = "edit";
            if (this.btnEnableList.indexOf(2) === -1) {
                this.$refs.menusModal.isCanCheck = false
            }
            this.$refs.menusModal.edit(record);
            this.$refs.menusModal.title = "编辑";
            this.$refs.menusModal.disableSubmit = false;
        },
        myHandleCopyAdd(record) {
            this.$refs.menusModal.action = "copyAdd";
            if (this.btnEnableList.indexOf(2) === -1) {
                this.$refs.menusModal.isCanCheck = false
            }
            // 复制单据的时候需要移除关联单据的相关信息
            this.$refs.menusModal.edit(record);
            this.$refs.menusModal.title = "复制新增";
            this.$refs.menusModal.isCanCheck = true
        },
        onDateChange: function (value, dateString) {
            this.queryParam.beginTime = dateString[0];
            this.queryParam.endTime = dateString[1];
        },
        onDateOk(value) {
            console.log(value);
        },
        modalFormOk() {
            // 新增/修改 成功时，重载列表
            this.loadData()
        },
        initMealList() {
            getMealList({}).then((res) => {
                if (res.code === 200) {
                    this.mealList = res.data;
                }
            });
        },
        initDishNameList(){
            getDishNameList({}).then((res) => {
                if (res.code === 200) {
                    this.dishNameList = res.data;
                    console.log(this.dishNameList);
                    
                }
            });
        }
    }
}
</script>
<style scoped>
@import '~@assets/less/common.less'
</style>