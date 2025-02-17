package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<InformationExample.Criteria> oredCriteria;

    public InformationExample() {
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

    public List<InformationExample.Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(InformationExample.Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public InformationExample.Criteria or() {
        InformationExample.Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public InformationExample.Criteria createCriteria() {
        InformationExample.Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected InformationExample.Criteria createCriteriaInternal() {
        InformationExample.Criteria criteria = new InformationExample.Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<InformationExample.Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<InformationExample.Criterion> getAllCriteria() {
            return criteria;
        }

        public List<InformationExample.Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new InformationExample.Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new InformationExample.Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new InformationExample.Criterion(condition, value1, value2));
        }

        public InformationExample.Criteria andIdIsNull() {
            addCriterion("id is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameIsNull() {
            addCriterion("name is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentEqualTo(Long value) {
            addCriterion("department =", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentNotEqualTo(Long value) {
            addCriterion("department <>", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentGreaterThan(Long value) {
            addCriterion("department >", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentGreaterThanOrEqualTo(Long value) {
            addCriterion("department >=", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentLessThan(Long value) {
            addCriterion("department <", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentLessThanOrEqualTo(Long value) {
            addCriterion("department <=", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentLike(Long value) {
            addCriterion("department like", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentNotLike(Long value) {
            addCriterion("department not like", value, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentIn(List<Long> values) {
            addCriterion("department in", values, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentNotIn(List<Long> values) {
            addCriterion("department not in", values, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentBetween(Long value1, Long value2) {
            addCriterion("department between", value1, value2, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDepartmentNotBetween(Long value1, Long value2) {
            addCriterion("department not between", value1, value2, "department");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterIsNull() {
            addCriterion("profit_center is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterIsNotNull() {
            addCriterion("profit_center is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterEqualTo(String value) {
            addCriterion("profit_center =", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterNotEqualTo(String value) {
            addCriterion("profit_center <>", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterGreaterThan(String value) {
            addCriterion("profit_center >", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterGreaterThanOrEqualTo(String value) {
            addCriterion("profit_center >=", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterLessThan(String value) {
            addCriterion("profit_center <", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterLessThanOrEqualTo(String value) {
            addCriterion("profit_center <=", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterLike(String value) {
            addCriterion("profit_center like", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterNotLike(String value) {
            addCriterion("profit_center not like", value, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterIn(List<String> values) {
            addCriterion("profit_center in", values, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterNotIn(List<String> values) {
            addCriterion("profit_center not in", values, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterBetween(String value1, String value2) {
            addCriterion("profit_center between", value1, value2, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andProfitCenterNotBetween(String value1, String value2) {
            addCriterion("profit_center not between", value1, value2, "profitCenter");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeIsNull() {
            addCriterion("kitchen_type is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeIsNotNull() {
            addCriterion("kitchen_type is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeEqualTo(Long value) {
            addCriterion("kitchen_type =", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeNotEqualTo(Long value) {
            addCriterion("kitchen_type <>", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeGreaterThan(Long value) {
            addCriterion("kitchen_type >", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("kitchen_type >=", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeLessThan(Long value) {
            addCriterion("kitchen_type <", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeLessThanOrEqualTo(Long value) {
            addCriterion("kitchen_type <=", value, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeIn(List<Long> values) {
            addCriterion("kitchen_type in", values, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeNotIn(List<Long> values) {
            addCriterion("kitchen_type not in", values, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeBetween(Long value1, Long value2) {
            addCriterion("kitchen_type between", value1, value2, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andKitchenTypeNotBetween(Long value1, Long value2) {
            addCriterion("kitchen_type not between", value1, value2, "kitchenType");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentIsNull() {
            addCriterion("planning_department is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentIsNotNull() {
            addCriterion("planning_department is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentEqualTo(Long value) {
            addCriterion("planning_department =", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentNotEqualTo(Long value) {
            addCriterion("planning_department <>", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentGreaterThan(Long value) {
            addCriterion("planning_department >", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentGreaterThanOrEqualTo(Long value) {
            addCriterion("planning_department >=", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentLessThan(Long value) {
            addCriterion("planning_department <", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentLessThanOrEqualTo(Long value) {
            addCriterion("planning_department <=", value, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentIn(List<Long> values) {
            addCriterion("planning_department in", values, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentNotIn(List<Long> values) {
            addCriterion("planning_department not in", values, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentBetween(Long value1, Long value2) {
            addCriterion("planning_department between", value1, value2, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPlanningDepartmentNotBetween(Long value1, Long value2) {
            addCriterion("planning_department not between", value1, value2, "planningDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentIsNull() {
            addCriterion("up_department is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentIsNotNull() {
            addCriterion("up_department is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentEqualTo(Long value) {
            addCriterion("up_department =", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentNotEqualTo(Long value) {
            addCriterion("up_department <>", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentGreaterThan(Long value) {
            addCriterion("up_department >", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentGreaterThanOrEqualTo(Long value) {
            addCriterion("up_department >=", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentLessThan(Long value) {
            addCriterion("up_department <", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentLessThanOrEqualTo(Long value) {
            addCriterion("up_department <=", value, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentIn(List<Long> values) {
            addCriterion("up_department in", values, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentNotIn(List<Long> values) {
            addCriterion("up_department not in", values, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentBetween(Long value1, Long value2) {
            addCriterion("up_department between", value1, value2, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUpDepartmentNotBetween(Long value1, Long value2) {
            addCriterion("up_department not between", value1, value2, "upDepartment");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalIsNull() {
            addCriterion("recipe_terminal is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalIsNotNull() {
            addCriterion("recipe_terminal is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalEqualTo(Long value) {
            addCriterion("recipe_terminal =", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalNotEqualTo(Long value) {
            addCriterion("recipe_terminal <>", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalGreaterThan(Long value) {
            addCriterion("recipe_terminal >", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalGreaterThanOrEqualTo(Long value) {
            addCriterion("recipe_terminal >=", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalLessThan(Long value) {
            addCriterion("recipe_terminal <", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalLessThanOrEqualTo(Long value) {
            addCriterion("recipe_terminal <=", value, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalIn(List<Long> values) {
            addCriterion("recipe_terminal in", values, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalNotIn(List<Long> values) {
            addCriterion("recipe_terminal not in", values, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalBetween(Long value1, Long value2) {
            addCriterion("recipe_terminal between", value1, value2, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andRecipeTerminalNotBetween(Long value1, Long value2) {
            addCriterion("recipe_terminal not between", value1, value2, "recipeTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalIsNull() {
            addCriterion("cold_terminal is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalIsNotNull() {
            addCriterion("cold_terminal is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalEqualTo(Long value) {
            addCriterion("cold_terminal =", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalNotEqualTo(Long value) {
            addCriterion("cold_terminal <>", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalGreaterThan(Long value) {
            addCriterion("cold_terminal >", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalGreaterThanOrEqualTo(Long value) {
            addCriterion("cold_terminal >=", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalLessThan(Long value) {
            addCriterion("cold_terminal <", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalLessThanOrEqualTo(Long value) {
            addCriterion("cold_terminal <=", value, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalIn(List<Long> values) {
            addCriterion("cold_terminal in", values, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalNotIn(List<Long> values) {
            addCriterion("cold_terminal not in", values, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalBetween(Long value1, Long value2) {
            addCriterion("cold_terminal between", value1, value2, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andColdTerminalNotBetween(Long value1, Long value2) {
            addCriterion("cold_terminal not between", value1, value2, "coldTerminal");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceIsNull() {
            addCriterion("bucket_source is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceIsNotNull() {
            addCriterion("bucket_source is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceEqualTo(Long value) {
            addCriterion("bucket_source =", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceNotEqualTo(Long value) {
            addCriterion("bucket_source <>", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceGreaterThan(Long value) {
            addCriterion("bucket_source >", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceGreaterThanOrEqualTo(Long value) {
            addCriterion("bucket_source >=", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceLessThan(Long value) {
            addCriterion("bucket_source <", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceLessThanOrEqualTo(Long value) {
            addCriterion("bucket_source <=", value, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceIn(List<Long> values) {
            addCriterion("bucket_source in", values, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceNotIn(List<Long> values) {
            addCriterion("bucket_source not in", values, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceBetween(Long value1, Long value2) {
            addCriterion("bucket_source between", value1, value2, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andBucketSourceNotBetween(Long value1, Long value2) {
            addCriterion("bucket_source not between", value1, value2, "bucketSource");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadIsNull() {
            addCriterion("head is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadIsNotNull() {
            addCriterion("head is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadEqualTo(Long value) {
            addCriterion("head =", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadNotEqualTo(Long value) {
            addCriterion("head <>", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadGreaterThan(Long value) {
            addCriterion("head >", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadGreaterThanOrEqualTo(Long value) {
            addCriterion("head >=", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadLessThan(Long value) {
            addCriterion("head <", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadLessThanOrEqualTo(Long value) {
            addCriterion("head <=", value, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadIn(List<Long> values) {
            addCriterion("head in", values, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadNotIn(List<Long> values) {
            addCriterion("head not in", values, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadBetween(Long value1, Long value2) {
            addCriterion("head between", value1, value2, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andHeadNotBetween(Long value1, Long value2) {
            addCriterion("head not between", value1, value2, "head");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersIsNull() {
            addCriterion("customers is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersIsNotNull() {
            addCriterion("customers is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersEqualTo(Long value) {
            addCriterion("customers =", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersNotEqualTo(Long value) {
            addCriterion("customers <>", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersGreaterThan(Long value) {
            addCriterion("customers >", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersGreaterThanOrEqualTo(Long value) {
            addCriterion("customers >=", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersLessThan(Long value) {
            addCriterion("customers <", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersLessThanOrEqualTo(Long value) {
            addCriterion("customers <=", value, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersIn(List<Long> values) {
            addCriterion("customers in", values, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersNotIn(List<Long> values) {
            addCriterion("customers not in", values, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersBetween(Long value1, Long value2) {
            addCriterion("customers between", value1, value2, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCustomersNotBetween(Long value1, Long value2) {
            addCriterion("customers not between", value1, value2, "customers");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrEqualTo(Long value) {
            addCriterion("addr =", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrNotEqualTo(Long value) {
            addCriterion("addr <>", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrGreaterThan(Long value) {
            addCriterion("addr >", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrGreaterThanOrEqualTo(Long value) {
            addCriterion("addr >=", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrLessThan(Long value) {
            addCriterion("addr <", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrLessThanOrEqualTo(Long value) {
            addCriterion("addr <=", value, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrIn(List<Long> values) {
            addCriterion("addr in", values, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrNotIn(List<Long> values) {
            addCriterion("addr not in", values, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrBetween(Long value1, Long value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andAddrNotBetween(Long value1, Long value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineIsNull() {
            addCriterion("packaging_line is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineIsNotNull() {
            addCriterion("packaging_line is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineEqualTo(Long value) {
            addCriterion("packaging_line =", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineNotEqualTo(Long value) {
            addCriterion("packaging_line <>", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineGreaterThan(Long value) {
            addCriterion("packaging_line >", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineGreaterThanOrEqualTo(Long value) {
            addCriterion("packaging_line >=", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineLessThan(Long value) {
            addCriterion("packaging_line <", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineLessThanOrEqualTo(Long value) {
            addCriterion("packaging_line <=", value, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineIn(List<Long> values) {
            addCriterion("packaging_line in", values, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineNotIn(List<Long> values) {
            addCriterion("packaging_line not in", values, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineBetween(Long value1, Long value2) {
            addCriterion("packaging_line between", value1, value2, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andPackagingLineNotBetween(Long value1, Long value2) {
            addCriterion("packaging_line not between", value1, value2, "packagingLine");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledLike(Boolean value) {
            addCriterion("enabled like", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledNotLike(Boolean value) {
            addCriterion("enabled not like", value, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultLike(Boolean value) {
            addCriterion("is_default like", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultNotLike(Boolean value) {
            addCriterion("is_default not like", value, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (InformationExample.Criteria) this;
        }


        public InformationExample.Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdEqualTo(Long value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdNotEqualTo(Long value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdGreaterThan(Long value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdGreaterThanOrEqualTo(Long value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdLessThan(Long value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdLessThanOrEqualTo(Long value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdIn(List<Long> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdNotIn(List<Long> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdBetween(Long value1, Long value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andTenantIdNotBetween(Long value1, Long value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagLessThan(String value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagLike(String value) {
            addCriterion("delete_flag like", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagNotLike(String value) {
            addCriterion("delete_flag not like", value, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreatenDateIsNotNull() {
            addCriterion("create_date is not null");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (InformationExample.Criteria) this;
        }

        public InformationExample.Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (InformationExample.Criteria) this;
        }
    }

    public static class Criteria extends InformationExample.GeneratedCriteria {
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