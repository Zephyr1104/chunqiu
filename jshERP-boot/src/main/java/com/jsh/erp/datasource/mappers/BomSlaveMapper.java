package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BomSlave;
import com.jsh.erp.datasource.entities.BomSlaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BomSlaveMapper {
    long countByExample(BomSlaveExample example);

    int deleteByExample(BomSlaveExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BomSlave record);

    int insertSelective(BomSlave record);

    List<BomSlave> selectByExample(BomSlaveExample example);

    BomSlave selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BomSlave record, @Param("example") BomSlaveExample example);

    int updateByExample(@Param("record") BomSlave record, @Param("example") BomSlaveExample example);

    int updateByPrimaryKeySelective(BomSlave record);

    int updateByPrimaryKey(BomSlave record);
}