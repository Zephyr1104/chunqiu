package com.jsh.erp.service.energy;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161 2024-08-7 15:26:27
 */
@ResourceInfo(value = "energy")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnergyResource {
}
