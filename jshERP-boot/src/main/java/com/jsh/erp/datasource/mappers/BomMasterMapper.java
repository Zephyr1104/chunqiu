package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.datasource.entities.BomMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BomMasterMapper {
    long countByExample(BomMasterExample example);

    int deleteByExample(BomMasterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BomMaster record);

    int insertSelective(BomMaster record);

    List<BomMaster> selectByExample(BomMasterExample example);

    BomMaster selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BomMaster record, @Param("example") BomMasterExample example);

    int updateByExample(@Param("record") BomMaster record, @Param("example") BomMasterExample example);

    int updateByPrimaryKeySelective(BomMaster record);

    int updateByPrimaryKey(BomMaster record);
}