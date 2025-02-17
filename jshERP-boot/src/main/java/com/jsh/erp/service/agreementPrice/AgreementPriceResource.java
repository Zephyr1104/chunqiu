package com.jsh.erp.service.agreementPrice;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author zzl qq306469161  2024-07-08 15:26:27
 */
@ResourceInfo(value = "agreementPrice")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AgreementPriceResource {
}
