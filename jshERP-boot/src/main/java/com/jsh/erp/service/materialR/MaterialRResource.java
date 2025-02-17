package com.jsh.erp.service.materialR;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161 2024-10-18 15:26:27
 */
@ResourceInfo(value = "materialR")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaterialRResource {
}
