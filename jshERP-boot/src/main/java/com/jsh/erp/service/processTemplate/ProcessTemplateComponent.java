package com.jsh.erp.service.processTemplate;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.meal.MealResource;
import com.jsh.erp.service.meal.MealService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "processTemplate_component")
@ProcessTemplateResource
public class ProcessTemplateComponent implements ICommonQuery {

    @Resource
    private ProcessTemplateService processTemplateService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return processTemplateService.getProcessTemplate(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getMealList(map);
    }

    private List<?> getMealList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String remark = StringUtil.getInfo(search, "remark");
        String order = QueryUtils.order(map);
        return processTemplateService.select(name,  remark, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String remark = StringUtil.getInfo(search, "remark");
        return processTemplateService.countProcessTemplate(name, remark);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception{
        return processTemplateService.insertProcessTemplate(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return processTemplateService.updateProcessTemplate(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return processTemplateService.deleteProcessTemplate(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return processTemplateService.batchDeleteProcessTemplate(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return processTemplateService.checkIsNameExist(id, name);
    }

}
