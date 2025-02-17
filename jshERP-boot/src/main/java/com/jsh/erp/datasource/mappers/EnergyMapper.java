package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Energy;
import com.jsh.erp.datasource.entities.EnergyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EnergyMapper {
    long countByExample(EnergyExample example);

    int deleteByExample(EnergyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Energy record);

    int insertSelective(Energy record);

    List<Energy> selectByExample(EnergyExample example);

    Energy selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Energy record, @Param("example") EnergyExample example);

    int updateByExample(@Param("record") Energy record, @Param("example") EnergyExample example);

    int updateByPrimaryKeySelective(Energy record);

    int updateByPrimaryKey(Energy record);
}