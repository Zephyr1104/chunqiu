package com.jsh.erp.service.menu;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.meal.MealService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "menu_component")
@MenuResource
public class MenuComponent implements ICommonQuery {

    @Resource
    private MenuService menuService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return menuService.getMenu(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return menuService.getAllList();
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        return null;
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return menuService.insertMenu(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return menuService.updateMenu(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return menuService.deleteMenu(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return 0;
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return menuService.checkIsNameExist(id, name);
    }
}
