package com.jsh.erp.datasource.entities;

import lombok.Data;

@Data
public class BomMasterEx extends BomMaster {
    private String dishName;
    private String processorName;
    private String customerName;
    private String createTimeStr;
    private String updateTimeStr;
}
