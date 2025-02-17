package com.jsh.erp.datasource.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zzl
 * @date 2024/08/08
 */
@Data
public class InformationEx extends Information {

    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;

    private String kitchenTypeStr;//央厨类型

    private String recipeTerminalStr;//终端模式

    private String packagingLineStr;//包装线

    private String headStr;//负责人

    public String getHeadStr() {
        return headStr;
    }

    public void setHeadStr(String headStr) {
        this.headStr = headStr;
    }

    public String getPackagingLineStr() {
        return packagingLineStr;
    }

    public void setPackagingLineStr(String packagingLineStr) {
        this.packagingLineStr = packagingLineStr;
    }

    public String getRecipeTerminalStr() {
        return recipeTerminalStr;
    }

    public void setRecipeTerminalStr(String recipeTerminalStr) {
        this.recipeTerminalStr = recipeTerminalStr;
    }

    public String getKitchenTypeStr() {
        return kitchenTypeStr;
    }

    public void setKitchenTypeStr(String kitchenTypeStr) {
        this.kitchenTypeStr = kitchenTypeStr;
    }
}
