package com.jsh.erp.service.dishName;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.DishName;
import com.jsh.erp.datasource.entities.DishNameEx;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "dishName_component")
@DishNameResource
public class DishNameComponent implements ICommonQuery {

    @Resource
    private DishNameService dishNameService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return dishNameService.getDishName(id);
    }

    @Override
    public List<DishNameEx> select(Map<String, String> map) throws Exception {
        return getDishNameList(map);
    }

    private List<DishNameEx> getDishNameList(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search, "name");
        String allergen = StringUtil.getInfo(search, "allergen");
        return dishNameService.select(name, allergen, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search, "name");
        String allergen = StringUtil.getInfo(search, "allergen");
        return dishNameService.countSelect(name, allergen);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishNameService.insertDishName(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishNameService.updateDishName(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return dishNameService.deleteDishName(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return dishNameService.batchDeleteDishName(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return dishNameService.checkIsNameExist(id, name);
    }
}
