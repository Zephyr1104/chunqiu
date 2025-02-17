package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Information;
import com.jsh.erp.datasource.entities.InformationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InformationMapper {
    long countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByExample(InformationExample example);

    Information selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
}