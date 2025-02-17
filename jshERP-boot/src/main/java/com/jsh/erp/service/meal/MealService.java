package com.jsh.erp.service.meal;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DepotItemMapperEx;
import com.jsh.erp.datasource.mappers.MealMapper;
import com.jsh.erp.datasource.mappers.MealMapperEx;
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
 * @author Xiazy
 * @date 2018/12/20 time:16:36
 */
@Service
public class MealService {
    private Logger logger = LoggerFactory.getLogger(MealService.class);

    @Resource
    private MealMapper mealMapper;

    @Resource
    private MealMapperEx mealMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    @Resource
    private DepotItemMapperEx depotItemMapperEx;

    public Meal getMeal(long id) throws Exception {
        Meal result = null;
        try {
            result = mealMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public List<Meal> getMealListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Meal> list = new ArrayList<>();
        try {
            MealExample example = new MealExample();
            example.createCriteria().andIdIn(idList);
            list = mealMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Meal> getMeal() throws Exception {
        MealExample example = new MealExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Meal> list = null;
        try {
            list = mealMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Meal> getAllList() throws Exception {
        MealExample example = new MealExample();
        example.createCriteria().andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort asc, id desc");
        List<Meal> list = null;
        try {
            list = mealMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Meal> select(String name, String remark, int offset, int rows) throws Exception {
        List<Meal> list = null;
        try {
            list = mealMapperEx.selectByConditionMeal(name, remark, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }


    public Long countMeal(String name, String remark) throws Exception {
        Long result = null;
        try {
            result = mealMapperEx.countsByMeal(name, remark);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMeal(JSONObject obj, HttpServletRequest request) throws Exception {
        Meal meal = JSONObject.parseObject(obj.toJSONString(), Meal.class);
        int result = 0;
        try {
            List<Meal> MealList = getMeal();
            if (MealList.size() == 0) {
                meal.setIsDefault(true);
            } else {
                meal.setIsDefault(false);
            }
            meal.setEnabled(true);
            result = mealMapper.insertSelective(meal);
            logService.insertLog("餐次",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(meal.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMeal(JSONObject obj, HttpServletRequest request) throws Exception {
        Meal meal = JSONObject.parseObject(obj.toJSONString(), Meal.class);
        int result = 0;
        try {
            result = mealMapper.updateByPrimaryKeySelective(meal);
            logService.insertLog("餐次",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(meal.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMeal(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteMealByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMeal(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteMealByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMealByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        //校验单据子表	jsh_depot_item
        List<DepotItem> depotItemList = null;
        try {
            depotItemList = depotItemMapperEx.getDepotItemListListByMealIds(idArray);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        if (depotItemList != null && depotItemList.size() > 0) {
            logger.error("异常码[{}],异常提示[{}],参数,DepotIds[{}]",
                    ExceptionConstants.DELETE_FORCE_CONFIRM_CODE, ExceptionConstants.DELETE_FORCE_CONFIRM_MSG, ids);
            throw new BusinessRunTimeException(ExceptionConstants.DELETE_FORCE_CONFIRM_CODE,
                    ExceptionConstants.DELETE_FORCE_CONFIRM_MSG);
        }
        //记录日志
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Meal> list = getMealListByIds(ids);
        for (Meal meal : list) {
            sb.append("[").append(meal.getName()).append("]");
        }
        logService.insertLog("餐次", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo = userService.getCurrentUser();
        //校验通过执行删除操作
        try {
            result = mealMapperEx.batchDeleteMealByIds(new Date(), userInfo == null ? null : userInfo.getId(), idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) throws Exception {
        MealExample example = new MealExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Meal> list = null;
        try {
            list = mealMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateIsDefault(Long mealId) throws Exception {
        int result = 0;
        try {
            //全部取消默认
            Meal allMeal = new Meal();
            allMeal.setIsDefault(false);
            MealExample allExample = new MealExample();
            allExample.createCriteria();
            mealMapper.updateByExampleSelective(allMeal, allExample);
            //给指定餐次设为默认
            Meal meal = new Meal();
            meal.setIsDefault(true);
            MealExample example = new MealExample();
            example.createCriteria().andIdEqualTo(mealId);
            mealMapper.updateByExampleSelective(meal, example);
            logService.insertLog("餐次", BusinessConstants.LOG_OPERATION_TYPE_EDIT + mealId,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            result = 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean status, String ids) throws Exception {
        logService.insertLog("餐次",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> mealIds = StringUtil.strToLongList(ids);
        Meal meal = new Meal();
        meal.setEnabled(status);
        MealExample example = new MealExample();
        example.createCriteria().andIdIn(mealIds);
        int result = 0;
        try {
            result = mealMapper.updateByExampleSelective(meal, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

}
