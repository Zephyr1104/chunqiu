package com.jsh.erp.service.dishMealRel;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value="dishMealRel")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DishMealRelResource {
}
