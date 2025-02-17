package com.jsh.erp.datasource.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zzl
 * @date 2024/07/08
 */
@Data
public class AgreementPriceEx extends AgreementPrice {
    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;
}
