package com.jsh.erp.service.dishPackage;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.DishPackageEx;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "dishPackage_component")
@DishPackageResource
public class DishPackageComponent implements ICommonQuery {

    @Resource
    private DishPackageService dishPackageService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return dishPackageService.getDishPackage(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getDishPackageList(map);
    }

    private List<DishPackageEx> getDishPackageList(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search, "name");
        Integer mealType = StringUtil.parseInteger(StringUtil.getInfo(search, "mealType"));
        return dishPackageService.select(name, mealType, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search, "name");
        Integer mealType = StringUtil.parseInteger(StringUtil.getInfo(search, "mealType"));
        return dishPackageService.countSelect(name, mealType);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishPackageService.insertDishPackage(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishPackageService.updateDishPackage(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return dishPackageService.deleteDishPackage(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return dishPackageService.batchDeleteDishPackage(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return dishPackageService.checkIsPackageExist(id, name);
    }
}
