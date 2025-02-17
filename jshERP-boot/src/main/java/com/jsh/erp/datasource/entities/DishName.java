package com.jsh.erp.datasource.entities;

import java.util.Date;

public class DishName {
    private Long id;

    private String name;

    private String nameType;

    private String cookingType;

    private String mainType;

    private String cuisineType;

    private String colorType;

    private String tasteType;

    private String allergen;

    private Long creator;

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

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType == null ? null : nameType.trim();
    }

    public String getCookingType() {
        return cookingType;
    }

    public void setCookingType(String cookingType) {
        this.cookingType = cookingType == null ? null : cookingType.trim();
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType == null ? null : mainType.trim();
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType == null ? null : cuisineType.trim();
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType == null ? null : colorType.trim();
    }

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType == null ? null : tasteType.trim();
    }

    public String getAllergen() {
        return allergen;
    }

    public void setAllergen(String allergen) {
        this.allergen = allergen == null ? null : allergen.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
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