package com.jsh.erp.service.processor;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *  工厂模型
 * @Author: cjl
 * @Date: 2019/3/6 15:10
 */
@ResourceInfo(value = "processor")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessorResource {
}
