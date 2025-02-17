package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.AccountHead;
import com.jsh.erp.datasource.entities.AccountHeadExample;
import com.jsh.erp.datasource.entities.MaterialR;
import com.jsh.erp.datasource.entities.MaterialREx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaterialRMapper {
    long countByExample(MaterialREx example);

    int deleteByExample(MaterialREx example);

    int deleteByPrimaryKey(Long id);

    int insert(MaterialR record);

    int insertSelective(MaterialR record);

    List<MaterialR> selectByExample(MaterialREx example);

    MaterialR selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MaterialR record, @Param("example") MaterialREx example);

    int updateByExample(@Param("record") MaterialR record, @Param("example") MaterialREx example);

    int updateByPrimaryKeySelective(MaterialR record);

    int updateByPrimaryKey(MaterialR record);
}