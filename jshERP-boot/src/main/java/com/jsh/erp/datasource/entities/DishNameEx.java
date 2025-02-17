package com.jsh.erp.datasource.entities;

import lombok.Data;

@Data
public class DishNameEx extends DishName {
    private String creatorName;
    
    private String nameTypeName;
}
