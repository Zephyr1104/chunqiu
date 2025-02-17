package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.service.materialR.MaterialRService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.ErpInfo;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jsh.erp.utils.ResponseJsonUtil.returnJson;

/**
 * @author zzl 752*718*920
 */
@RestController
@RequestMapping(value = "/materialR")
@Api(tags = {"原料质检报告管理"})
public class MaterialRController {
    private Logger logger = LoggerFactory.getLogger(MaterialRController.class);

    @Resource
    private MaterialRService materialRService;

    /**
     * 批量设置状态-审核或者反审核
     * @param jsonObject
     * @param request
     * @return
     */
    @PostMapping(value = "/batchSetStatus")
    @ApiOperation(value = "批量设置状态-审核或者反审核")
    public String batchSetStatus(@RequestBody JSONObject jsonObject,
                                 HttpServletRequest request) throws Exception{
        Map<String, Object> objectMap = new HashMap<>();
        String status = jsonObject.getString("status");
        String ids = jsonObject.getString("ids");
        int res = materialRService.batchSetStatus(status, ids);
        if(res > 0) {
            return returnJson(objectMap, ErpInfo.OK.name, ErpInfo.OK.code);
        } else {
            return returnJson(objectMap, ErpInfo.ERROR.name, ErpInfo.ERROR.code);
        }
    }

    /**
     * 新增原料质检报告信息
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/addMaterialR")
    @ApiOperation(value = "新增原料质检报告信息")
    public Object addMaterialR(@RequestBody MaterialRVo4Body body, HttpServletRequest request) throws  Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        String beanJson = body.getInfo();
        String rows = body.getRows();
        materialRService.addMaterialR(beanJson,rows, request);
        return result;
    }

    /**
     * 更新原料质检报告信息
     * @param body
     * @param request
     * @return
     * @throws Exception
     */
    @PutMapping(value = "/updateMaterialR")
    @ApiOperation(value = "更新原料质检报告信息")
    public Object updateMaterialR(@RequestBody MaterialRVo4Body body, HttpServletRequest request) throws Exception{
        JSONObject result = ExceptionConstants.standardSuccess();
        String beanJson = body.getInfo();
        String rows = body.getRows();
        materialRService.updateMaterialR(beanJson,rows,request);
        return result;
    }

    /**
     * 根据质检报告单据id查询质检单
     * @param reportId
     * @param request
     * @return
     */
    @GetMapping(value = "/getMaterialRByReportId")
    @ApiOperation(value = "根据编号查询报告信息")
    public BaseResponseInfo getMaterialRByReportId(@RequestParam("reportId") Long reportId,
                                              HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        MaterialR materialR = null;
        try {
            materialR = materialRService.getMaterialR(reportId);
            res.code = 200;
            res.data = materialR;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 报告明细列表
     * @param headerId
     * @param mpList
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getDetailList")
    @ApiOperation(value = "报告明细列表")
    public BaseResponseInfo getDetailList(@RequestParam("headerId") Long headerId,
                                          @RequestParam("mpList") String mpList,
                                          @RequestParam(value = "linkType", required = false) String linkType,
                                          @RequestParam(value = "isReadOnly", required = false) String isReadOnly,
                                          HttpServletRequest request)throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<MaterialR> dataList = new ArrayList<>();
            if(headerId != 0) {
                dataList = materialRService.getMaterialRByReportId(headerId);
            }
            JSONObject outer = new JSONObject();
            outer.put("total", dataList.size());
            //存放数据json数组
            JSONArray dataArray = new JSONArray();
            if (null != dataList) {

                for (MaterialR diEx : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("id", diEx.getId());
                    item.put("depotId", diEx.getDepotId());
                    item.put("barCode", diEx.getMaterialId());
                    item.put("name", diEx.getMaterialName());
                    item.put("basicNumber", diEx.getBasicNumber());
                    item.put("operNumber2", diEx.getOperNumber());
                    item.put("qualityName", diEx.getQualityName());
                    item.put("qualityTime", diEx.getQualityTime());
                    item.put("unit", diEx.getMaterialUnit());
                    item.put("remark", diEx.getRemark());
                    dataArray.add(item);

                }
                if(StringUtil.isNotEmpty(isReadOnly) && "1".equals(isReadOnly)) {
                    JSONObject footItem = new JSONObject();

                    dataArray.add(footItem);
                }
            }
            outer.put("rows", dataArray);
            res.code = 200;
            res.data = outer;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }
}
