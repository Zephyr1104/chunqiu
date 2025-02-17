package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.DishPackage;
import com.jsh.erp.datasource.entities.DishPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishPackageMapper {
    long countByExample(DishPackageExample example);

    int deleteByExample(DishPackageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DishPackage record);

    int insertSelective(DishPackage record);

    List<DishPackage> selectByExample(DishPackageExample example);

    DishPackage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DishPackage record, @Param("example") DishPackageExample example);

    int updateByExample(@Param("record") DishPackage record, @Param("example") DishPackageExample example);

    int updateByPrimaryKeySelective(DishPackage record);

    int updateByPrimaryKey(DishPackage record);
}