package com.jsh.erp.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.Processor;
import com.jsh.erp.datasource.vo.TreeNode;
import com.jsh.erp.service.processor.ProcessorService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * create by: xiazhenyu
 * description:
 *
 * create time: 2024年4月28日11:29:14
 */
@RestController
@RequestMapping(value = "/processor")
@Api(tags = {"工厂模型"})
public class ProcessorController {
    private Logger logger = LoggerFactory.getLogger(ProcessorController.class);

    @Resource
    private ProcessorService processorService;

    @Resource
    private UserService userService;

    /**
     * 根据id来查询机构信息
     * @param id
     * @param request
     * @return
     */
    @GetMapping(value = "/findById")
    @ApiOperation(value = "根据id来查询机构信息")
    public BaseResponseInfo findById(@RequestParam("id") Long id, HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<Processor> dataList = processorService.findById(id);
            JSONObject outer = new JSONObject();
            if (null != dataList) {
                for (Processor proce : dataList) {
                    outer.put("id", proce.getId());
                    outer.put("processorAbr", proce.getProcessorAbr());
                    outer.put("parentId", proce.getParentId());
                    List<Processor> dataParentList = processorService.findByParentId(proce.getParentId());
                    if(dataParentList!=null&&dataParentList.size()>0){
                        //父级机构名称显示简称
                        outer.put("processorParentName", dataParentList.get(0).getProcessorAbr());
                    }
                    outer.put("processorNo", proce.getProcessorNo());
                    outer.put("sort", proce.getSort());
                    outer.put("remark", proce.getRemark());
                }
            }
            res.code = 200;
            res.data = outer;
        } catch(Exception e){
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 获取工厂模型树数据
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getProcessorTree")
    @ApiOperation(value = "获取机构树数据")
    public JSONArray getProcessorTree(@RequestParam("id") Long id) throws Exception{
       JSONArray arr=new JSONArray();
       List<TreeNode> processorTree= processorService.getProcessorTree(id);
       if(processorTree!=null&&processorTree.size()>0){
           for(TreeNode node:processorTree){
               String str=JSON.toJSONString(node);
               JSONObject obj=JSON.parseObject(str);
               arr.add(obj);
           }
       }
        return arr;
    }

    /**
     * 根据用户获取全部机构树
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/getAllProcessorTreeByUser")
    @ApiOperation(value = "根据用户获取全部机构树")
    public JSONArray getAllProcessorTreeByUser(HttpServletRequest request) throws Exception{
        JSONArray arr = new JSONArray();
        Long userId = userService.getUserId(request);
        String roleType = userService.getRoleTypeByUserId(userId).getType();
        if(BusinessConstants.ROLE_TYPE_PUBLIC.equals(roleType)) {
            List<TreeNode> processorTree = processorService.getProcessorTree(null);
            if(processorTree!=null && processorTree.size()>0){
                for(TreeNode node: processorTree){
                    String str = JSON.toJSONString(node);
                    JSONObject obj = JSON.parseObject(str);
                    arr.add(obj);
                }
            }
        }
        return arr;
    }
}
