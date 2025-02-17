package com.jsh.erp.datasource.entities;

import java.util.Date;

public class BomMaster {
    private Long id;

    private String name;

    private String bomCode;

    private Long creator;

    private String materialId;

    private String processorId;

    private Long bomType;

    private Long cookYieldRate;

    private String customerIds;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBomCode() {
        return bomCode;
    }

    public void setBomCode(String bomCode) {
        this.bomCode = bomCode == null ? null : bomCode.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId == null ? null : materialId.trim();
    }

    public String getProcessorId() {
        return processorId;
    }

    public void setProcessorId(String processorId) {
        this.processorId = processorId == null ? null : processorId.trim();
    }

    public Long getBomType() {
        return bomType;
    }

    public void setBomType(Long bomType) {
        this.bomType = bomType;
    }

    public Long getCookYieldRate() {
        return cookYieldRate;
    }

    public void setCookYieldRate(Long cookYieldRate) {
        this.cookYieldRate = cookYieldRate;
    }

    public String getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(String customerIds) {
        this.customerIds = customerIds == null ? null : customerIds.trim();
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