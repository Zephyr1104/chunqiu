package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.MaterialVo4Unit;
import com.jsh.erp.datasource.entities.Restaurant;
import com.jsh.erp.datasource.entities.RestaurantEx;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description
 *
 * @Author: zzl
 * @Date: 2024/8/03 16:59
 */
public interface RestaurantMapperEx {
    List<RestaurantEx> selectByConditionRestaurant(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByRestaurant(
            @Param("name") String name);
}
