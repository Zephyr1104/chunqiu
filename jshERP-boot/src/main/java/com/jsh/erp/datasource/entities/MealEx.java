package com.jsh.erp.datasource.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Xiazy
 * @date 2024/04/23
 */
@Data
public class MealEx extends Meal {
    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;
}
