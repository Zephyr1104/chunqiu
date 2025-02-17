package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Nutritional;
import com.jsh.erp.datasource.entities.MaterialVo4Unit;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @Author: zzl
 * @Date: 2024/7/08 16:59
 */
public interface NutritionalMapperEx {
    List<Nutritional> selectByConditionNutritional(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByNutritional(
            @Param("name") String name);

    Long findDetailByDepotIdsAndMaterialIdCount(
            @Param("depotIdArray") Long[] depotIdArray,
            @Param("forceFlag") Boolean forceFlag,
            @Param("inOutManageFlag") Boolean inOutManageFlag,
            @Param("sku") String sku,
            @Param("batchNumber") String batchNumber,
            @Param("number") String number,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("mId") Long mId);

    BigDecimal inOrOutPrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("forceFlag") Boolean forceFlag);

    BigDecimal inOrOutRetailPrice(
            @Param("type") String type,
            @Param("subType") String subType,
            @Param("beginTime") String beginTime,
            @Param("endTime") String endTime,
            @Param("creatorArray") String[] creatorArray,
            @Param("forceFlag") Boolean forceFlag);

    List<MaterialVo4Unit> getBillItemByParam(
            @Param("barCodes") String barCodes);
}
