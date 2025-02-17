package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.FoodCategory;
import com.jsh.erp.datasource.entities.FoodCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodCategoryMapper {
    long countByExample(FoodCategoryExample example);

    int deleteByExample(FoodCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FoodCategory record);

    int insertSelective(FoodCategory record);

    List<FoodCategory> selectByExample(FoodCategoryExample example);

    FoodCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FoodCategory record, @Param("example") FoodCategoryExample example);

    int updateByExample(@Param("record") FoodCategory record, @Param("example") FoodCategoryExample example);

    int updateByPrimaryKeySelective(FoodCategory record);

    int updateByPrimaryKey(FoodCategory record);
}