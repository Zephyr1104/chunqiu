package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.datasource.entities.BomSlave;
import com.jsh.erp.datasource.entities.BomSlaveEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BomSlaveMapperEx {
    List<BomSlaveEx> selectByCondition(
            @Param("bomMasterId") Integer bomMasterId,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows
    );

    Long countsBySelect(
            @Param("bomMasterId") Integer bomMasterId
    );

    int batchDeleteByIds(
            @Param("ids") String[] ids
    );
}
