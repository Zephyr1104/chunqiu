package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.service.bomMaster.BomMasterService;
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
@RequestMapping(value = "/bomMaster")
@Api(tags = "{BomMaster}")
public class BomMasterController {

    private Logger logger = LoggerFactory.getLogger(BomMasterController.class);

    @Resource
    private BomMasterService bomMasterService;

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "BomMaster-获取所有信息")
    public BaseResponseInfo getAllList() throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try{
            List<BomMaster> bomMastersList = bomMasterService.getAllList();
            res.code = 200;
            res.data = bomMastersList;
        }catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }


}
