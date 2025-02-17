package com.jsh.erp.datasource.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgreementPriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<AgreementPriceExample.Criteria> oredCriteria;

    public AgreementPriceExample() {
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

    public List<AgreementPriceExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(AgreementPriceExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public AgreementPriceExample.Criteria or() {
        AgreementPriceExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public AgreementPriceExample.Criteria createCriteria() {
        AgreementPriceExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected AgreementPriceExample.Criteria createCriteriaInternal() {
        AgreementPriceExample.Criteria criteria = new AgreementPriceExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<AgreementPriceExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<AgreementPriceExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<AgreementPriceExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new AgreementPriceExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new AgreementPriceExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new AgreementPriceExample.Criterion(condition, value1, value2));
        }

        public AgreementPriceExample.Criteria andIdIsNull() {
            addCriterion("id is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdIsNull() {
            addCriterion("user_id is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdIsNotNull() {
            addCriterion("user_id is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andHeaderIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdIsNull() {
            addCriterion("material_extend_id is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdIsNotNull() {
            addCriterion("material_extend_id is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdEqualTo(Long value) {
            addCriterion("material_extend_id =", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdNotEqualTo(Long value) {
            addCriterion("material_extend_id <>", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdGreaterThan(Long value) {
            addCriterion("material_extend_id >", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_extend_id >=", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdLessThan(Long value) {
            addCriterion("material_extend_id <", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdLessThanOrEqualTo(Long value) {
            addCriterion("material_extend_id <=", value, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdIn(List<Long> values) {
            addCriterion("material_extend_id in", values, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdNotIn(List<Long> values) {
            addCriterion("material_extend_id not in", values, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdBetween(Long value1, Long value2) {
            addCriterion("material_extend_id between", value1, value2, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialExtendIdNotBetween(Long value1, Long value2) {
            addCriterion("material_extend_id not between", value1, value2, "materialExtendId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitIsNull() {
            addCriterion("material_unit is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitIsNotNull() {
            addCriterion("material_unit is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitEqualTo(String value) {
            addCriterion("material_unit =", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitNotEqualTo(String value) {
            addCriterion("material_unit <>", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitGreaterThan(String value) {
            addCriterion("material_unit >", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitGreaterThanOrEqualTo(String value) {
            addCriterion("material_unit >=", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitLessThan(String value) {
            addCriterion("material_unit <", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitLessThanOrEqualTo(String value) {
            addCriterion("material_unit <=", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitLike(String value) {
            addCriterion("material_unit like", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitNotLike(String value) {
            addCriterion("material_unit not like", value, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitIn(List<String> values) {
            addCriterion("material_unit in", values, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitNotIn(List<String> values) {
            addCriterion("material_unit not in", values, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitBetween(String value1, String value2) {
            addCriterion("material_unit between", value1, value2, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialUnitNotBetween(String value1, String value2) {
            addCriterion("material_unit not between", value1, value2, "materialUnit");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberIsNull() {
            addCriterion("oper_number is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberIsNotNull() {
            addCriterion("oper_number is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberEqualTo(BigDecimal value) {
            addCriterion("oper_number =", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberNotEqualTo(BigDecimal value) {
            addCriterion("oper_number <>", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberGreaterThan(BigDecimal value) {
            addCriterion("oper_number >", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number >=", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberLessThan(BigDecimal value) {
            addCriterion("oper_number <", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("oper_number <=", value, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberIn(List<BigDecimal> values) {
            addCriterion("oper_number in", values, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberNotIn(List<BigDecimal> values) {
            addCriterion("oper_number not in", values, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number between", value1, value2, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andOperNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("oper_number not between", value1, value2, "operNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberIsNull() {
            addCriterion("basic_number is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberIsNotNull() {
            addCriterion("basic_number is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberEqualTo(BigDecimal value) {
            addCriterion("basic_number =", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberNotEqualTo(BigDecimal value) {
            addCriterion("basic_number <>", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberGreaterThan(BigDecimal value) {
            addCriterion("basic_number >", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number >=", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberLessThan(BigDecimal value) {
            addCriterion("basic_number <", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("basic_number <=", value, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberIn(List<BigDecimal> values) {
            addCriterion("basic_number in", values, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberNotIn(List<BigDecimal> values) {
            addCriterion("basic_number not in", values, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number between", value1, value2, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBasicNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("basic_number not between", value1, value2, "basicNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberIsNull() {
            addCriterion("current_number is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberIsNotNull() {
            addCriterion("current_number is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberEqualTo(BigDecimal value) {
            addCriterion("current_number =", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberNotEqualTo(BigDecimal value) {
            addCriterion("current_number <>", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberGreaterThan(BigDecimal value) {
            addCriterion("current_number >", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number >=", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberLessThan(BigDecimal value) {
            addCriterion("current_number <", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("current_number <=", value, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberIn(List<BigDecimal> values) {
            addCriterion("current_number in", values, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberNotIn(List<BigDecimal> values) {
            addCriterion("current_number not in", values, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number between", value1, value2, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCurrentNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("current_number not between", value1, value2, "currentNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberIsNull() {
            addCriterion("another_number is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberIsNotNull() {
            addCriterion("another_number is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberEqualTo(BigDecimal value) {
            addCriterion("another_number =", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberNotEqualTo(BigDecimal value) {
            addCriterion("another_number <>", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberGreaterThan(BigDecimal value) {
            addCriterion("another_number >", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number >=", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberLessThan(BigDecimal value) {
            addCriterion("another_number <", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("another_number <=", value, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberIn(List<BigDecimal> values) {
            addCriterion("another_number in", values, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberNotIn(List<BigDecimal> values) {
            addCriterion("another_number not in", values, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number between", value1, value2, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andAnotherNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("another_number not between", value1, value2, "anotherNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceIsNull() {
            addCriterion("unit_price is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceIsNotNull() {
            addCriterion("unit_price is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceEqualTo(BigDecimal value) {
            addCriterion("unit_price =", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("unit_price <>", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("unit_price >", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price >=", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceLessThan(BigDecimal value) {
            addCriterion("unit_price <", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("unit_price <=", value, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceIn(List<BigDecimal> values) {
            addCriterion("unit_price in", values, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("unit_price not in", values, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price between", value1, value2, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("unit_price not between", value1, value2, "unitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceIsNull() {
            addCriterion("purchase_unit_price is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceIsNotNull() {
            addCriterion("purchase_unit_price is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price =", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <>", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_unit_price >", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price >=", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceLessThan(BigDecimal value) {
            addCriterion("purchase_unit_price <", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_unit_price <=", value, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price in", values, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_unit_price not in", values, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price between", value1, value2, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andPurchaseUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_unit_price not between", value1, value2, "purchaseUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceIsNull() {
            addCriterion("tax_unit_price is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceIsNotNull() {
            addCriterion("tax_unit_price is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price =", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceNotEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <>", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceGreaterThan(BigDecimal value) {
            addCriterion("tax_unit_price >", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price >=", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceLessThan(BigDecimal value) {
            addCriterion("tax_unit_price <", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_unit_price <=", value, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price in", values, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceNotIn(List<BigDecimal> values) {
            addCriterion("tax_unit_price not in", values, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price between", value1, value2, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxUnitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_unit_price not between", value1, value2, "taxUnitPrice");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateEqualTo(BigDecimal value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateNotEqualTo(BigDecimal value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateGreaterThan(BigDecimal value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateLessThan(BigDecimal value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateIn(List<BigDecimal> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateNotIn(List<BigDecimal> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyIsNull() {
            addCriterion("tax_money is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyIsNotNull() {
            addCriterion("tax_money is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_money =", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_money <>", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_money >", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money >=", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyLessThan(BigDecimal value) {
            addCriterion("tax_money <", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_money <=", value, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_money in", values, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_money not in", values, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money between", value1, value2, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_money not between", value1, value2, "taxMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyIsNull() {
            addCriterion("tax_last_money is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyIsNotNull() {
            addCriterion("tax_last_money is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyEqualTo(BigDecimal value) {
            addCriterion("tax_last_money =", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <>", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyGreaterThan(BigDecimal value) {
            addCriterion("tax_last_money >", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money >=", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyLessThan(BigDecimal value) {
            addCriterion("tax_last_money <", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("tax_last_money <=", value, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyIn(List<BigDecimal> values) {
            addCriterion("tax_last_money in", values, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("tax_last_money not in", values, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money between", value1, value2, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTaxLastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("tax_last_money not between", value1, value2, "taxLastMoney");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeIsNull() {
            addCriterion("material_type is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeIsNotNull() {
            addCriterion("material_type is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeEqualTo(String value) {
            addCriterion("material_type =", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeNotEqualTo(String value) {
            addCriterion("material_type <>", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeGreaterThan(String value) {
            addCriterion("material_type >", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeGreaterThanOrEqualTo(String value) {
            addCriterion("material_type >=", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeLessThan(String value) {
            addCriterion("material_type <", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeLessThanOrEqualTo(String value) {
            addCriterion("material_type <=", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeLike(String value) {
            addCriterion("material_type like", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeNotLike(String value) {
            addCriterion("material_type not like", value, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeIn(List<String> values) {
            addCriterion("material_type in", values, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeNotIn(List<String> values) {
            addCriterion("material_type not in", values, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeBetween(String value1, String value2) {
            addCriterion("material_type between", value1, value2, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andMaterialTypeNotBetween(String value1, String value2) {
            addCriterion("material_type not between", value1, value2, "materialType");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberIsNull() {
            addCriterion("batch_number is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberIsNotNull() {
            addCriterion("batch_number is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberEqualTo(String value) {
            addCriterion("batch_number =", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberNotEqualTo(String value) {
            addCriterion("batch_number <>", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberGreaterThan(String value) {
            addCriterion("batch_number >", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberGreaterThanOrEqualTo(String value) {
            addCriterion("batch_number >=", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberLessThan(String value) {
            addCriterion("batch_number <", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberLessThanOrEqualTo(String value) {
            addCriterion("batch_number <=", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberLike(String value) {
            addCriterion("batch_number like", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberNotLike(String value) {
            addCriterion("batch_number not like", value, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberIn(List<String> values) {
            addCriterion("batch_number in", values, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberNotIn(List<String> values) {
            addCriterion("batch_number not in", values, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberBetween(String value1, String value2) {
            addCriterion("batch_number between", value1, value2, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andBatchNumberNotBetween(String value1, String value2) {
            addCriterion("batch_number not between", value1, value2, "batchNumber");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateIsNull() {
            addCriterion("expiration_date is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateIsNotNull() {
            addCriterion("expiration_date is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateEqualTo(Date value) {
            addCriterion("expiration_date =", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateNotEqualTo(Date value) {
            addCriterion("expiration_date <>", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateGreaterThan(Date value) {
            addCriterion("expiration_date >", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_date >=", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateLessThan(Date value) {
            addCriterion("expiration_date <", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateLessThanOrEqualTo(Date value) {
            addCriterion("expiration_date <=", value, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateIn(List<Date> values) {
            addCriterion("expiration_date in", values, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateNotIn(List<Date> values) {
            addCriterion("expiration_date not in", values, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateBetween(Date value1, Date value2) {
            addCriterion("expiration_date between", value1, value2, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andExpirationDateNotBetween(Date value1, Date value2) {
            addCriterion("expiration_date not between", value1, value2, "expirationDate");
            return (AgreementPriceExample.Criteria) this;
        }

               public AgreementPriceExample.Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreatenDateIsNotNull() {
            addCriterion("create_date is not null");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }

        public AgreementPriceExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (AgreementPriceExample.Criteria) this;
        }
    }

    public static class Criteria extends AgreementPriceExample.GeneratedCriteria {
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