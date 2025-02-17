package com.jsh.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.Meal;
import com.jsh.erp.datasource.entities.ProcessTemplate;
import com.jsh.erp.service.meal.MealService;
import com.jsh.erp.service.processTemplate.ProcessTemplateService;
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
 * @author Xiazy
 * @date 2019/8/24 16:43
 */
@RestController
@RequestMapping(value = "/processTemplate")
@Api(tags = {"工序管理"})
public class ProcessTemplateController {
    private Logger logger = LoggerFactory.getLogger(ProcessTemplateController.class);


    @Resource
    private ProcessTemplateService processTemplateService;

    /**
     * 餐次列表
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllList")
    @ApiOperation(value = "工序列表")
    public BaseResponseInfo getAllList(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<ProcessTemplate> ProcessTemplateList = processTemplateService.getAllList();
            res.code = 200;
            res.data = ProcessTemplateList;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

}
