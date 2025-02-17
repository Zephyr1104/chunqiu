package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.DishGroup;
import com.jsh.erp.datasource.entities.DishName;
import com.jsh.erp.service.dishGroup.DishGroupService;
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
@RequestMapping(value = "/dishGroup")
@Api(tags = "{菜谱分组管理}")
public class DishGroupController {

    private Logger logger = LoggerFactory.getLogger(DishGroupController.class);

    @Resource
    private DishGroupService dishGroupService;


    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "菜谱分组列表")
    public BaseResponseInfo getAllList() throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try{
            List<DishGroup> dishGroupList = dishGroupService.getAllList();
            res.code = 200;
            res.data = dishGroupList;
        }catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
