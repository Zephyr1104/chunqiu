package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishName;
import com.jsh.erp.datasource.entities.DishNameExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishNameMapper {
    long countByExample(DishNameExample example);

    int deleteByExample(DishNameExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DishName record);

    int insertSelective(DishName record);

    List<DishName> selectByExample(DishNameExample example);

    DishName selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DishName record, @Param("example") DishNameExample example);

    int updateByExample(@Param("record") DishName record, @Param("example") DishNameExample example);

    int updateByPrimaryKeySelective(DishName record);

    int updateByPrimaryKey(DishName record);
}