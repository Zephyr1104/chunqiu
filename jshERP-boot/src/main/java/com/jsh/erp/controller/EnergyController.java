package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Energy;
import com.jsh.erp.service.energy.EnergyService;
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
 * @author zzl
 * @date 2024/8/24 16:43
 */
@RestController
@RequestMapping(value = "/energy")
@Api(tags = {"能效设置"})
public class EnergyController {
    private Logger logger = LoggerFactory.getLogger(EnergyController.class);

    @Resource
    private EnergyService energyService;

    /**
     * 能效列表
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "能效列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Energy> energyList = energyService.getAllList();
            res.code = 200;
            res.data = energyList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 更新默认能效
     * @param object
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateIsDefault")
    @ApiOperation(value = "更新默认能效")
    public String updateIsDefault(@RequestBody JSONObject object,
                                  HttpServletRequest request) throws Exception{
        Long energyId = object.getLong("id");
        Map<String, Object> objectMap = new HashMap<>();
        int res = energyService.updateIsDefault(energyId);
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
        int res = energyService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
