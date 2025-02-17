package com.jsh.erp.service.foodCategory;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.FoodCategory;
import com.jsh.erp.datasource.entities.FoodCategoryExample;
import com.jsh.erp.datasource.mappers.FoodCategoryMapper;
import com.jsh.erp.datasource.mappers.FoodCategoryMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xiazy
 * @date 2024年8月1日
 */
@Service
public class FoodCategoryService {
    private Logger logger = LoggerFactory.getLogger(FoodCategoryService.class);

    @Resource
    private FoodCategoryMapper foodCategoryMapper;

    @Resource
    private FoodCategoryMapperEx foodCategoryMapperEx;

    @Resource
    private LogService logService;

    public FoodCategory getFoodCategory(Long id) throws Exception {
        FoodCategory result = null;
        try {
            result = foodCategoryMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<FoodCategory> getFoodCategoryListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<FoodCategory> list = new ArrayList<>();
        try {
            FoodCategoryExample example = new FoodCategoryExample();
            example.createCriteria().andIdIn(idList);
            list = foodCategoryMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<FoodCategory> getFoodCategory() throws Exception {
        FoodCategoryExample example = new FoodCategoryExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<FoodCategory> list = null;
        try {
            list = foodCategoryMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<FoodCategory> getAllList() throws Exception {
        FoodCategoryExample example = new FoodCategoryExample();
        example.createCriteria().andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort asc, id desc");
        List<FoodCategory> list = null;
        try {
            list = foodCategoryMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<FoodCategory> select(String name, String remark, int offset, int rows) throws Exception {
        List<FoodCategory> list = null;
        try {
            list = foodCategoryMapperEx.selectByConditionFoodCat(name, remark, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countFoodCategory(String name, String remark) throws Exception {
        Long result = null;
        try {
            result = foodCategoryMapperEx.countsByFoodCat(name, remark);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertFoodCategory(JSONObject obj, HttpServletRequest request) throws Exception{
        FoodCategory foodCategory = JSONObject.parseObject(obj.toJSONString(), FoodCategory.class);
        int result = 0;
        try{
            foodCategory.setEnabled(true);
            foodCategory.setEnabledTime(new Timestamp(System.currentTimeMillis()));
            foodCategory.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = foodCategoryMapper.insertSelective(foodCategory);
            // 记录日志
            logService.insertLog("菜品类型",new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(foodCategory.getName()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateFoodCategory(JSONObject obj, HttpServletRequest request) throws Exception{
        FoodCategory foodCategory = JSONObject.parseObject(obj.toJSONString(), FoodCategory.class);
        int result = 0;
        try{
            foodCategory.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            result = foodCategoryMapper.updateByPrimaryKeySelective(foodCategory);
            // 记录日志
            logService.insertLog("菜品类型",new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(foodCategory.getName()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteFoodCategory(Long id, HttpServletRequest request) throws Exception{
        return batchDeleteFoodCategoryByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFoodCategory(String ids, HttpServletRequest request) throws Exception{
        return batchDeleteFoodCategoryByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteFoodCategoryByIds(String ids) throws Exception{
        int result = 0;
        String [] idArray = ids.split(",");
        try{
            result = foodCategoryMapperEx.batchDeleteFoodCategoryByIds(new Date(),idArray);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) throws Exception{
        FoodCategoryExample example = new FoodCategoryExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<FoodCategory> list = null;
        try{
            list = foodCategoryMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetEnable(Boolean enable, String ids) throws Exception{
        logService.insertLog("菜品类型",new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).append("启用/禁用").toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> idList = StringUtil.strToLongList(ids);
        FoodCategory foodCategory = new FoodCategory();
        foodCategory.setEnabledTime(new Timestamp(System.currentTimeMillis()));
        foodCategory.setEnabled(enable);
        FoodCategoryExample example = new FoodCategoryExample();
        example.createCriteria().andIdIn(idList);
        int result = 0;
        try{
            result = foodCategoryMapper.updateByExampleSelective(foodCategory, example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }




}
