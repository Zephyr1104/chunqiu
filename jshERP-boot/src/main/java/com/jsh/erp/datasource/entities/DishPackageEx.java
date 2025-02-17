package com.jsh.erp.datasource.entities;

import lombok.Data;

/**
 * @author Zephyr
 */
@Data
public class DishPackageEx extends DishPackage{

    private String mealName;

    private String dishDetailStr;

    private String createTimeStr;

    private String updateTimeStr;

}
