package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ProductionPlan;
import com.jsh.erp.datasource.entities.ProductionPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionPlanMapper {
    long countByExample(ProductionPlanExample example);

    int deleteByExample(ProductionPlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductionPlan record);

    int insertSelective(ProductionPlan record);

    List<ProductionPlan> selectByExample(ProductionPlanExample example);

    ProductionPlan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductionPlan record, @Param("example") ProductionPlanExample example);

    int updateByExample(@Param("record") ProductionPlan record, @Param("example") ProductionPlanExample example);

    int updateByPrimaryKeySelective(ProductionPlan record);

    int updateByPrimaryKey(ProductionPlan record);
}