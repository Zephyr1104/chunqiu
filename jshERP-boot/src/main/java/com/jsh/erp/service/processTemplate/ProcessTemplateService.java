package com.jsh.erp.service.processTemplate;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.systemConfig.SystemConfigService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.service.userBusiness.UserBusinessService;
import com.jsh.erp.utils.StringUtil;
import org.apache.tomcat.jni.Proc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xiazy
 * @date 2018/12/20 time:16:36
 */
@Service
public class ProcessTemplateService {
    private Logger logger = LoggerFactory.getLogger(ProcessTemplateService.class);

    @Resource
    private ProcessTemplateMapper processTemplateMapper;

    @Resource
    private ProcessTemplateMapperEx processTemplateMapperEx;

    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    public ProcessTemplate getProcessTemplate(long id) throws Exception {
        ProcessTemplate result = null;
        try {
            result = processTemplateMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public List<ProcessTemplate> getProcessTemplateListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<ProcessTemplate> list = new ArrayList<>();
        try {
            ProcessTemplateExample example = new ProcessTemplateExample();
            example.createCriteria().andIdIn(idList);
            list = processTemplateMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<ProcessTemplate> getProcessTemplateList() throws Exception {
        ProcessTemplateExample example = new ProcessTemplateExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<ProcessTemplate> list = null;
        try {
            list = processTemplateMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<ProcessTemplate> getAllList() throws Exception {
        ProcessTemplateExample example = new ProcessTemplateExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort asc, id desc");
        List<ProcessTemplate> list = null;
        try {
            list = processTemplateMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<ProcessTemplate> select(String name, String remark, int offset, int rows) throws Exception {
        List<ProcessTemplate> list = null;
        try {
            list = processTemplateMapperEx.selectByConditionProcessTemplate(name, remark, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }


    public Long countProcessTemplate(String name, String remark) throws Exception {
        Long result = null;
        try {
            result = processTemplateMapperEx.countsByProcessTemplate(name, remark);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertProcessTemplate(JSONObject obj, HttpServletRequest request) throws Exception {
        ProcessTemplate processTemplate = JSONObject.parseObject(obj.toJSONString(), ProcessTemplate.class);
        int result = 0;
        try {
            processTemplate.setCreateTime(new Date());
            result = processTemplateMapper.insertSelective(processTemplate);
            logService.insertLog("工序",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(processTemplate.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateProcessTemplate(JSONObject obj, HttpServletRequest request) throws Exception {
        ProcessTemplate processTemplate = JSONObject.parseObject(obj.toJSONString(), ProcessTemplate.class);
        int result = 0;
        try {
            processTemplate.setUpdateTime(new Date());
            result = processTemplateMapper.updateByPrimaryKeySelective(processTemplate);
            logService.insertLog("工序",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(processTemplate.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteProcessTemplate(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteProcessTemplateByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcessTemplate(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteProcessTemplateByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcessTemplateByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<ProcessTemplate> list = getProcessTemplateListByIds(ids);
        for (ProcessTemplate processTemplate : list) {
            sb.append("[").append(processTemplate.getName()).append("]");
        }
        logService.insertLog("工序", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        //校验通过执行删除操作
        try {
            result = processTemplateMapperEx.batchDeleteProcessTemplateByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) throws Exception {
        ProcessTemplateExample example = new ProcessTemplateExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<ProcessTemplate> list = null;
        try {
            list = processTemplateMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

}
