package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.DishMealRel;
import com.jsh.erp.service.dishMealRel.DishMealRelService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dishMealRel")
@Api(tags = "菜谱餐次关系表管理")
public class DishMealRelController {
    private Logger logger = LoggerFactory.getLogger(DishMealRelController.class);

    @Resource
    private DishMealRelService dishMealRelService;

    @RequestMapping(value = "/getAllList")
    @ApiOperation(value = "获取所有菜谱餐次关系列表")
    public BaseResponseInfo getAllList(){
        BaseResponseInfo info = new BaseResponseInfo();
        try{
            List<DishMealRel> list = dishMealRelService.getAllList();
            info.code = 200;
            info.data = list;
        } catch (Exception e) {
            e.printStackTrace();
            info.code = 500;
            info.data = "获取数据失败";
        }
        return info;
    }

}
