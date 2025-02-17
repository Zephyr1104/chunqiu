package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BomMasterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BomMasterExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andBomCodeIsNull() {
            addCriterion("bom_code is null");
            return (Criteria) this;
        }

        public Criteria andBomCodeIsNotNull() {
            addCriterion("bom_code is not null");
            return (Criteria) this;
        }

        public Criteria andBomCodeEqualTo(String value) {
            addCriterion("bom_code =", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeNotEqualTo(String value) {
            addCriterion("bom_code <>", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeGreaterThan(String value) {
            addCriterion("bom_code >", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bom_code >=", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeLessThan(String value) {
            addCriterion("bom_code <", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeLessThanOrEqualTo(String value) {
            addCriterion("bom_code <=", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeLike(String value) {
            addCriterion("bom_code like", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeNotLike(String value) {
            addCriterion("bom_code not like", value, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeIn(List<String> values) {
            addCriterion("bom_code in", values, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeNotIn(List<String> values) {
            addCriterion("bom_code not in", values, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeBetween(String value1, String value2) {
            addCriterion("bom_code between", value1, value2, "bomCode");
            return (Criteria) this;
        }

        public Criteria andBomCodeNotBetween(String value1, String value2) {
            addCriterion("bom_code not between", value1, value2, "bomCode");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(Long value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(Long value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(Long value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(Long value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(Long value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(Long value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<Long> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<Long> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(Long value1, Long value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(Long value1, Long value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(String value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(String value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(String value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(String value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(String value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(String value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLike(String value) {
            addCriterion("material_id like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotLike(String value) {
            addCriterion("material_id not like", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<String> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<String> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(String value1, String value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(String value1, String value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdIsNull() {
            addCriterion("processor_id is null");
            return (Criteria) this;
        }

        public Criteria andProcessorIdIsNotNull() {
            addCriterion("processor_id is not null");
            return (Criteria) this;
        }

        public Criteria andProcessorIdEqualTo(String value) {
            addCriterion("processor_id =", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdNotEqualTo(String value) {
            addCriterion("processor_id <>", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdGreaterThan(String value) {
            addCriterion("processor_id >", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdGreaterThanOrEqualTo(String value) {
            addCriterion("processor_id >=", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdLessThan(String value) {
            addCriterion("processor_id <", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdLessThanOrEqualTo(String value) {
            addCriterion("processor_id <=", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdLike(String value) {
            addCriterion("processor_id like", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdNotLike(String value) {
            addCriterion("processor_id not like", value, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdIn(List<String> values) {
            addCriterion("processor_id in", values, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdNotIn(List<String> values) {
            addCriterion("processor_id not in", values, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdBetween(String value1, String value2) {
            addCriterion("processor_id between", value1, value2, "processorId");
            return (Criteria) this;
        }

        public Criteria andProcessorIdNotBetween(String value1, String value2) {
            addCriterion("processor_id not between", value1, value2, "processorId");
            return (Criteria) this;
        }

        public Criteria andBomTypeIsNull() {
            addCriterion("bom_type is null");
            return (Criteria) this;
        }

        public Criteria andBomTypeIsNotNull() {
            addCriterion("bom_type is not null");
            return (Criteria) this;
        }

        public Criteria andBomTypeEqualTo(Long value) {
            addCriterion("bom_type =", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotEqualTo(Long value) {
            addCriterion("bom_type <>", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeGreaterThan(Long value) {
            addCriterion("bom_type >", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("bom_type >=", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeLessThan(Long value) {
            addCriterion("bom_type <", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeLessThanOrEqualTo(Long value) {
            addCriterion("bom_type <=", value, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeIn(List<Long> values) {
            addCriterion("bom_type in", values, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotIn(List<Long> values) {
            addCriterion("bom_type not in", values, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeBetween(Long value1, Long value2) {
            addCriterion("bom_type between", value1, value2, "bomType");
            return (Criteria) this;
        }

        public Criteria andBomTypeNotBetween(Long value1, Long value2) {
            addCriterion("bom_type not between", value1, value2, "bomType");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateIsNull() {
            addCriterion("cook_yield_rate is null");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateIsNotNull() {
            addCriterion("cook_yield_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateEqualTo(Long value) {
            addCriterion("cook_yield_rate =", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateNotEqualTo(Long value) {
            addCriterion("cook_yield_rate <>", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateGreaterThan(Long value) {
            addCriterion("cook_yield_rate >", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateGreaterThanOrEqualTo(Long value) {
            addCriterion("cook_yield_rate >=", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateLessThan(Long value) {
            addCriterion("cook_yield_rate <", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateLessThanOrEqualTo(Long value) {
            addCriterion("cook_yield_rate <=", value, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateIn(List<Long> values) {
            addCriterion("cook_yield_rate in", values, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateNotIn(List<Long> values) {
            addCriterion("cook_yield_rate not in", values, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateBetween(Long value1, Long value2) {
            addCriterion("cook_yield_rate between", value1, value2, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCookYieldRateNotBetween(Long value1, Long value2) {
            addCriterion("cook_yield_rate not between", value1, value2, "cookYieldRate");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsIsNull() {
            addCriterion("customer_ids is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsIsNotNull() {
            addCriterion("customer_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsEqualTo(String value) {
            addCriterion("customer_ids =", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsNotEqualTo(String value) {
            addCriterion("customer_ids <>", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsGreaterThan(String value) {
            addCriterion("customer_ids >", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsGreaterThanOrEqualTo(String value) {
            addCriterion("customer_ids >=", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsLessThan(String value) {
            addCriterion("customer_ids <", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsLessThanOrEqualTo(String value) {
            addCriterion("customer_ids <=", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsLike(String value) {
            addCriterion("customer_ids like", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsNotLike(String value) {
            addCriterion("customer_ids not like", value, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsIn(List<String> values) {
            addCriterion("customer_ids in", values, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsNotIn(List<String> values) {
            addCriterion("customer_ids not in", values, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsBetween(String value1, String value2) {
            addCriterion("customer_ids between", value1, value2, "customerIds");
            return (Criteria) this;
        }

        public Criteria andCustomerIdsNotBetween(String value1, String value2) {
            addCriterion("customer_ids not between", value1, value2, "customerIds");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_Flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_Flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_Flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_Flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_Flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_Flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_Flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_Flag like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_Flag not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_Flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_Flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_Flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_Flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}