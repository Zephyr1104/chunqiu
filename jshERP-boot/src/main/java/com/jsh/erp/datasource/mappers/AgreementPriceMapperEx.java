package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.*;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @Author: zzl
 * @Date: 2024/7/08 16:59
 */
public interface AgreementPriceMapperEx {
    List<AgreementPrice> selectByConditionAgreementPrice(
            @Param("material_id") Integer material_id,
            @Param("batch_number") String batch_number,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByAgreementPrice(
            @Param("material_id") Integer material_id,
            @Param("batch_number") String batch_number);

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
