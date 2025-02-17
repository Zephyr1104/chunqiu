package com.jsh.erp.datasource.entities;

import lombok.Data;

@Data
public class DishMealRelEx extends DishMealRel {
    private String diningDateStr;
    private String mealName;
    private String dishName;
    private String weekDay;
    private String createTimeStr;
}
