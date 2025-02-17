package com.jsh.erp.service.dishGroup;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DishGroupMapper;
import com.jsh.erp.datasource.mappers.DishGroupMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.utils.StringUtil;
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
public class DishGroupService {

    private Logger logger = LoggerFactory.getLogger(DishGroupService.class);

    @Resource
    private DishGroupMapper dishGroupMapper;

    @Resource
    private DishGroupMapperEx dishGroupMapperEx;

    @Resource
    private LogService logService;

    public DishGroup getDishGroup(Long id) throws Exception {
        DishGroup result = null;
        try {
            result = dishGroupMapper.selectByPrimaryKey(id);
        } catch(Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<DishGroup> getDishGroupListByIds(String ids) throws Exception{
        List<Long> idList = StringUtil.strToLongList(ids);
        List<DishGroup> list = new ArrayList<>();
        try {
            DishGroupExample example = new DishGroupExample();
            example.createCriteria().andIdIn(idList);
            list = dishGroupMapper.selectByExample(example);
        } catch(Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishGroup> getAllList() throws Exception {
        DishGroupExample example = new DishGroupExample();
        example.createCriteria().andDeleteFlagEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishGroup> list = null;
        try {
            list = dishGroupMapper.selectByExample(example);
        } catch(Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<DishGroup> select(String name,Integer offset , Integer rows)throws Exception{
        List<DishGroup> list = null;
        try{
            list = dishGroupMapperEx.selectByConditionDishGroup(name, offset, rows);
        }catch (Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(String name) throws Exception {
        Long result = null;
        try {
            result = dishGroupMapperEx.countsByDishGroup(name);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertDishGroup(JSONObject obj, HttpServletRequest request) throws Exception {
        DishGroup dishGroup = JSONObject.parseObject(obj.toJSONString(), DishGroup.class);
        int result = 0;
        try {
            dishGroup.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = dishGroupMapper.insertSelective(dishGroup);
            // 记录日志
            logService.insertLog("[业务处理]-添加菜谱分组", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(dishGroup.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDishGroup(JSONObject obj, HttpServletRequest request) throws Exception {
        DishGroup dishGroup = JSONObject.parseObject(obj.toJSONString(), DishGroup.class);
        int result = 0;
        try {
            result = dishGroupMapper.updateByPrimaryKeySelective(dishGroup);
            // 记录日志
            logService.insertLog("[业务处理]-修改菜谱分组", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(dishGroup.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteDishGroup(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteDishGroupByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishGroup(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteDishGroupByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDishGroupByIds(String ids) throws Exception {
        int result = 0;
        String[] idArray = ids.split(",");
        try {
            result = dishGroupMapperEx.batchDeleteDishGroupByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name) throws Exception {
        DishGroupExample example = new DishGroupExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<DishGroup> list = null;
        try {
            list = dishGroupMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

}
