package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.FoodCategory;
import com.jsh.erp.service.foodCategory.FoodCategoryService;
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


@RestController
@RequestMapping(value = "/foodCategory")
@Api(tags = {"菜品类别"})
public class FoodCategoryController {
    private Logger logger = LoggerFactory.getLogger(FoodCategoryController.class);

    @Resource
    private FoodCategoryService foodCategoryService;

    /***
     * 获得所有菜品类别列表
     * @return
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "获得所有菜品类别列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<FoodCategory> foodCategoryList = foodCategoryService.getAllList();
            res.code = 200;
            res.data = foodCategoryList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
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
        int res = foodCategoryService.batchSetEnable(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
