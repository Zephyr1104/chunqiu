package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Restaurant;
import com.jsh.erp.service.restaurant.RestaurantService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author zzl 云厨erp
 */
@RestController
@RequestMapping(value = "/restaurant")
@Api(tags = {"自营餐厅"})
public class RestaurantController {
    //private Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @Resource
    private RestaurantService restaurantService;


    /**
     * 自营餐厅列表
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "自营餐厅列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Restaurant> restaurantList = restaurantService.getAllList();
            res.code = 200;
            res.data = restaurantList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }


    /**
     * 更新默认自营餐厅
     * @param object
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateIsDefault")
    @ApiOperation(value = "更新自营餐厅")
    public String updateIsDefault(@RequestBody JSONObject object,
                                  HttpServletRequest request) throws Exception{
        Long restaurantId = object.getLong("id");
        Map<String, Object> objectMap = new HashMap<>();
        int res = restaurantService.updateIsDefault(restaurantId);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 批量设置状态-启用或者禁用
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request)throws Exception {
        Boolean status = jsonObject.getBoolean("status");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = restaurantService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
