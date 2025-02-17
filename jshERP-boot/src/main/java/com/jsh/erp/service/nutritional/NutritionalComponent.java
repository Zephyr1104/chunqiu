package com.jsh.erp.service.nutritional;

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

@Service(value = "nutritional_component")
@NutritionalResource
public class NutritionalComponent implements ICommonQuery {

    @Resource
    private NutritionalService nutritionalService;

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getNutritionalList(map);
    }

    private List<?> getNutritionalList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return nutritionalService.select(name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return nutritionalService.countNutritional(name);
    }

    @Override
    public Object selectOne(Long id) throws Exception {
        return nutritionalService.getNutritional(id);
    }

     @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return nutritionalService.insertNutritional(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return nutritionalService.updateNutritional(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return nutritionalService.deleteNutritional(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return nutritionalService.batchDeleteNutritional(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return nutritionalService.checkIsNameExist(id, name);
    }

}
