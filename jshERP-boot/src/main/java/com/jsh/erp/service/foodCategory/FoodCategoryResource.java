package com.jsh.erp.service.foodCategory;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author Xiazy
 */
@ResourceInfo("foodCategory")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FoodCategoryResource {
}
