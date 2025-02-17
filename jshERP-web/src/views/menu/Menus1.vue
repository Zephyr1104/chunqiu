<template>
    <a-row :gutter="24">
        <a-col :md="24">
            <div class="menus-page reset-ant">
                <!-- 左侧菜单 -->
                <div class="menus-page-left-panel-container">
                    <div class="menus-page-left-panel-base menus-page-left-panel">
                        <div class="meals-panel-container">
                            <div class="meals-panel">
                                <div class="semester-select">
                                    <a-select style="width: 100%" @change="handleInformationChange">
                                        <a-select-option v-for="(item, index) in informationList" :key="index"
                                            :value="item.id">
                                            {{ item.name }}
                                        </a-select-option>
                                    </a-select>
                                    <div class="active-semester">当前央厨</div>
                                </div>
                                <div class="meals-panel-list">
                                    <div class="ant-collapse ant-collapse-icon-position-start ant-collapse-ghost">
                                        <div class="ant-collapse-item ant-collapse-item-active ant-collapse-no-arrow">
                                            <div class="ant-collapse-header" aria-expanded="true" aria-disabled="false"
                                                role="button" tabindex="0">
                                                <div class="ant-collapse-header-text">
                                                    <div class="collapse-header">
                                                        <div class="collapse-header-container">
                                                            <span class="collapse-header-title">早餐</span>
                                                            <div class="collapse-header-icon-container"></div>
                                                        </div>
                                                        <div class="collapse-header-extra">
                                                            <span>新建餐标</span>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="ant-collapse-content ant-collapse-content-active"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="meals-panel-footer">
                                    <div @click="handleAdd" class="meals-panel-footer-btn">餐次管理</div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="collapse-control">
                        <a-icon type="left" />
                    </div>
                </div>
                <!-- 右侧内容 -->
                <div class="menus-page-content"></div>
            </div>
            <!-- 表单区域 -->
            <meal-modal ref="mealModalForm" @ok="modalFormOk"></meal-modal>
        </a-col>
    </a-row>
</template>

<script>
import './css/Menus.css'
import MealModal from '../system/modules/MealModal.vue'
import { getMealList, getInformationList } from '@/api/api'
export default {
    name: 'Menus',
    components: {
        MealModal,
    },
    data() {
        return {
            // 央厨列表
            informationList: [],
            // 餐次列表
            mealList: [],
            mealText: `A dog is a type of domesticated animal. Known for its loyalty and faithfulness, it can be found as a welcome guest in many households across the world.`,
        }
    },
    methods: {
        // 获取央厨列表
        initInformationList() {
            getInformationList({}).then((res) => {
                if (res != null && res.length > 0) {
                    this.informationList = res;
                }
            })
        },
        // 获取餐次列表
        initMealList() {
            getMealList({}).then((res) => {
                if (res.code === 200) {
                    this.mealList = res.data;
                    console.log(this.mealList);

                }
            })
        },
        // 央厨选择
        handleInformationChange(value) {
            console.log(value);
        },
        // 新增餐次
        handleAdd() {
            this.$refs.mealModalForm.add();
            this.$refs.mealModalForm.title = "新增";
            this.$refs.mealModalForm.disableSubmit = false;
        },
        modalFormOk() {
            // 新增/修改 成功时，重载列表
            this.loadData()
        },
    },
    created() {
        // 读取本地缓存数据
        this.initInformationList();
        this.initMealList();
        // 进行初始化操作
        // ...
    },
    mounted() {
        // 读取本地缓存数据

        // 进行DOM相关操作
        // ...
    },
    beforeDestroy() {
        // 保存数据到本地缓存

        // 清理工作
        // ...
    },
}
</script>

<style scoped>
@import '~@assets/less/common.less'
</style>