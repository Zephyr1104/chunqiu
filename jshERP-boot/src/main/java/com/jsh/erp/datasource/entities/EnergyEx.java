package com.jsh.erp.datasource.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zzl
 * @date 2024/08/23
 */
@Data
public class EnergyEx extends Meal {
    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;
}
