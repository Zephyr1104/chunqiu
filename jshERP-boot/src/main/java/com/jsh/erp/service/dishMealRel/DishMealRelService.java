package com.jsh.erp.service.dishMealRel;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DishMealRelMapper;
import com.jsh.erp.datasource.mappers.DishMealRelMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.dishName.DishNameService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.meal.MealService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishMealRelService {
    private Logger logger = LoggerFactory.getLogger(DishMealRelService.class);

    @Resource
    private DishMealRelMapper dishMealRelMapper;
    @Resource
    private DishMealRelMapperEx dishMealRelMapperEx;

    @Resource
    private DishNameService dishNameService;
    @Resource
    private MealService mealService;

    @Resource
    private LogService logService;

    public DishMealRel getDishMealRel(Long id) throws Exception {
        DishMealRel result = null;
        try {
            result = dishMealRelMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<DishMealRel> getDishMealRelListById(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<DishMealRel> list = new ArrayList<>();
        try {
            DishMealRelExample example = new DishMealRelExample();
            example.createCriteria().andIdIn(idList);
            list = dishMealRelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishMealRel> getAllList() throws Exception {
        DishMealRelExample example = new DishMealRelExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishMealRel> list = null;
        try {
            list = dishMealRelMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishMealRelEx> select(Integer dishNameId,Integer diningPrice, Integer mealId,
                                      String beginTime, String endTime, Integer offset, Integer rows) {
        List<DishMealRelEx> list = null;
        if (beginTime != null && endTime != null) {
            beginTime = beginTime + " 00:00:00";
            endTime = endTime + " 23:59:59";
        }
        try {
            list = dishMealRelMapperEx.select(dishNameId,diningPrice, mealId, beginTime, endTime, offset, rows);
            if (list == null) {
                return list;
            }
            for (DishMealRelEx dmr : list) {
                if (dmr.getDiningDate() != null) {
                    dmr.setDiningDateStr(Tools.getCenternTime(dmr.getDiningDate()));
                    // 计算出星期几
                    dmr.setWeekDay(Tools.getWeekDay(dmr.getDiningDate()));
                }
                if (dmr.getMealId() != null) {
                    Meal meal = mealService.getMeal(dmr.getMealId());
                    if (meal != null) {
                        dmr.setMealName(meal.getName());
                    }
                }
                if (dmr.getDishNameId() != null) {
                    String dishNameDetail = "";
                    List<DishName> dishNameList = dishNameService.getDishNameListById(dmr.getDishNameId());
                    for (DishName dishName : dishNameList) {
                        if (dishName != null) {
                            dishNameDetail += dishName.getName() + " ";
                        }
                    }
                    dmr.setDishName(dishNameDetail);
                }
                if (dmr.getCreateTime() != null) {
                    dmr.setCreateTimeStr(Tools.getCenternTime(dmr.getCreateTime()));
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(Integer price, Integer mealId,
                            String beginTime, String endTime) {
        Long result = null;
        try {
            result = dishMealRelMapperEx.countSelect(price, mealId, beginTime, endTime);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        DishMealRel dishMealRel = JSONObject.parseObject(obj.toJSONString(), DishMealRel.class);
        int result = 0;
        try {
            dishMealRel.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = dishMealRelMapper.insertSelective(dishMealRel);
            // 记录日志
            logService.insertLog("[业务处理]-[新增菜谱与餐次关系]", BusinessConstants.LOG_OPERATION_TYPE_ADD, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        DishMealRel dishMealRel = JSONObject.parseObject(obj.toJSONString(), DishMealRel.class);
        int result = 0;
        try {
            result = dishMealRelMapper.updateByPrimaryKeySelective(dishMealRel);
            // 记录日志
            logService.insertLog("[业务处理]-[更新菜谱与餐次关系]", BusinessConstants.LOG_OPERATION_TYPE_EDIT, request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDelete(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        try {
            result = dishMealRelMapperEx.batchDeleteByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }


}
