package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishGroupMapperEx {

    List<DishGroup> selectByConditionDishGroup(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows
    );
    Long countsByDishGroup(
            @Param("name") String name
    );

    int batchDeleteDishGroupByIds(
            @Param("ids") String[] ids
    );

}
