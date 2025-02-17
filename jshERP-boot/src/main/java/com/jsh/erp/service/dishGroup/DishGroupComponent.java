package com.jsh.erp.service.dishGroup;


import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.DishGroup;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value="dishGroup_component")
@DishGroupResource
public class DishGroupComponent implements ICommonQuery {

    @Resource
    private DishGroupService dishGroupService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return dishGroupService.getDishGroup(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getDishGroupList(map);
    }

    private List<DishGroup> getDishGroupList(Map<String,String> map) throws Exception{
        String search = map.get("search");
        String name = StringUtil.getInfo(search,"name");
        return dishGroupService.select(name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search,"name");
        return dishGroupService.countSelect(name);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishGroupService.insertDishGroup(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return dishGroupService.updateDishGroup(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return dishGroupService.deleteDishGroup(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return dishGroupService.batchDeleteDishGroup(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return dishGroupService.checkIsNameExist(id,name);
    }
}
