package com.jsh.erp.datasource.entities;

import java.util.Date;

public class DishMealRel {
    private Long id;

    private Long diningPrice;

    private Date diningDate;

    private Long mealId;

    private String dishNameId;

    private Date createTime;

    private Long tenantId;

    private String deleteFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDiningPrice() {
        return diningPrice;
    }

    public void setDiningPrice(Long diningPrice) {
        this.diningPrice = diningPrice;
    }

    public Date getDiningDate() {
        return diningDate;
    }

    public void setDiningDate(Date diningDate) {
        this.diningDate = diningDate;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public String getDishNameId() {
        return dishNameId;
    }

    public void setDishNameId(String dishNameId) {
        this.dishNameId = dishNameId == null ? null : dishNameId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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