package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NutritionalExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<NutritionalExample.Criteria> oredCriteria;

    public NutritionalExample() {
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

    public List<NutritionalExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(NutritionalExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public NutritionalExample.Criteria or() {
        NutritionalExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public NutritionalExample.Criteria createCriteria() {
        NutritionalExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected NutritionalExample.Criteria createCriteriaInternal() {
        NutritionalExample.Criteria criteria = new NutritionalExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<NutritionalExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<NutritionalExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<NutritionalExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new NutritionalExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new NutritionalExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new NutritionalExample.Criterion(condition, value1, value2));
        }

        public NutritionalExample.Criteria andIdIsNull() {
            addCriterion("id is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdIsNull() {
            addCriterion("user_id is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdIsNotNull() {
            addCriterion("user_id is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andHeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdIsNull() {
            addCriterion("material_extend_id is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdIsNotNull() {
            addCriterion("material_extend_id is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdEqualTo(Long value) {
            addCriterion("material_extend_id =", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdNotEqualTo(Long value) {
            addCriterion("material_extend_id <>", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdGreaterThan(Long value) {
            addCriterion("material_extend_id >", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_extend_id >=", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdLessThan(Long value) {
            addCriterion("material_extend_id <", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("material_extend_id <=", value, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdIn(List<Long> values) {
            addCriterion("material_extend_id in", values, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdNotIn(List<Long> values) {
            addCriterion("material_extend_id not in", values, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdBetween(Long value1, Long value2) {
            addCriterion("material_extend_id between", value1, value2, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("material_extend_id not between", value1, value2, "materialExtendId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberIsNull() {
            addCriterion("oper_number is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberIsNotNull() {
            addCriterion("oper_number is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberEqualTo(BigDecimal value) {
            addCriterion("oper_number =", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberNotEqualTo(BigDecimal value) {
            addCriterion("oper_number <>", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberGreaterThan(BigDecimal value) {
            addCriterion("oper_number >", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number >=", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberLessThan(BigDecimal value) {
            addCriterion("oper_number <", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number <=", value, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberIn(List<BigDecimal> values) {
            addCriterion("oper_number in", values, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberNotIn(List<BigDecimal> values) {
            addCriterion("oper_number not in", values, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number between", value1, value2, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andOperNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number not between", value1, value2, "operNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberIsNull() {
            addCriterion("basic_number is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberIsNotNull() {
            addCriterion("basic_number is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberEqualTo(BigDecimal value) {
            addCriterion("basic_number =", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberNotEqualTo(BigDecimal value) {
            addCriterion("basic_number <>", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberGreaterThan(BigDecimal value) {
            addCriterion("basic_number >", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number >=", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberLessThan(BigDecimal value) {
            addCriterion("basic_number <", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number <=", value, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberIn(List<BigDecimal> values) {
            addCriterion("basic_number in", values, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberNotIn(List<BigDecimal> values) {
            addCriterion("basic_number not in", values, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number between", value1, value2, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBasicNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number not between", value1, value2, "basicNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberIsNull() {
            addCriterion("current_number is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberIsNotNull() {
            addCriterion("current_number is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberEqualTo(BigDecimal value) {
            addCriterion("current_number =", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberNotEqualTo(BigDecimal value) {
            addCriterion("current_number <>", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberGreaterThan(BigDecimal value) {
            addCriterion("current_number >", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number >=", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberLessThan(BigDecimal value) {
            addCriterion("current_number <", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number <=", value, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberIn(List<BigDecimal> values) {
            addCriterion("current_number in", values, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberNotIn(List<BigDecimal> values) {
            addCriterion("current_number not in", values, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number between", value1, value2, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCurrentNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number not between", value1, value2, "currentNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberIsNull() {
            addCriterion("another_number is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberIsNotNull() {
            addCriterion("another_number is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberEqualTo(BigDecimal value) {
            addCriterion("another_number =", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberNotEqualTo(BigDecimal value) {
            addCriterion("another_number <>", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberGreaterThan(BigDecimal value) {
            addCriterion("another_number >", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number >=", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberLessThan(BigDecimal value) {
            addCriterion("another_number <", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number <=", value, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberIn(List<BigDecimal> values) {
            addCriterion("another_number in", values, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberNotIn(List<BigDecimal> values) {
            addCriterion("another_number not in", values, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number between", value1, value2, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andAnotherNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number not between", value1, value2, "anotherNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceIsNull() {
            addCriterion("purchase_unit_price is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceIsNotNull() {
            addCriterion("purchase_unit_price is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price =", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <>", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_unit_price >", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price >=", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceLessThan(BigDecimal value) {
            addCriterion("purchase_unit_price <", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <=", value, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price in", values, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price not in", values, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price between", value1, value2, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andPurchaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price not between", value1, value2, "purchaseUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceIsNull() {
            addCriterion("tax_unit_price is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceIsNotNull() {
            addCriterion("tax_unit_price is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price =", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <>", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_unit_price >", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price >=", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceLessThan(BigDecimal value) {
            addCriterion("tax_unit_price <", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <=", value, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price in", values, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price not in", values, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price between", value1, value2, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price not between", value1, value2, "taxUnitPrice");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyIsNull() {
            addCriterion("tax_money is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyIsNotNull() {
            addCriterion("tax_money is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_money =", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_money <>", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_money >", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money >=", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyLessThan(BigDecimal value) {
            addCriterion("tax_money <", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money <=", value, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_money in", values, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_money not in", values, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money between", value1, value2, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money not between", value1, value2, "taxMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyIsNull() {
            addCriterion("tax_last_money is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyIsNotNull() {
            addCriterion("tax_last_money is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_last_money =", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <>", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_last_money >", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money >=", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyLessThan(BigDecimal value) {
            addCriterion("tax_last_money <", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <=", value, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_last_money in", values, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_last_money not in", values, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money between", value1, value2, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTaxLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money not between", value1, value2, "taxLastMoney");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListIsNull() {
            addCriterion("sn_list is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListIsNotNull() {
            addCriterion("sn_list is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListEqualTo(String value) {
            addCriterion("sn_list =", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListNotEqualTo(String value) {
            addCriterion("sn_list <>", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListGreaterThan(String value) {
            addCriterion("sn_list >", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListGreaterThanOrEqualTo(String value) {
            addCriterion("sn_list >=", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListLessThan(String value) {
            addCriterion("sn_list <", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListLessThanOrEqualTo(String value) {
            addCriterion("sn_list <=", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListLike(String value) {
            addCriterion("sn_list like", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListNotLike(String value) {
            addCriterion("sn_list not like", value, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListIn(List<String> values) {
            addCriterion("sn_list in", values, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListNotIn(List<String> values) {
            addCriterion("sn_list not in", values, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListBetween(String value1, String value2) {
            addCriterion("sn_list between", value1, value2, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andSnListNotBetween(String value1, String value2) {
            addCriterion("sn_list not between", value1, value2, "snList");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
            return (NutritionalExample.Criteria) this;
        }

               public NutritionalExample.Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreatenDateIsNotNull() {
            addCriterion("create_date is not null");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (NutritionalExample.Criteria) this;
        }

        public NutritionalExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (NutritionalExample.Criteria) this;
        }
    }

    public static class Criteria extends NutritionalExample.GeneratedCriteria {
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