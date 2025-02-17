package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.jsh.erp.datasource.entities.Information;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.information.InformationService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author zzl 云厨erp
 */
@RestController
@RequestMapping(value = "/information")
@Api(tags = {"央厨资料"})
public class InformationController {
    private Logger logger = LoggerFactory.getLogger(InformationController.class);

    @Resource
    private InformationService informationService;

    /**
     * 央厨资料列表
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "央厨资料列表")
    public JSONArray getAllList(HttpServletRequest request) throws Exception {
        JSONArray dataArray = new JSONArray();
        try {
            List<Information> dataList = informationService.getAllList();
            if (null != dataList) {
                for (Information information : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("id", information.getId());
                    item.put("name", information.getName());
                    dataArray.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataArray;
    }


    /**
     * 更新默认央厨信息
     * @param object
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateIsDefault")
    @ApiOperation(value = "更新默认央厨信息")
    public String updateIsDefault(@RequestBody JSONObject object,
                                  HttpServletRequest request) throws Exception{
        Long informationId = object.getLong("id");
        Map<String, Object> objectMap = new HashMap<>();
        int res = informationService.updateIsDefault(informationId);
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
        int res = informationService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

}
