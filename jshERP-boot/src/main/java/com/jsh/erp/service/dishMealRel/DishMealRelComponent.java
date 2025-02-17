package com.jsh.erp.service.dishMealRel;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.DishMealRelEx;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "dishMealRel_component")
@DishMealRelResource
public class DishMealRelComponent implements ICommonQuery {

    @Resource
    private DishMealRelService dishMealRelService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return dishMealRelService.getDishMealRel(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getList(map);
    }

    private List<DishMealRelEx> getList(Map<String,String> map) throws Exception{
        String search = map.get("search");
        Integer dishNameId = StringUtil.parseInteger(StringUtil.getInfo(search,"dishNameId"));
        Integer diningPrice = StringUtil.parseInteger(StringUtil.getInfo(search,"diningPrice"));
        Integer mealId = StringUtil.parseInteger(StringUtil.getInfo(search,"mealId"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        return dishMealRelService.select(dishNameId,diningPrice,mealId,beginTime,endTime, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        Integer diningPrice = StringUtil.parseInteger(StringUtil.getInfo(search,"diningPrice"));
        Integer mealId = StringUtil.parseInteger(StringUtil.getInfo(search,"mealId"));
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        return dishMealRelService.countSelect(diningPrice,mealId,beginTime,endTime);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishMealRelService.insert(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishMealRelService.update(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return dishMealRelService.delete(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return dishMealRelService.batchDelete(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
