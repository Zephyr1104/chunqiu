package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishGroup;
import com.jsh.erp.datasource.entities.DishGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishGroupMapper {
    long countByExample(DishGroupExample example);

    int deleteByExample(DishGroupExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DishGroup record);

    int insertSelective(DishGroup record);

    List<DishGroup> selectByExample(DishGroupExample example);

    DishGroup selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DishGroup record, @Param("example") DishGroupExample example);

    int updateByExample(@Param("record") DishGroup record, @Param("example") DishGroupExample example);

    int updateByPrimaryKeySelective(DishGroup record);

    int updateByPrimaryKey(DishGroup record);
}