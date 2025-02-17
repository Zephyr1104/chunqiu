package com.jsh.erp.service.processor;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.ProcessorMapper;
import com.jsh.erp.datasource.mappers.ProcessorMapperEx;
import com.jsh.erp.datasource.vo.TreeNode;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
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
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:10
 */
@Service
public class ProcessorService {
    private Logger logger = LoggerFactory.getLogger(ProcessorService.class);

    @Resource
    private ProcessorMapper processorMapper;
    @Resource
    private ProcessorMapperEx processorMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    public Processor getProcessor(long id) throws Exception {
        return processorMapper.selectByPrimaryKey(id);
    }

    public List<Processor> getProcessorListByIds(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Processor> list = new ArrayList<>();
        try{
            ProcessorExample example = new ProcessorExample();
            example.createCriteria().andIdIn(idList);
            list = processorMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertProcessor(JSONObject obj, HttpServletRequest request)throws Exception {
        Processor processor = JSONObject.parseObject(obj.toJSONString(), Processor.class);
        processor.setCreateTime(new Date());
        processor.setUpdateTime(new Date());
        int result=0;
        try{
            result=processorMapper.insertSelective(processor);
            logService.insertLog("工厂模型",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(processor.getProcessorAbr()).toString(),request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateProcessor(JSONObject obj, HttpServletRequest request)throws Exception {
        Processor processor = JSONObject.parseObject(obj.toJSONString(), Processor.class);
        processor.setUpdateTime(new Date());
        int result=0;
        try{
            result= processorMapperEx.editProcessor(processor);
            logService.insertLog("工厂模型",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(processor.getProcessorAbr()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteProcessor(Long id, HttpServletRequest request)throws Exception {
        return batchDeleteProcessorByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcessor(String ids, HttpServletRequest request)throws Exception {
        return batchDeleteProcessorByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteProcessorByIds(String ids) throws Exception{
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Processor> list = getProcessorListByIds(ids);
        for(Processor processor: list){
            sb.append("[").append(processor.getProcessorAbr()).append("]");
        }
        logService.insertLog("工厂模型", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo=userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        List <Processor> proceList = processorMapperEx.getProcessorByParentIds(idArray);
        if(proceList!=null && proceList.size()>0) {
            //如果存在子机构则不能删除
            logger.error("异常码[{}],异常提示[{}]",
                    ExceptionConstants.ORGANIZATION_CHILD_NOT_ALLOWED_DELETE_CODE,ExceptionConstants.ORGANIZATION_CHILD_NOT_ALLOWED_DELETE_MSG);
            throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_CHILD_NOT_ALLOWED_DELETE_CODE,
                    ExceptionConstants.ORGANIZATION_CHILD_NOT_ALLOWED_DELETE_MSG);
        } else {
            result=processorMapperEx.batchDeleteProcessorByIds(
                    new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name)throws Exception {
        ProcessorExample example = new ProcessorExample();
        example.createCriteria().andIdNotEqualTo(id).andProcessorAbrEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Processor> list=null;
        try{
            list= processorMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    public List<TreeNode> getProcessorTree(Long id)throws Exception {
        List<TreeNode> list=null;
        try{
            list=processorMapperEx.getNodeTree(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Processor> findById(Long id) throws Exception{
        ProcessorExample example = new ProcessorExample();
        example.createCriteria().andIdEqualTo(id);
        List<Processor> list=null;
        try{
            list=processorMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Processor> findByParentId(Long parentId)throws Exception {
        List<Processor> list=null;
        if(parentId!=null){
            ProcessorExample example = new ProcessorExample();
            example.createCriteria().andIdEqualTo(parentId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
            try{
                list=processorMapper.selectByExample(example);
            }catch(Exception e){
                JshException.readFail(logger, e);
            }
        }
        return list;
    }

    public List<Processor> findByOrgNo(String processorNo)throws Exception {
        ProcessorExample example = new ProcessorExample();
        example.createCriteria().andProcessorNoEqualTo(processorNo).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Processor> list=null;
        try{
            list=processorMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }
    /**
     * create by: cjl
     * description:
     *  检查机构编号是否已经存在
     * create time: 2019/3/7 10:01
     * @Param: orgNo
     * @return void
     */
    public void checkProcessorNoIsExists(String processorNo,Long id)throws Exception {
        List<Processor> proceList=findByOrgNo(processorNo);
        if(proceList!=null&&proceList.size()>0){
            if(proceList.size()>1){
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,processorNo);
                //获取的数据条数大于1，机构编号已存在
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
            if(id!=null){
                if(!proceList.get(0).getId().equals(id)){
                    //数据条数等于1，但是和编辑的数据的id不相同
                    logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}],id[{}]",
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,processorNo,id);
                    throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
                }
            }else{
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,processorNo);
                //数据条数等于1，但此时是新增
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
        }

    }

    /**
     * 根据父级id递归获取子集组织id
     * @return
     */
    public List<Long> getProcessorIdByParentId(Long orgId) {
        List<Long> idList = new ArrayList<>();
        ProcessorExample example = new ProcessorExample();
        example.createCriteria().andIdEqualTo(orgId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Processor> proceList = processorMapper.selectByExample(example);
        if(proceList!=null && proceList.size()>0) {
            idList.add(orgId);
            getProcessorIdByParentNo(idList, proceList.get(0).getId());
        }
        return idList;
    }

    /**
     * 根据组织编号递归获取下级编号
     * @param id
     * @return
     */
    public void getProcessorIdByParentNo(List<Long> idList,Long id) {
        ProcessorExample example = new ProcessorExample();
        example.createCriteria().andParentIdEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Processor> proceList = processorMapper.selectByExample(example);
        if(proceList!=null && proceList.size()>0) {
            for(Processor o: proceList) {
                idList.add(o.getId());
                getProcessorIdByParentNo(idList, o.getId());
            }
        }
    }
}
