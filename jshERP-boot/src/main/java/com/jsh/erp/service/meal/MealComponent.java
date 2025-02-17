package com.jsh.erp.service.meal;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "meal_component")
@MealResource
public class MealComponent implements ICommonQuery {

    @Resource
    private MealService mealService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return mealService.getMeal(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getMealList(map);
    }

    private List<?> getMealList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String remark = StringUtil.getInfo(search, "remark");
        return mealService.select(name,  remark, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String remark = StringUtil.getInfo(search, "remark");
        return mealService.countMeal(name, remark);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception{
        return mealService.insertMeal(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return mealService.updateMeal(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return mealService.deleteMeal(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return mealService.batchDeleteMeal(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return mealService.checkIsNameExist(id, name);
    }

}
