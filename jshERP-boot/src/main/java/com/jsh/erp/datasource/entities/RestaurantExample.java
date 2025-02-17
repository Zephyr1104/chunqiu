package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RestaurantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<RestaurantExample.Criteria> oredCriteria;

    public RestaurantExample() {
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

    public List<RestaurantExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(RestaurantExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public RestaurantExample.Criteria or() {
        RestaurantExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public RestaurantExample.Criteria createCriteria() {
        RestaurantExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected RestaurantExample.Criteria createCriteriaInternal() {
        RestaurantExample.Criteria criteria = new RestaurantExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<RestaurantExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<RestaurantExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<RestaurantExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new RestaurantExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new RestaurantExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new RestaurantExample.Criterion(condition, value1, value2));
        }

        public RestaurantExample.Criteria andIdIsNull() {
            addCriterion("id is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameIsNull() {
            addCriterion("name is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdIsNull() {
            addCriterion("material_extend_id is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdIsNotNull() {
            addCriterion("material_extend_id is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdEqualTo(Long value) {
            addCriterion("material_extend_id =", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdNotEqualTo(Long value) {
            addCriterion("material_extend_id <>", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdGreaterThan(Long value) {
            addCriterion("material_extend_id >", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_extend_id >=", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdLessThan(Long value) {
            addCriterion("material_extend_id <", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("material_extend_id <=", value, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdIn(List<Long> values) {
            addCriterion("material_extend_id in", values, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdNotIn(List<Long> values) {
            addCriterion("material_extend_id not in", values, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdBetween(Long value1, Long value2) {
            addCriterion("material_extend_id between", value1, value2, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("material_extend_id not between", value1, value2, "materialExtendId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuIsNull() {
            addCriterion("sku is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuIsNotNull() {
            addCriterion("sku is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuEqualTo(String value) {
            addCriterion("sku =", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuNotEqualTo(String value) {
            addCriterion("sku <>", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuGreaterThan(String value) {
            addCriterion("sku >", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuGreaterThanOrEqualTo(String value) {
            addCriterion("sku >=", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuLessThan(String value) {
            addCriterion("sku <", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuLessThanOrEqualTo(String value) {
            addCriterion("sku <=", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuLike(String value) {
            addCriterion("sku like", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuNotLike(String value) {
            addCriterion("sku not like", value, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuIn(List<String> values) {
            addCriterion("sku in", values, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuNotIn(List<String> values) {
            addCriterion("sku not in", values, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuBetween(String value1, String value2) {
            addCriterion("sku between", value1, value2, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSkuNotBetween(String value1, String value2) {
            addCriterion("sku not between", value1, value2, "sku");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberIsNull() {
            addCriterion("oper_number is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberIsNotNull() {
            addCriterion("oper_number is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberEqualTo(BigDecimal value) {
            addCriterion("oper_number =", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberNotEqualTo(BigDecimal value) {
            addCriterion("oper_number <>", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberGreaterThan(BigDecimal value) {
            addCriterion("oper_number >", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number >=", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberLessThan(BigDecimal value) {
            addCriterion("oper_number <", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number <=", value, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberIn(List<BigDecimal> values) {
            addCriterion("oper_number in", values, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberNotIn(List<BigDecimal> values) {
            addCriterion("oper_number not in", values, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number between", value1, value2, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andOperNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number not between", value1, value2, "operNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberIsNull() {
            addCriterion("basic_number is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberIsNotNull() {
            addCriterion("basic_number is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberEqualTo(BigDecimal value) {
            addCriterion("basic_number =", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberNotEqualTo(BigDecimal value) {
            addCriterion("basic_number <>", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberGreaterThan(BigDecimal value) {
            addCriterion("basic_number >", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number >=", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberLessThan(BigDecimal value) {
            addCriterion("basic_number <", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number <=", value, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberIn(List<BigDecimal> values) {
            addCriterion("basic_number in", values, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberNotIn(List<BigDecimal> values) {
            addCriterion("basic_number not in", values, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number between", value1, value2, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBasicNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number not between", value1, value2, "basicNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberIsNull() {
            addCriterion("current_number is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberIsNotNull() {
            addCriterion("current_number is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberEqualTo(BigDecimal value) {
            addCriterion("current_number =", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberNotEqualTo(BigDecimal value) {
            addCriterion("current_number <>", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberGreaterThan(BigDecimal value) {
            addCriterion("current_number >", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number >=", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberLessThan(BigDecimal value) {
            addCriterion("current_number <", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number <=", value, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberIn(List<BigDecimal> values) {
            addCriterion("current_number in", values, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberNotIn(List<BigDecimal> values) {
            addCriterion("current_number not in", values, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number between", value1, value2, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCurrentNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number not between", value1, value2, "currentNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberIsNull() {
            addCriterion("another_number is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberIsNotNull() {
            addCriterion("another_number is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberEqualTo(BigDecimal value) {
            addCriterion("another_number =", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberNotEqualTo(BigDecimal value) {
            addCriterion("another_number <>", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberGreaterThan(BigDecimal value) {
            addCriterion("another_number >", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number >=", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberLessThan(BigDecimal value) {
            addCriterion("another_number <", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number <=", value, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberIn(List<BigDecimal> values) {
            addCriterion("another_number in", values, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberNotIn(List<BigDecimal> values) {
            addCriterion("another_number not in", values, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number between", value1, value2, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andAnotherNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number not between", value1, value2, "anotherNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceIsNull() {
            addCriterion("purchase_unit_price is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceIsNotNull() {
            addCriterion("purchase_unit_price is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price =", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <>", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_unit_price >", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price >=", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceLessThan(BigDecimal value) {
            addCriterion("purchase_unit_price <", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <=", value, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price in", values, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price not in", values, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price between", value1, value2, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andPurchaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price not between", value1, value2, "purchaseUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceIsNull() {
            addCriterion("tax_unit_price is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceIsNotNull() {
            addCriterion("tax_unit_price is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price =", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <>", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_unit_price >", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price >=", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceLessThan(BigDecimal value) {
            addCriterion("tax_unit_price <", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <=", value, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price in", values, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price not in", values, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price between", value1, value2, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price not between", value1, value2, "taxUnitPrice");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyIsNull() {
            addCriterion("tax_money is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyIsNotNull() {
            addCriterion("tax_money is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_money =", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_money <>", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_money >", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money >=", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyLessThan(BigDecimal value) {
            addCriterion("tax_money <", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money <=", value, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_money in", values, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_money not in", values, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money between", value1, value2, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money not between", value1, value2, "taxMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyIsNull() {
            addCriterion("tax_last_money is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyIsNotNull() {
            addCriterion("tax_last_money is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_last_money =", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <>", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_last_money >", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money >=", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyLessThan(BigDecimal value) {
            addCriterion("tax_last_money <", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <=", value, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_last_money in", values, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_last_money not in", values, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money between", value1, value2, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTaxLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money not between", value1, value2, "taxLastMoney");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListIsNull() {
            addCriterion("sn_list is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListIsNotNull() {
            addCriterion("sn_list is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListEqualTo(String value) {
            addCriterion("sn_list =", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListNotEqualTo(String value) {
            addCriterion("sn_list <>", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListGreaterThan(String value) {
            addCriterion("sn_list >", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListGreaterThanOrEqualTo(String value) {
            addCriterion("sn_list >=", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListLessThan(String value) {
            addCriterion("sn_list <", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListLessThanOrEqualTo(String value) {
            addCriterion("sn_list <=", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListLike(String value) {
            addCriterion("sn_list like", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListNotLike(String value) {
            addCriterion("sn_list not like", value, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListIn(List<String> values) {
            addCriterion("sn_list in", values, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListNotIn(List<String> values) {
            addCriterion("sn_list not in", values, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListBetween(String value1, String value2) {
            addCriterion("sn_list between", value1, value2, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andSnListNotBetween(String value1, String value2) {
            addCriterion("sn_list not between", value1, value2, "snList");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
            return (RestaurantExample.Criteria) this;
        }

               public RestaurantExample.Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreatenDateIsNotNull() {
            addCriterion("create_date is not null");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (RestaurantExample.Criteria) this;
        }

        public RestaurantExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (RestaurantExample.Criteria) this;
        }
    }

    public static class Criteria extends RestaurantExample.GeneratedCriteria {
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