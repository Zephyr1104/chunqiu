package com.jsh.erp.datasource.mappers;


import com.jsh.erp.datasource.entities.FoodCategory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author Xiazy
 */
public interface FoodCategoryMapperEx {

    List<FoodCategory> selectByConditionFoodCat(
            @Param("name") String name,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByFoodCat(
            @Param("name") String name,
            @Param("remark") String remark);

    int batchDeleteFoodCategoryByIds(
            @Param("updateTime") Date date,
            @Param("ids") String[] idArray);
}
