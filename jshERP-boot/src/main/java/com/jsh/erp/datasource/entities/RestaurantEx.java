package com.jsh.erp.datasource.entities;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author zzl
 * @date 2024/08/08
 */
@Data
public class RestaurantEx extends Restaurant {
    private BigDecimal initStock;

    private BigDecimal currentStock;

    private BigDecimal lowSafeStock;

    private BigDecimal highSafeStock;

    private String menuModeStr;//周菜谱模式

    private String terminalTypeStr;//终端类型

    private String centralKitchenStr;//配送央厨

    private String headStr;//负责人

    public String getHeadStr() {
        return headStr;
    }

    public void setHeadStr(String headStr) {
        this.headStr = headStr;
    }

    public String getCentralKitchenStr() {
        return centralKitchenStr;
    }

    public void setCentralKitchenStr(String centralKitchenStr) {
        this.centralKitchenStr = centralKitchenStr;
    }

    public String getTerminalTypeStr() {
        return terminalTypeStr;
    }

    public void setTerminalTypeStr(String terminalTypeStr) {
        this.terminalTypeStr = terminalTypeStr;
    }

    public String getMenuModeStr() {
        return menuModeStr;
    }

    public void setMenuModeStr(String menuModeStr) {
        this.menuModeStr = menuModeStr;
    }
}
