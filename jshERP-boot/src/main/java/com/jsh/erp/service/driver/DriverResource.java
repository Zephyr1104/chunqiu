package com.jsh.erp.service.driver;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161  2024-8-9 15:26:27
 */
@ResourceInfo(value = "driver")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DriverResource {
}
