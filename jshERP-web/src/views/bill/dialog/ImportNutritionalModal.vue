<template>
  <a-modal :title="title" :width="500" :visible="visible" :confirmLoading="confirmLoading"
    :maskStyle="{ 'top': '93px', 'left': '154px' }" @cancel="handleCancel" cancelText="关闭"
    wrapClassName="ant-modal-cust-warp" style="top:20%;height: 55%;overflow-y: hidden">
    <template slot="footer">
      <a-button key="back" @click="handleCancel">
        关闭
      </a-button>
    </template>
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="模板">
          <span><a href="/doc/agreement_price_template.xls" target="_blank"><b>营养成分录入Excel模板[下载]</b></a></span>
        </a-form-item>
        <a-form-item :labelCol="labelCol" :wrapperCol="wrapperCol" label="文件">
          <a-upload name="file" :showUploadList="false" :multiple="false" :headers="tokenHeader" :data="setFileData"
            :action="importExcelUrl" @change="handleImportExcel">
            <a-button type="primary" icon="import">导入</a-button>
          </a-upload>
        </a-form-item>
      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
import { ACCESS_TOKEN } from '@/store/mutation-types'
import Vue from 'vue'

export default {
  name: "importNutritionalExcel",
  components: {
  },
  data() {
    return {
      title: "导入营养成分录入",
      visible: false,
      prefixNo: '',
      model: {},
      tokenHeader: { 'X-Access-Token': Vue.ls.get(ACCESS_TOKEN) },
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
      url: {
        importExcelUrl: "/nutritional/importNutritionalExcel",
      }
    }
  },
  created() {
  },
  computed: {
    importExcelUrl: function () {
      return `${window._CONFIG['domianURL']}${this.url.importExcelUrl}`;
    }
  },
  methods: {
    add(prefixNo) {
      this.prefixNo = prefixNo
      this.form.resetFields()
      this.model = Object.assign({}, {})
      this.visible = true
    },
    close() {
      this.$emit('close');
      this.visible = false;
    },
    handleCancel() {
      this.close()
    },
    //导入
    handleImportExcel(info) {
      if (info.file.status !== 'uploading') {
        console.log(info.file, info.fileList);
      }
      if (info.file.status === 'done') {
        if (info.file.response) {
          if (info.file.response.code === 200) {
            this.$message.success('导入成功' + info.file.response.data.rows.length + '条')
            this.$emit('ok', info.file.response.data.rows);
            this.close()
          } else if (info.file.response.code === 500) {
            this.$message.warn(info.file.response.data.message)
          }
        } else {
          this.$message.error(`${info.file.name} ${info.file.response.data}.`);
        }
      } else if (info.file.status === 'error') {
        this.$message.error(`文件导入失败: ${info.file.msg} `);
      }
    },
    setFileData() {
      return {
        'prefixNo': this.prefixNo
      }
    },
  }
}
</script>
<style scoped></style>