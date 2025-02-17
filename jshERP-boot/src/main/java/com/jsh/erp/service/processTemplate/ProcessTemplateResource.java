package com.jsh.erp.service.processTemplate;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author Xiazy 2024年4月29日15:35:37
 */
@ResourceInfo(value = "processTemplate")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessTemplateResource {
}
