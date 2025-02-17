package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Energy;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface EnergyMapperEx {

    List<Energy> selectByConditionEnergy(
            @Param("category") String category,
            @Param("orgNo") String orgNo,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByEnergy(
            @Param("category") String category,
            @Param("orgNo") String orgNo);
    int batchDeleteEnergyByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
