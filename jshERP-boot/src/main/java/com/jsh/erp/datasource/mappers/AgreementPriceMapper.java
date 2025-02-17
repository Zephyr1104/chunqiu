package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.AgreementPrice;
import com.jsh.erp.datasource.entities.AgreementPriceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AgreementPriceMapper {
    long countByExample(AgreementPriceExample example);

    int deleteByExample(AgreementPriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AgreementPrice record);

    int insertSelective(AgreementPrice record);

    List<AgreementPrice> selectByExample(AgreementPriceExample example);

    AgreementPrice selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AgreementPrice record, @Param("example") AgreementPriceExample example);

    int updateByExample(@Param("record") AgreementPrice record, @Param("example") AgreementPriceExample example);

    int updateByPrimaryKeySelective(AgreementPrice record);

    int updateByPrimaryKey(AgreementPrice record);
}