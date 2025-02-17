package com.jsh.erp.datasource.entities;

import java.util.Date;

public class Information {
    private Long id;

    private String code;

    private String name;

    private String shortName;

    private Long department;

    private String profitCenter;

    private Integer kitchenType;

    private Long planningDepartment;

    private Long upDepartment;

    private Long recipeTerminal;

     private String coldTerminal;

    private String bucketSource;

    private String head;

    private String telephone;

    private String customers;

    private String addr;

    private Long packagingLine;

    private Long tenantId;

    private Long userId;

    private String deleteFlag;

    private Date createDate;

    private Boolean isDefault;

    private Boolean enabled;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public String getProfitCenter() {
        return profitCenter;
    }

    public void setProfitCenter(String profitCenter) {
        this.profitCenter = profitCenter;
    }

    public Integer getKitchenType() {
        return kitchenType;
    }

    public void setKitchenType(Integer kitchenType) {
        this.kitchenType = kitchenType;
    }

    public Long getPlanningDepartment() {
        return planningDepartment;
    }

    public void setPlanningDepartment(Long planningDepartment) {
        this.planningDepartment = planningDepartment;
    }

    public Long getUpDepartment() {
        return upDepartment;
    }

    public void setUpDepartment(Long upDepartment) {
        this.upDepartment = upDepartment;
    }

    public Long getRecipeTerminal() {
        return recipeTerminal;
    }

    public void setRecipeTerminal(Long recipeTerminal) {
        this.recipeTerminal = recipeTerminal;
    }

    public String getColdTerminal() {
        return coldTerminal;
    }

    public void setColdTerminal(String coldTerminal) {
        this.coldTerminal = coldTerminal;
    }

    public String getBucketSource() {
        return bucketSource;
    }

    public void setBucketSource(String bucketSource) {
        this.bucketSource = bucketSource;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getPackagingLine() {
        return packagingLine;
    }

    public void setPackagingLine(Long packagingLine) {
        this.packagingLine = packagingLine;
    }

}