package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Energy {

    private Long id;

    private String category;

    private String unit;

    private BigDecimal unitPrice;

    private Long expenseItem;

    private Long minimumUnit;

    private Long conversion;

    private String orgNo;

    private Long userId;

    private Date createDate;

    private Boolean enabled;

    private Long tenantId;

    private String deleteFlag;

    private Boolean isDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getExpenseItem() {
        return expenseItem;
    }

    public void setExpenseItem(Long expenseItem) {
        this.expenseItem = expenseItem;
    }

    public Long getMinimumUnit() {
        return minimumUnit;
    }

    public void setMinimumUnit(Long minimumUnit) {
        this.minimumUnit = minimumUnit;
    }

    public Long getConversion() {
        return conversion;
    }

    public void setConversion(Long conversion) {
        this.conversion = conversion;
    }

    public String getOrgNo() {
        return orgNo;
    }

    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}