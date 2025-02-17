package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishName;
import com.jsh.erp.datasource.entities.DishNameEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishNameMapperEx {

    List<DishNameEx> selectByConditionDishName(
            @Param("name") String name,
            @Param("allergen") String allergen,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDishName(
            @Param("name") String name,
            @Param("allergen") String allergen);

    int batchDeleteDishNameByIds(
            @Param("ids") String[] ids);
}
