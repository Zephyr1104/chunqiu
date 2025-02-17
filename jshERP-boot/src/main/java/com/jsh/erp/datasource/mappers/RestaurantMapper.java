package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Restaurant;
import com.jsh.erp.datasource.entities.RestaurantEx;
import com.jsh.erp.datasource.entities.RestaurantExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RestaurantMapper {
    long countByExample(RestaurantExample example);

    int deleteByExample(RestaurantExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Restaurant record);

    int insertSelective(Restaurant record);

    List<Restaurant> selectByExample(RestaurantExample example);

    Restaurant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    int updateByExample(@Param("record") Restaurant record, @Param("example") RestaurantExample example);

    int updateByPrimaryKeySelective(RestaurantEx record);

    int updateByPrimaryKey(Restaurant record);
}