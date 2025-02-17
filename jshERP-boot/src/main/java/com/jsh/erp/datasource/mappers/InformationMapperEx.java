package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.InformationEx;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Description
 *
 * @Author: zzl
 * @Date: 2024/8/03 16:59
 */
public interface InformationMapperEx {
    List<InformationEx> selectByConditionInformation(
            @Param("name") String name,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByInformation(
            @Param("name") String name);


}
