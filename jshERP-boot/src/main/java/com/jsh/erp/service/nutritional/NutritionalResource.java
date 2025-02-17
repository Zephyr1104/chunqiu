package com.jsh.erp.service.nutritional;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161  2024-07-08 15:26:27
 */
@ResourceInfo(value = "nutritional")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NutritionalResource {
}
