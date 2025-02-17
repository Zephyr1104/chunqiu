package com.jsh.erp.datasource.mappers;

import com.jsh.erp.datasource.entities.Processor;
import com.jsh.erp.datasource.vo.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:51
 */
public interface ProcessorMapperEx {


    List<TreeNode> getNodeTree(@Param("currentId")Long currentId);

    List<TreeNode> getNextNodeTree(Map<String, Object> parameterMap);

    int addProcessor(Processor pro);

    List <Processor> getProcessorByParentIds(@Param("ids") String ids[]);

    int batchDeleteProcessorByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    int editProcessor(Processor pro);

    List <Processor> getProcessorRootByIds(@Param("ids") String ids[]);
}
