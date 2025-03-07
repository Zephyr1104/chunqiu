package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Meal;
import com.jsh.erp.datasource.entities.MealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MealMapper {
    long countByExample(MealExample example);

    int deleteByExample(MealExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Meal record);

    int insertSelective(Meal record);

    List<Meal> selectByExample(MealExample example);

    Meal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByExample(@Param("record") Meal record, @Param("example") MealExample example);

    int updateByPrimaryKeySelective(Meal record);

    int updateByPrimaryKey(Meal record);
}