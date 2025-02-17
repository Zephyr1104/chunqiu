package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishMealRel;
import com.jsh.erp.datasource.entities.DishMealRelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishMealRelMapper {
    long countByExample(DishMealRelExample example);

    int deleteByExample(DishMealRelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DishMealRel record);

    int insertSelective(DishMealRel record);

    List<DishMealRel> selectByExample(DishMealRelExample example);

    DishMealRel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DishMealRel record, @Param("example") DishMealRelExample example);

    int updateByExample(@Param("record") DishMealRel record, @Param("example") DishMealRelExample example);

    int updateByPrimaryKeySelective(DishMealRel record);

    int updateByPrimaryKey(DishMealRel record);
}