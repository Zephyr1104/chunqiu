package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Nutritional {
    private Long id;

    private String name;

    private BigDecimal eat;

    private BigDecimal energy;

    private BigDecimal water;

    private BigDecimal protein;

    private BigDecimal fat;

    private BigDecimal fiber;

    private BigDecimal carbohydrates;

    private BigDecimal vitaminA;

     private BigDecimal vitaminB1;

    private BigDecimal vitaminB2;

    private BigDecimal niacin;

    private BigDecimal vitaminE;

    private BigDecimal sodium;

    private BigDecimal calcium;

    private BigDecimal iron;

    private BigDecimal vitaminC;

    private BigDecimal cholesterol;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getEat() {
        return eat;
    }

    public void setEat(BigDecimal eat) {
        this.eat = eat;
    }

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(BigDecimal water) {
        this.water = water;
    }

    public BigDecimal getProtein() {
        return protein;
    }

    public void setProtein(BigDecimal protein) {
        this.protein = protein;
    }

    public BigDecimal getFat() {
        return fat;
    }

    public void setFat(BigDecimal fat) {
        this.fat = fat;
    }

    public BigDecimal getFiber() {
        return fiber;
    }

    public void setFiber(BigDecimal fiber) {
        this.fiber = fiber;
    }

    public BigDecimal getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(BigDecimal carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public BigDecimal getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(BigDecimal vitaminA) {
        this.vitaminA = vitaminA;
    }

    public BigDecimal getVitaminB1() {
        return vitaminB1;
    }

    public void setVitaminB1(BigDecimal vitaminB1) {
        this.vitaminB1 = vitaminB1;
    }

    public BigDecimal getVitaminB2() {
        return vitaminB2;
    }

    public void setVitaminB2(BigDecimal vitaminB2) {
        this.vitaminB2 = vitaminB2;
    }

    public BigDecimal getNiacin() {
        return niacin;
    }

    public void setNiacin(BigDecimal niacin) {
        this.niacin = niacin;
    }

    public BigDecimal getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(BigDecimal vitaminE) {
        this.vitaminE = vitaminE;
    }

    public BigDecimal getSodium() {
        return sodium;
    }

    public void setSodium(BigDecimal sodium) {
        this.sodium = sodium;
    }

    public BigDecimal getCalcium() {
        return calcium;
    }

    public void setCalcium(BigDecimal calcium) {
        this.calcium = calcium;
    }

    public BigDecimal getIron() {
        return iron;
    }

    public void setIron(BigDecimal iron) {
        this.iron = iron;
    }

    public BigDecimal getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(BigDecimal vitaminC) {
        this.vitaminC = vitaminC;
    }

    public BigDecimal getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(BigDecimal cholesterol) {
        this.cholesterol = cholesterol;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}