package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Nutritional;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.service.nutritional.NutritionalService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.ExcelUtils;
import com.jsh.erp.utils.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jxl.Sheet;
import jxl.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/nutritional")
@Api(tags = {"国际食材营养成分"})
public class NutritionalController {
    //private Logger logger = LoggerFactory.getLogger(NutritionalController.class);

    @Resource
    private NutritionalService nutritionalService;


    /**
     * 食材营养成本列表
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "食材营养成分列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<Nutritional> nutritionalList = nutritionalService.getAllList();
            res.code = 200;
            res.data = nutritionalList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }


    /**
     * 更新默认食材营养成分
     * @param object
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/updateIsDefault")
    @ApiOperation(value = "更新食材营养成分")
    public String updateIsDefault(@RequestBody JSONObject object,
                                  HttpServletRequest request) throws Exception{
        Long nutritionalId = object.getLong("id");
        Map<String, Object> objectMap = new HashMap<>();
        int res = nutritionalService.updateIsDefault(nutritionalId);
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
        int res = nutritionalService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * Excel导入食材营养成分
     * @param file
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/importNutritionalExcel")
    public BaseResponseInfo importItemExcel(MultipartFile file,
                                            @RequestParam(required = false, value = "prefixNo") String prefixNo,
                                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        BaseResponseInfo res = new BaseResponseInfo();
        Map<String, Object> data = new HashMap<>();
        String message = "";
        try {
            String barCodes = "";
            //文件合法性校验
            Sheet src = null;
            try {
                Workbook workbook = Workbook.getWorkbook(file.getInputStream());
                src = workbook.getSheet(0);
            } catch (Exception e) {
                message = "导入文件不合法，请检查";
                data.put("message", message);
                res.code = 400;
                res.data = data;
            }
            if(src.getRows()>1000) {
                message = "导入失败，明细不能超出1000条";
                res.code = 500;
                data.put("message", message);
                res.data = data;
            } else {
                List<Map<String, String>> detailList = new ArrayList<>();
                for (int i = 2; i < src.getRows(); i++) {
                    String depotName = "", barCode = "", num = "", unitPrice = "", taxRate = "", remark = "";
                    if("CGDD".equals(prefixNo) || "XSDD".equals(prefixNo)) {
                        barCode = ExcelUtils.getContent(src, i, 0);
                        num = ExcelUtils.getContent(src, i, 2);
                        unitPrice = ExcelUtils.getContent(src, i, 3);
                        taxRate = ExcelUtils.getContent(src, i, 4);
                        remark = ExcelUtils.getContent(src, i, 5);
                    }
                    if("CGRK".equals(prefixNo) || "XSCK".equals(prefixNo)) {
                        depotName = ExcelUtils.getContent(src, i, 0);
                        barCode = ExcelUtils.getContent(src, i, 1);
                        num = ExcelUtils.getContent(src, i, 3);
                        unitPrice = ExcelUtils.getContent(src, i, 4);
                        taxRate = ExcelUtils.getContent(src, i, 5);
                        remark = ExcelUtils.getContent(src, i, 6);
                    }
                    if("QTRK".equals(prefixNo) || "QTCK".equals(prefixNo)) {
                        depotName = ExcelUtils.getContent(src, i, 0);
                        barCode = ExcelUtils.getContent(src, i, 1);
                        num = ExcelUtils.getContent(src, i, 3);
                        unitPrice = ExcelUtils.getContent(src, i, 4);
                        remark = ExcelUtils.getContent(src, i, 5);
                    }
                    Map<String, String> agreementPriceMap = new HashMap<>();
                    agreementPriceMap.put("depotName", depotName);
                    agreementPriceMap.put("barCode", barCode);
                    agreementPriceMap.put("num", num);
                    agreementPriceMap.put("unitPrice", unitPrice);
                    agreementPriceMap.put("taxRate", taxRate);
                    agreementPriceMap.put("remark", remark);
                    detailList.add(agreementPriceMap);
                    barCodes += "'" + barCode + "',";
                }
                if (StringUtil.isNotEmpty(barCodes)) {
                    barCodes = barCodes.substring(0, barCodes.length() - 1);
                }
                JSONObject map = nutritionalService.parseMapByExcelData(barCodes, detailList, prefixNo);
                if (map != null) {
                    res.code = 200;
                } else {
                    res.code = 500;
                }
                res.data = map;
            }
        } catch (BusinessRunTimeException e) {
            res.code = 500;
            data.put("message", e.getData().get("message"));
            res.data = data;
        } catch (Exception e) {
            e.printStackTrace();
            message = "导入失败，请检查表格内容";
            res.code = 500;
            data.put("message", message);
            res.data = data;
        }
        return res;
    }
}
