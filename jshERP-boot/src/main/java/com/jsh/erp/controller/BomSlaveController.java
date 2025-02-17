package com.jsh.erp.controller;

import com.jsh.erp.datasource.entities.BomSlave;
import com.jsh.erp.service.bomSlave.BomSlaveService;
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
@RequestMapping(value = "/bomSlave")
@Api(tags = "{BomSlave}")
public class BomSlaveController {

    private Logger logger = LoggerFactory.getLogger(BomSlaveController.class);

    @Resource
    private BomSlaveService bomSlaveService;

    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "BomSlave-获取所有信息")
    public BaseResponseInfo getAllList() throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try{
            List<BomSlave> bomSlaveList = bomSlaveService.getAllList();
            res.code = 200;
            res.data = bomSlaveList;
        }catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }


}
