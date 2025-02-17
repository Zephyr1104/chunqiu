package com.jsh.erp.service.processor;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:09
 */
@Service(value = "processor_component")
@ProcessorResource
public class ProcessorComponent implements ICommonQuery {
    @Resource
    private ProcessorService processorService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return processorService.getProcessor(id);
    }

    @Override
    public List<?> select(Map<String, String> parameterMap)throws Exception {
        return getProcessorList(parameterMap);
    }
    private List<?> getProcessorList(Map<String, String> map)throws Exception {
        return null;
    }
    @Override
    public Long counts(Map<String, String> parameterMap)throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return processorService.insertProcessor(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return processorService.updateProcessor(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return processorService.deleteProcessor(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return processorService.batchDeleteProcessor(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return processorService.checkIsNameExist(id, name);
    }
}
