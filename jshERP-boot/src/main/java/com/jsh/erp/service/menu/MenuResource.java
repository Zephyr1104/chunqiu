package com.jsh.erp.service.menu;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "menu")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuResource {
}
