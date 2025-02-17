package com.jsh.erp.service.dishName;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value="dishName")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DishNameResource {
}
