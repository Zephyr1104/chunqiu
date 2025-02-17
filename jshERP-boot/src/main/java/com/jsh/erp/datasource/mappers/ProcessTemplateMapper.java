package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.ProcessTemplate;
import com.jsh.erp.datasource.entities.ProcessTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessTemplateMapper {
    long countByExample(ProcessTemplateExample example);

    int deleteByExample(ProcessTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProcessTemplate record);

    int insertSelective(ProcessTemplate record);

    List<ProcessTemplate> selectByExample(ProcessTemplateExample example);

    ProcessTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProcessTemplate record, @Param("example") ProcessTemplateExample example);

    int updateByExample(@Param("record") ProcessTemplate record, @Param("example") ProcessTemplateExample example);

    int updateByPrimaryKeySelective(ProcessTemplate record);

    int updateByPrimaryKey(ProcessTemplate record);
}