package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Driver;
import com.jsh.erp.datasource.entities.DriverExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DriverMapper {
    long countByExample(DriverExample example);

    int deleteByExample(DriverExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Driver record);

    int insertSelective(Driver record);

    List<Driver> selectByExample(DriverExample example);

    Driver selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Driver record, @Param("example") DriverExample example);

    int updateByExample(@Param("record") Driver record, @Param("example") DriverExample example);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
}