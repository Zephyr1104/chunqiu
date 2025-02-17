package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.DishPackage;
import com.jsh.erp.service.dishPackage.DishPackageService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/dishPackage")
@Api(tags = "{套餐设置管理}")
public class DishPackageController {

    private Logger logger = LoggerFactory.getLogger(DishPackageController.class);

    @Resource
    private DishPackageService dishPackageService;

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "获取套餐设置列表")
    public BaseResponseInfo getAllList() {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<DishPackage> dishPackageList = dishPackageService.getAllList();
            res.code = 200;
            res.data = dishPackageList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
