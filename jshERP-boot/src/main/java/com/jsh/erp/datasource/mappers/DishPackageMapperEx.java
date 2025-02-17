package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishPackageEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishPackageMapperEx {

    List<DishPackageEx> selectByConditionDishPackage(
            @Param("name") String name,
            @Param("mealType") Integer mealType,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDishPackage(
            @Param("name") String name,
            @Param("mealType") Integer mealType);

    int batchDeleteDishPackageByIds(
            @Param("ids") String[] ids);

}
