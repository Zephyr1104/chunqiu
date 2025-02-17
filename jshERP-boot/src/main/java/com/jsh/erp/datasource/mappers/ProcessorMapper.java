package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Processor;
import com.jsh.erp.datasource.entities.ProcessorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessorMapper {
    long countByExample(ProcessorExample example);

    int deleteByExample(ProcessorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Processor record);

    int insertSelective(Processor record);

    List<Processor> selectByExample(ProcessorExample example);

    Processor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Processor record, @Param("example") ProcessorExample example);

    int updateByExample(@Param("record") Processor record, @Param("example") ProcessorExample example);

    int updateByPrimaryKeySelective(Processor record);

    int updateByPrimaryKey(Processor record);
}