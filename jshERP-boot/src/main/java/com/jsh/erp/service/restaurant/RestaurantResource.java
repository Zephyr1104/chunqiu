package com.jsh.erp.service.restaurant;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161  2024-08-03 15:26:27
 */
@ResourceInfo(value = "restaurant")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestaurantResource {
}
