package com.jsh.erp.datasource.entities;

import java.util.Date;

public class FoodCategory {
    private Long id;

    private String name;

    private Long cooking;

    private Long purchase;

    private Long sort;

    private String remark;

    private Boolean enabled;

    private Date createTime;

    private Date updateTime;

    private Date enabledTime;

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

    public Long getCooking() {
        return cooking;
    }

    public void setCooking(Long cooking) {
        this.cooking = cooking;
    }

    public Long getPurchase() {
        return purchase;
    }

    public void setPurchase(Long purchase) {
        this.purchase = purchase;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Date getEnabledTime() {
        return enabledTime;
    }

    public void setEnabledTime(Date enabledTime) {
        this.enabledTime = enabledTime;
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