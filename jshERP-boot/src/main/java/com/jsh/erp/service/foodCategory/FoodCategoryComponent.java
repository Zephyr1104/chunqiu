package com.jsh.erp.service.foodCategory;

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

@Service(value = "foodCategory_component")
@FoodCategoryResource
public class FoodCategoryComponent implements ICommonQuery {

    @Resource
    private FoodCategoryService foodCategoryService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return foodCategoryService.getFoodCategory(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getFoodCategoryList(map);
    }

    private List<?> getFoodCategoryList(Map<String, String> map) throws Exception {
       String search = map.get(Constants.SEARCH);
       String name= StringUtil.getInfo(search, "name");
       String remark = StringUtil.getInfo(search, "remark");
       return foodCategoryService.select(name,remark, QueryUtils.offset(map),QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String remark = StringUtil.getInfo(search, "remark");
        return foodCategoryService.countFoodCategory(name,remark);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return foodCategoryService.insertFoodCategory(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return foodCategoryService.updateFoodCategory(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return foodCategoryService.deleteFoodCategory(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return foodCategoryService.batchDeleteFoodCategory(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return foodCategoryService.checkIsNameExist(id, name);
    }
}
