package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Restaurant {
    private Long id;

    private String code;

    private String name;

    private String shortName;

    private BigDecimal belongingRestaurant;

    private String head;

    private String telephone;

    private BigDecimal department;

    private String supplyArea;

    private String managementArea;

     private String province;

    private String city;

    private String addr;

    private String remarks;

    private String customerGrouping;

    private Integer centralKitchen;

    private Integer terminalType;

    private String menuMode;

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

    public BigDecimal getBelongingRestaurant() {
        return belongingRestaurant;
    }

    public void setBelongingRestaurant(BigDecimal belongingRestaurant) {
        this.belongingRestaurant = belongingRestaurant;
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

    public BigDecimal getDepartment() {
        return department;
    }

    public void setDepartment(BigDecimal department) {
        this.department = department;
    }

    public String getSupplyArea() {
        return supplyArea;
    }

    public void setSupplyArea(String supplyArea) {
        this.supplyArea = supplyArea;
    }

    public String getManagementArea() {
        return managementArea;
    }

    public void setManagementArea(String managementArea) {
        this.managementArea = managementArea;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCustomerGrouping() {
        return customerGrouping;
    }

    public void setCustomerGrouping(String customerGrouping) {
        this.customerGrouping = customerGrouping;
    }

    public Integer getCentralKitchen() {
        return centralKitchen;
    }

    public void setCentralKitchen(Integer centralKitchen) {
        this.centralKitchen = centralKitchen;
    }

    public Integer getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(Integer terminalType) {
        this.terminalType = terminalType;
    }

    public String getMenuMode() {
        return menuMode;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;
    }

}