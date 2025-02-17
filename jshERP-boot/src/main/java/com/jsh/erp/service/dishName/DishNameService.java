package com.jsh.erp.service.dishName;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DishNameMapper;
import com.jsh.erp.datasource.mappers.DishNameMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.foodCategory.FoodCategoryService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
public class DishNameService {

    private Logger logger = LoggerFactory.getLogger(DishNameService.class);


    @Resource
    private DishNameMapper dishNameMapper;

    @Resource
    private DishNameMapperEx dishNameMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private FoodCategoryService foodCategoryService;

    @Resource
    private LogService logService;


    public DishName getDishName(Long id) throws Exception {
        DishName result = null;
        try {
            result = dishNameMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<DishName> getDishNameListById(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<DishName> list = new ArrayList<>();
        try {
            DishNameExample example = new DishNameExample();
            example.createCriteria().andIdIn(idList);
            list = dishNameMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishName> getAllList() throws Exception {
        DishNameExample example = new DishNameExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishName> list = null;
        try {
            list = dishNameMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishNameEx> select(String name, String allergen, Integer offset, Integer rows) throws Exception {
        List<DishNameEx> list = null;
        try {
            list = dishNameMapperEx.selectByConditionDishName(name, allergen, offset, rows);
            if(list!=null && list.size()>0){
                list.forEach(d -> {
                    FoodCategory foodCategory = null;
                    try {
                        if (d.getNameType()!= null) {
                            foodCategory = foodCategoryService.getFoodCategory(Long.valueOf(d.getNameType()));
                            d.setNameTypeName(foodCategory.getName());
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(String name, String allergen) throws Exception {
        Long result = null;
        try {
            result = dishNameMapperEx.countsByDishName(name, allergen);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertDishName(JSONObject obj, HttpServletRequest request) throws Exception {
        DishName dishName = JSONObject.parseObject(obj.toJSONString(), DishName.class);
        int result = 0;
        try {
            User userInfo = userService.getCurrentUser();
            dishName.setCreator(userInfo == null ? null : userInfo.getId());
            dishName.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = dishNameMapper.insertSelective(dishName);
            // 记录日志
            logService.insertLog("[业务处理]-添加菜品名称", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(dishName.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDishName(JSONObject obj, HttpServletRequest request) throws Exception {
        DishName dishName = JSONObject.parseObject(obj.toJSONString(), DishName.class);
        int result = 0;
        try {
            dishName.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            result = dishNameMapper.updateByPrimaryKeySelective(dishName);
            // 记录日志
            logService.insertLog("[业务处理]-修改菜品名称", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(dishName.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteDishName(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteDishNameByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishName(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteDishNameByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishNameByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        try {
            result = dishNameMapperEx.batchDeleteDishNameByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) throws Exception {
        DishNameExample example = new DishNameExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishName> list = null;
        try {
            list = dishNameMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

}
