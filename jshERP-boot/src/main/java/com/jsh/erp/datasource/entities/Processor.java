package com.jsh.erp.datasource.entities;

import java.util.Date;

public class Processor {
    private Long id;

    private String processorNo;

    private String processorAbr;

    private Long parentId;

    private Long sort;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private Long tenantId;

    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessorNo() {
        return processorNo;
    }

    public void setProcessorNo(String processorNo) {
        this.processorNo = processorNo == null ? null : processorNo.trim();
    }

    public String getProcessorAbr() {
        return processorAbr;
    }

    public void setProcessorAbr(String processorAbr) {
        this.processorAbr = processorAbr == null ? null : processorAbr.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}