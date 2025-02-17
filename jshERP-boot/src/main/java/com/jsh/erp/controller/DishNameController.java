package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.datasource.entities.DishName;
import com.jsh.erp.datasource.entities.DishNameEx;
import com.jsh.erp.service.dishName.DishNameService;
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
@RequestMapping(value = "/dishName")
@Api(tags = "{菜品名称}")
public class DishNameController {

    private Logger logger = LoggerFactory.getLogger(DishNameController.class);


    @Resource
    private DishNameService dishNameService;

    @GetMapping(value="/getDishNameById")
    @ApiOperation(value = "DishName根据id查询")
    public BaseResponseInfo getDishNameById(Long id) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try{
            DishName dishName = dishNameService.getDishName(id);
            res.code = 200;
            res.data = dishName;
        }catch (Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "菜品列表")
    public BaseResponseInfo getAllList() throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try{
            List<DishName> dishNameList = dishNameService.getAllList();
            res.code = 200;
            res.data = dishNameList;
        }catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
    