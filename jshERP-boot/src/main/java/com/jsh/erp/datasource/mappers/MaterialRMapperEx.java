package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MaterialR;
import com.jsh.erp.datasource.entities.MaterialRVo4ListEx;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface MaterialRMapperEx {

    List<MaterialRVo4ListEx> selectByConditionMaterialR(
            @Param("type") String type,
            @Param("creatorArray") String[] creatorArray,
            @Param("qualityNo") String qualityNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("organId") Long organId,
            @Param("creator") Long creator,
            @Param("auditor") Long auditor,
            @Param("depotId") Long depotId,
            @Param("status") String status,
            @Param("remark") String remark,
            @Param("number") String number,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByMaterialR(
            @Param("type") String type,
            @Param("creatorArray") String[] creatorArray,
            @Param("qualityNo") String qualityNo,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("organId") Long organId,
            @Param("creator") Long creator,
            @Param("auditor") Long auditor,
            @Param("depotId") Long depotId,
            @Param("status") String status,
            @Param("remark") String remark,
            @Param("number") String number);

    List<MaterialRVo4ListEx> getDetailByNumber(
            @Param("billNo") String billNo);

    int batchDeleteMaterialRByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String[] ids);

    List<MaterialR> getMaterialRListByOrganIds(@Param("organIds") String[] organIds);

    List<MaterialR> getMaterialRByReportId(
            @Param("reportId") Long reportId);

}