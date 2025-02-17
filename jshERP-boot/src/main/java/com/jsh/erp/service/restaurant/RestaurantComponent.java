package com.jsh.erp.service.restaurant;

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

@Service(value = "restaurant_component")
@RestaurantResource
public class RestaurantComponent implements ICommonQuery {

    @Resource
    private RestaurantService restaurantService;

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getRestaurantList(map);
    }

    private List<?> getRestaurantList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return restaurantService.select(name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return restaurantService.countRestaurant(name);
    }

    @Override
    public Object selectOne(Long id) throws Exception {
        return restaurantService.getRestaurant(id);
    }

     @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return restaurantService.insertRestaurant(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return restaurantService.updateRestaurant(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return restaurantService.deleteRestaurant(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return restaurantService.batchDeleteRestaurant(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return restaurantService.checkIsNameExist(id, name);
    }

}
