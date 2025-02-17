package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Driver;
import com.jsh.erp.service.driver.DriverService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.Tools;
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
 * @author zzl 2024-08-09
 */
@RestController
@RequestMapping(value = "/driver")
@Api(tags = {"司机管理"})
public class DriverController {
    private Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;
    private static String SUCCESS = "操作成功";
    private static String ERROR = "操作失败";

    @PostMapping(value = "/resetPwd")
    @ApiOperation(value = "重置司机账号密码")
    public String resetPwd(@RequestBody JSONObject jsonObject,
                                     HttpServletRequest request) throws Exception {
        Map<String, Object> objectMap = new HashMap<>();
        Long id = jsonObject.getLong("id");
        String password = "123456";
        String md5Pwd = Tools.md5Encryp(password);
        int update = driverService.resetPwd(md5Pwd, id);
        if(update > 0) {
            return returnJson(objectMap, SUCCESS, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ERROR, ErpInfo.ERROR.code);
        }
    }

    @PutMapping(value = "/updatePwd")
    @ApiOperation(value = "更新司机账号密码")
    public String updatePwd(@RequestBody JSONObject jsonObject, HttpServletRequest request)throws Exception {
        Integer flag = 0;
        Map<String, Object> objectMap = new HashMap<String, Object>();
        try {
            String info = "";
            Long id = jsonObject.getLong("id");//司机id
            String oldpwd = jsonObject.getString("oldpassword");
            String password = jsonObject.getString("password");
            Driver driver = driverService.getDriver(id);
            //必须和原始密码一致才可以更新密码
            if (oldpwd.equalsIgnoreCase(driver.getPassword())) {
                driver.setPassword(password);
                flag = driverService.updateDriverByObj(driver); //1-成功
                info = "修改密码成功";
            } else {
                flag = 2; //原始密码输入错误
                info = "原始密码输入错误";
            }
            objectMap.put("status", flag);
            if(flag > 0) {
                return returnJson(objectMap, info, ErpInfo.OK.code);
            } else {
                return returnJson(objectMap, ERROR, ErpInfo.ERROR.code);
            }
        } catch (Exception e) {
            logger.error(">>>>>>>>>>>>>修改用户ID为 ： " + jsonObject.getLong("userId") + "密码信息失败", e);
            flag = 3;
            objectMap.put("status", flag);
            return returnJson(objectMap, ERROR, ErpInfo.ERROR.code);
        }
    }

    /**
     * 获取全部司机数据列表
     * @param request
     * @return
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "获取全部司机数据列表")
    public BaseResponseInfo getAllList(HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Driver> driverList = driverService.getDriver();
            res.code = 200;
            res.data = driverList;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取失败";
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
        Byte status = jsonObject.getByte("status");
        String ids = jsonObject.getString("ids");
        Map<String, Object> objectMap = new HashMap<>();
        int res = driverService.batchSetStatus(status, ids, request);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
