package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishMealRelEx;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DishMealRelMapperEx {

    List<DishMealRelEx> select(
            @Param("dishNameId") Integer dishNameId,
            @Param("diningPrice") Integer diningPrice,
            @Param("mealId") Integer mealId,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows
    );
    Long countSelect(
            @Param("price") Integer price,
            @Param("mealId") Integer mealId,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime
    );

    int batchDeleteByIds(
            @Param("ids") String[] ids
    );

}
