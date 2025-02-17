package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.BomMasterEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BomMasterMapperEx{
    List<BomMasterEx> selectByCondition(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows
    );

    Long countsSelect(
            @Param("name") String name
    );

    int batchDeleteByIds(
            @Param("ids") String[] ids
    );
}
