package com.jsh.erp.datasource.entities;

import lombok.Data;

@Data
public class BomSlaveEx extends BomSlave {
    private String materialName;
    private String bomMasterName;
    private String createTimeStr;
    private String updateTimeStr;
}
