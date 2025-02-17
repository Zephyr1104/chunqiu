package com.jsh.erp.service.dishPackage;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DishPackageMapper;
import com.jsh.erp.datasource.mappers.DishPackageMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.foodCategory.FoodCategoryService;
import com.jsh.erp.service.log.LogService;
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
public class DishPackageService {
    private Logger logger = LoggerFactory.getLogger(DishPackageService.class);

    @Resource
    private DishPackageMapper dishPackageMapper;

    @Resource
    private DishPackageMapperEx dishPackageMapperEx;

    @Resource
    private FoodCategoryService foodCategoryService;

    @Resource
    private LogService logService;


    public DishPackage getDishPackage(Long id) throws Exception {
        DishPackage result = null;
        try {
            result = dishPackageMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<DishPackage> getDishPackageListById(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<DishPackage> list = new ArrayList<>();
        try {
            DishPackageExample example = new DishPackageExample();
            example.createCriteria().andIdIn(idList);
            list = dishPackageMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishPackage> getAllList() throws Exception {
        DishPackageExample example = new DishPackageExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishPackage> list = null;
        try {
            list = dishPackageMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishPackageEx> select(String name, Integer mealType, Integer offset, Integer rows) {
        List<DishPackageEx> list = null;
        try {
            list = dishPackageMapperEx.selectByConditionDishPackage(name, mealType, offset, rows);
            if (null != list) {
                for (DishPackageEx ex : list) {
                    if (ex.getCreateTime() != null) {
                        ex.setCreateTimeStr(Tools.getCenternTime(ex.getCreateTime()));
                    }
                    if (ex.getUpdateTime() != null) {
                        ex.setUpdateTimeStr(Tools.getCenternTime(ex.getUpdateTime()));
                    }
                    // 处理一下dish_details的数据
                    if (ex.getDishDetails() != null && ex.getDishDetails() != ""){
                        String dishDetailsStr = "";
                        List<FoodCategory> foodCategoryList = foodCategoryService.getFoodCategoryListByIds(ex.getDishDetails());
                        for (FoodCategory foodCategory : foodCategoryList) {
                            if (foodCategory != null) {
                                dishDetailsStr += foodCategory.getName() + " ";
                            }
                        }
                        ex.setDishDetailStr(dishDetailsStr);
                    }
                }

            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(String name, Integer mealType) throws Exception {
        Long result = null;
        try {
            result = dishPackageMapperEx.countsByDishPackage(name, mealType);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertDishPackage(JSONObject obj, HttpServletRequest request) throws Exception {
        DishPackage dishPackage = JSONObject.parseObject(obj.toJSONString(), DishPackage.class);
        int result = 0;
        try {
            dishPackage.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = dishPackageMapper.insertSelective(dishPackage);
            // 记录日志
            logService.insertLog("[业务处理]-[新增套餐信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(dishPackage.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDishPackage(JSONObject obj, HttpServletRequest request) throws Exception {
        DishPackage dishPackage = JSONObject.parseObject(obj.toJSONString(), DishPackage.class);
        int result = 0;
        try {
            dishPackage.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            result = dishPackageMapper.updateByPrimaryKeySelective(dishPackage);
            // 记录日志
            logService.insertLog("[业务处理]-[更新套餐信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(dishPackage.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteDishPackage(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteDishPackageByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishPackage(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteDishPackageByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishPackageByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        try {
            result = dishPackageMapperEx.batchDeleteDishPackageByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsPackageExist(Long id, String name) throws Exception {
        DishPackageExample example = new DishPackageExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishPackage> list = null;
        try {
            list = dishPackageMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

}
