package com.jsh.erp.service.bomMaster;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value="bomMaster")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BomMasterResource {
}
