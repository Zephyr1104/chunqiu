package com.jsh.erp.datasource.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DishNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DishNameExample() {
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

        public Criteria andNameTypeIsNull() {
            addCriterion("name_type is null");
            return (Criteria) this;
        }

        public Criteria andNameTypeIsNotNull() {
            addCriterion("name_type is not null");
            return (Criteria) this;
        }

        public Criteria andNameTypeEqualTo(String value) {
            addCriterion("name_type =", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotEqualTo(String value) {
            addCriterion("name_type <>", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeGreaterThan(String value) {
            addCriterion("name_type >", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeGreaterThanOrEqualTo(String value) {
            addCriterion("name_type >=", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLessThan(String value) {
            addCriterion("name_type <", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLessThanOrEqualTo(String value) {
            addCriterion("name_type <=", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeLike(String value) {
            addCriterion("name_type like", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotLike(String value) {
            addCriterion("name_type not like", value, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeIn(List<String> values) {
            addCriterion("name_type in", values, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotIn(List<String> values) {
            addCriterion("name_type not in", values, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeBetween(String value1, String value2) {
            addCriterion("name_type between", value1, value2, "nameType");
            return (Criteria) this;
        }

        public Criteria andNameTypeNotBetween(String value1, String value2) {
            addCriterion("name_type not between", value1, value2, "nameType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeIsNull() {
            addCriterion("cooking_type is null");
            return (Criteria) this;
        }

        public Criteria andCookingTypeIsNotNull() {
            addCriterion("cooking_type is not null");
            return (Criteria) this;
        }

        public Criteria andCookingTypeEqualTo(String value) {
            addCriterion("cooking_type =", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeNotEqualTo(String value) {
            addCriterion("cooking_type <>", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeGreaterThan(String value) {
            addCriterion("cooking_type >", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cooking_type >=", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeLessThan(String value) {
            addCriterion("cooking_type <", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeLessThanOrEqualTo(String value) {
            addCriterion("cooking_type <=", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeLike(String value) {
            addCriterion("cooking_type like", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeNotLike(String value) {
            addCriterion("cooking_type not like", value, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeIn(List<String> values) {
            addCriterion("cooking_type in", values, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeNotIn(List<String> values) {
            addCriterion("cooking_type not in", values, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeBetween(String value1, String value2) {
            addCriterion("cooking_type between", value1, value2, "cookingType");
            return (Criteria) this;
        }

        public Criteria andCookingTypeNotBetween(String value1, String value2) {
            addCriterion("cooking_type not between", value1, value2, "cookingType");
            return (Criteria) this;
        }

        public Criteria andMainTypeIsNull() {
            addCriterion("main_type is null");
            return (Criteria) this;
        }

        public Criteria andMainTypeIsNotNull() {
            addCriterion("main_type is not null");
            return (Criteria) this;
        }

        public Criteria andMainTypeEqualTo(String value) {
            addCriterion("main_type =", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeNotEqualTo(String value) {
            addCriterion("main_type <>", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeGreaterThan(String value) {
            addCriterion("main_type >", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeGreaterThanOrEqualTo(String value) {
            addCriterion("main_type >=", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeLessThan(String value) {
            addCriterion("main_type <", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeLessThanOrEqualTo(String value) {
            addCriterion("main_type <=", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeLike(String value) {
            addCriterion("main_type like", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeNotLike(String value) {
            addCriterion("main_type not like", value, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeIn(List<String> values) {
            addCriterion("main_type in", values, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeNotIn(List<String> values) {
            addCriterion("main_type not in", values, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeBetween(String value1, String value2) {
            addCriterion("main_type between", value1, value2, "mainType");
            return (Criteria) this;
        }

        public Criteria andMainTypeNotBetween(String value1, String value2) {
            addCriterion("main_type not between", value1, value2, "mainType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeIsNull() {
            addCriterion("cuisine_type is null");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeIsNotNull() {
            addCriterion("cuisine_type is not null");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeEqualTo(String value) {
            addCriterion("cuisine_type =", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeNotEqualTo(String value) {
            addCriterion("cuisine_type <>", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeGreaterThan(String value) {
            addCriterion("cuisine_type >", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cuisine_type >=", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeLessThan(String value) {
            addCriterion("cuisine_type <", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeLessThanOrEqualTo(String value) {
            addCriterion("cuisine_type <=", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeLike(String value) {
            addCriterion("cuisine_type like", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeNotLike(String value) {
            addCriterion("cuisine_type not like", value, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeIn(List<String> values) {
            addCriterion("cuisine_type in", values, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeNotIn(List<String> values) {
            addCriterion("cuisine_type not in", values, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeBetween(String value1, String value2) {
            addCriterion("cuisine_type between", value1, value2, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andCuisineTypeNotBetween(String value1, String value2) {
            addCriterion("cuisine_type not between", value1, value2, "cuisineType");
            return (Criteria) this;
        }

        public Criteria andColorTypeIsNull() {
            addCriterion("color_type is null");
            return (Criteria) this;
        }

        public Criteria andColorTypeIsNotNull() {
            addCriterion("color_type is not null");
            return (Criteria) this;
        }

        public Criteria andColorTypeEqualTo(String value) {
            addCriterion("color_type =", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotEqualTo(String value) {
            addCriterion("color_type <>", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeGreaterThan(String value) {
            addCriterion("color_type >", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeGreaterThanOrEqualTo(String value) {
            addCriterion("color_type >=", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeLessThan(String value) {
            addCriterion("color_type <", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeLessThanOrEqualTo(String value) {
            addCriterion("color_type <=", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeLike(String value) {
            addCriterion("color_type like", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotLike(String value) {
            addCriterion("color_type not like", value, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeIn(List<String> values) {
            addCriterion("color_type in", values, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotIn(List<String> values) {
            addCriterion("color_type not in", values, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeBetween(String value1, String value2) {
            addCriterion("color_type between", value1, value2, "colorType");
            return (Criteria) this;
        }

        public Criteria andColorTypeNotBetween(String value1, String value2) {
            addCriterion("color_type not between", value1, value2, "colorType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeIsNull() {
            addCriterion("taste_type is null");
            return (Criteria) this;
        }

        public Criteria andTasteTypeIsNotNull() {
            addCriterion("taste_type is not null");
            return (Criteria) this;
        }

        public Criteria andTasteTypeEqualTo(String value) {
            addCriterion("taste_type =", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeNotEqualTo(String value) {
            addCriterion("taste_type <>", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeGreaterThan(String value) {
            addCriterion("taste_type >", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("taste_type >=", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeLessThan(String value) {
            addCriterion("taste_type <", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeLessThanOrEqualTo(String value) {
            addCriterion("taste_type <=", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeLike(String value) {
            addCriterion("taste_type like", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeNotLike(String value) {
            addCriterion("taste_type not like", value, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeIn(List<String> values) {
            addCriterion("taste_type in", values, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeNotIn(List<String> values) {
            addCriterion("taste_type not in", values, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeBetween(String value1, String value2) {
            addCriterion("taste_type between", value1, value2, "tasteType");
            return (Criteria) this;
        }

        public Criteria andTasteTypeNotBetween(String value1, String value2) {
            addCriterion("taste_type not between", value1, value2, "tasteType");
            return (Criteria) this;
        }

        public Criteria andAllergenIsNull() {
            addCriterion("allergen is null");
            return (Criteria) this;
        }

        public Criteria andAllergenIsNotNull() {
            addCriterion("allergen is not null");
            return (Criteria) this;
        }

        public Criteria andAllergenEqualTo(String value) {
            addCriterion("allergen =", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenNotEqualTo(String value) {
            addCriterion("allergen <>", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenGreaterThan(String value) {
            addCriterion("allergen >", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenGreaterThanOrEqualTo(String value) {
            addCriterion("allergen >=", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenLessThan(String value) {
            addCriterion("allergen <", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenLessThanOrEqualTo(String value) {
            addCriterion("allergen <=", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenLike(String value) {
            addCriterion("allergen like", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenNotLike(String value) {
            addCriterion("allergen not like", value, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenIn(List<String> values) {
            addCriterion("allergen in", values, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenNotIn(List<String> values) {
            addCriterion("allergen not in", values, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenBetween(String value1, String value2) {
            addCriterion("allergen between", value1, value2, "allergen");
            return (Criteria) this;
        }

        public Criteria andAllergenNotBetween(String value1, String value2) {
            addCriterion("allergen not between", value1, value2, "allergen");
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