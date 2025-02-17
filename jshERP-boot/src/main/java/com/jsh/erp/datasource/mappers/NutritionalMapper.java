package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Nutritional;
import com.jsh.erp.datasource.entities.NutritionalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NutritionalMapper {
    long countByExample(NutritionalExample example);

    int deleteByExample(NutritionalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Nutritional record);

    int insertSelective(Nutritional record);

    List<Nutritional> selectByExample(NutritionalExample example);

    Nutritional selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Nutritional record, @Param("example") NutritionalExample example);

    int updateByExample(@Param("record") Nutritional record, @Param("example") NutritionalExample example);

    int updateByPrimaryKeySelective(Nutritional record);

    int updateByPrimaryKey(Nutritional record);
}