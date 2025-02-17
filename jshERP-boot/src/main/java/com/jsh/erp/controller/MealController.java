package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Meal;
import com.jsh.erp.service.meal.MealService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author Xiazy
 * @date 2019/8/24 16:43
 */
@RestController
@RequestMapping(value = "/meal")
@Api(tags = {"餐次管理"})
public class MealController {
    private Logger logger = LoggerFactory.getLogger(MealController.class);

    @Resource
    private MealService mealService;

    /**
     * 餐次列表
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getAllList")
    @ApiOperation(value = "餐次列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Meal> mealList = mealService.getAllList();
            res.code = 200;
            res.data = mealList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 更新默认餐次
     * @param object
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateIsDefault")
    @ApiOperation(value = "更新默认餐次")
    public String updateIsDefault(@RequestBody JSONObject object,
                                  HttpServletRequest request) throws Exception{
        Long depotId = object.getLong("id");
        Map<String, Object> objectMap = new HashMap<>();
        int res = mealService.updateIsDefault(depotId);
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
        int res = mealService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
