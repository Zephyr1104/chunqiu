package com.jsh.erp.service.information;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.Information;
import com.jsh.erp.datasource.entities.InformationEx;
import com.jsh.erp.datasource.entities.InformationExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.InformationMapper;
import com.jsh.erp.datasource.mappers.InformationMapperEx;
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
import java.util.Date;
import java.util.List;


@Service
public class InformationService {
    private Logger logger = LoggerFactory.getLogger(InformationService.class);

    @Resource
    private InformationMapper InformationMapper;
    @Resource
    private InformationMapperEx InformationMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;


    public Long countInformation(String name)throws Exception {
        Long result=null;
        try{
            result=InformationMapperEx.countsByInformation(name);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<InformationEx> select(String name, int offset, int rows) throws Exception {
        List<InformationEx> list = null;
        try {
            list = InformationMapperEx.selectByConditionInformation(name, offset, rows);
            for(InformationEx ie: list){
                //负责人
                User user = userService.getUser(Long.parseLong(ie.getHead()));
                ie.setHeadStr(user.getUsername());
                //央厨类型
                String kitchenTypeStr = "";
                if(1 == ie.getKitchenType()) {
                    kitchenTypeStr = "全能央厨";
                } else if(2 == ie.getKitchenType()){
                    kitchenTypeStr = "热链央厨";
                }else if(3 == ie.getKitchenType()){
                    kitchenTypeStr = "冷链央厨";
                } else if(4 == ie.getKitchenType()){
                    kitchenTypeStr = "冷热混合";
                }else if(5 == ie.getKitchenType()){
                    kitchenTypeStr = "净菜央厨";
                }else{
                    kitchenTypeStr = "未知央厨";
                }
                ie.setKitchenTypeStr(kitchenTypeStr);
                //菜谱终端
                String recipeTerminalStr = "";
                if(1 == ie.getRecipeTerminal()) {
                    recipeTerminalStr = "终端模式";
                } else if(2 == ie.getRecipeTerminal()){
                    recipeTerminalStr = "菜谱分组模式";
                }else {
                    recipeTerminalStr = "未知模式";
                }
                ie.setRecipeTerminalStr(recipeTerminalStr);
                //包装线
                String packagingLineStr = "";
                if(1 == ie.getPackagingLine()) {
                    packagingLineStr = "依终端";
                } else if(2 == ie.getPackagingLine()){
                    packagingLineStr = "依套餐类型";
                }else {
                    packagingLineStr = "未知包装线";
                }
                ie.setPackagingLineStr(packagingLineStr);
            }

        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Information getInformation(long id)throws Exception {
        Information result=null;
        try{
            result=InformationMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Information> getAllList() throws Exception {
        InformationExample example = new InformationExample();
        example.setOrderByClause("id desc");
        List<Information> list = null;
        try {
            list = InformationMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Information> getInformation()throws Exception {
        InformationExample example = new InformationExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Information> list=null;
        try{
            list=InformationMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertInformation(JSONObject obj, HttpServletRequest request)throws Exception {
        Date currentDate = new Date();
        //获取当前用户信息
        User userInfo = userService.getCurrentUser();
        InformationEx informationEx = JSONObject.parseObject(obj.toJSONString(), InformationEx.class);
        informationEx.setCreateDate(currentDate);
        informationEx.setUserId(userInfo == null ? null : userInfo.getId());
        informationEx.setKitchenType(Integer.valueOf(informationEx.getKitchenTypeStr()));
        informationEx.setRecipeTerminal(Long.valueOf(informationEx.getRecipeTerminalStr()));
        informationEx.setPackagingLine(Long.valueOf(informationEx.getPackagingLineStr()));
        informationEx.setHead(informationEx.getHeadStr());
        int result =0;
        try{
            result=InformationMapper.insertSelective(informationEx);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateInformation(JSONObject obj, HttpServletRequest request)throws Exception {
        Date currentDate = new Date();
        InformationEx informationEx = JSONObject.parseObject(obj.toJSONString(), InformationEx.class);
        informationEx.setCreateDate(currentDate);
        //获取当前用户信息
        User userInfo = userService.getCurrentUser();
        informationEx.setUserId(userInfo == null ? null : userInfo.getId());
        int result =0;
        try{
            result=InformationMapper.updateByPrimaryKeySelective(informationEx);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteInformation(Long id, HttpServletRequest request)throws Exception {
        int result =0;
        try{
            result=InformationMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteInformation(String ids, HttpServletRequest request)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        InformationExample example = new InformationExample();
        example.createCriteria().andIdIn(idList);
        int result =0;
        try{
            result=InformationMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long informationID, String name)throws Exception {
        InformationExample example = new InformationExample();
        example.createCriteria().andIdNotEqualTo(informationID).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Information> list =null;
        try{
            list=InformationMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateIsDefault(Long InformationId) throws Exception {
        int result = 0;
        try {
            //全部取消默认
            Information allInformation = new Information();
            allInformation.setIsDefault(false);
            InformationExample InformationExample = new InformationExample();
            InformationExample.createCriteria();
            InformationMapper.updateByExampleSelective(allInformation, InformationExample);
            //给指定央厨设为默认
            Information Information = new Information();
            Information.setIsDefault(true);
            InformationExample example = new InformationExample();
            example.createCriteria().andIdEqualTo(InformationId);
            InformationMapper.updateByExampleSelective(Information, example);
            logService.insertLog("央厨信息", BusinessConstants.LOG_OPERATION_TYPE_EDIT + InformationId,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            result = 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean status, String ids) throws Exception {
        logService.insertLog("央厨信息",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> InformationIds = StringUtil.strToLongList(ids);
        Information Information = new Information();
        Information.setEnabled(status);
        InformationExample example = new InformationExample();
        example.createCriteria().andIdIn(InformationIds);
        int result = 0;
        try {
            result = InformationMapper.updateByExampleSelective(Information, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

   }
