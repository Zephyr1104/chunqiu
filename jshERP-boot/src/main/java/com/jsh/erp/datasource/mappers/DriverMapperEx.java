package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Driver;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DriverMapperEx {

    List<Driver> selectByConditionDriver(
            @Param("loginName") String loginName,
            @Param("driverName") String driverName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByDriver(
            @Param("driverName") String driverName,
            @Param("loginName") String loginName);

  //  List<Driver> getDriverListByDriverNameOrLoginName(@Param("driverName") String driverName,@Param("loginName") String loginName);

    int batDeleteOrUpdateDriver(@Param("ids") String ids[], @Param("status") byte status);

}