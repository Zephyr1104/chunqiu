package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Meal;
import com.jsh.erp.datasource.entities.ProcessTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProcessTemplateMapperEx {

    List<ProcessTemplate> selectByConditionProcessTemplate(
            @Param("name") String name,
            @Param("remark") String remark,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByProcessTemplate(
            @Param("name") String name,
            @Param("remark") String remark);
    int batchDeleteProcessTemplateByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}
