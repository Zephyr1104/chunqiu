package com.jsh.erp.service.restaurant;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.RestaurantMapper;
import com.jsh.erp.datasource.mappers.RestaurantMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.information.InformationService;
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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class RestaurantService {
    private Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    @Resource
    private RestaurantMapper restaurantMapper;
    @Resource
    private RestaurantMapperEx restaurantMapperEx;
    @Resource
    private LogService logService;
    @Resource
    private UserService userService;
    @Resource
    private InformationService informationService;


    public Long countRestaurant(String name)throws Exception {
        Long result=null;
        try{
            result=restaurantMapperEx.countsByRestaurant(name);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<RestaurantEx> select(String name, int offset, int rows) throws Exception {
        List<RestaurantEx> list = null;
        try {
            list = restaurantMapperEx.selectByConditionRestaurant(name, offset, rows);
            for(RestaurantEx re: list){
                //负责人
                User user = userService.getUser(Long.parseLong(re.getHead()));
                re.setHeadStr(user.getUsername());
                //配送央厨
                Information information = informationService.getInformation(re.getId());
                re.setCentralKitchenStr(information.getName());
                //终端类型
                String terminalTypeStr = "";
                if(1 == re.getTerminalType()) {
                    terminalTypeStr = "单位承包型";
                } else if(2 == re.getTerminalType()){
                    terminalTypeStr = "园区型";
                }else if(3 == re.getTerminalType()){
                    terminalTypeStr = "加盟型";
                }else if(4 == re.getTerminalType()){
                    terminalTypeStr = "食堂转包型";
                }else {
                    terminalTypeStr = "未知类型";
                }
                re.setTerminalTypeStr(terminalTypeStr);
                //周菜谱菜式
                String menuModeStr = "";
                if("1".equals(re.getMenuMode())) {
                    menuModeStr = "单品";
                } else if("2".equals(re.getMenuMode()) ){
                    menuModeStr = "套餐";
                }else {
                    menuModeStr = "未知模式";
                }
                re.setMenuModeStr(menuModeStr);
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Restaurant getRestaurant(long id)throws Exception {
        Restaurant result=null;
        try{
            result=restaurantMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Restaurant> getAllList() throws Exception {
        RestaurantExample example = new RestaurantExample();
        example.setOrderByClause("id desc");
        List<Restaurant> list = null;
        try {
            list = restaurantMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Restaurant> getRestaurant()throws Exception {
        RestaurantExample example = new RestaurantExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Restaurant> list=null;
        try{
            list=restaurantMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertRestaurant(JSONObject obj, HttpServletRequest request)throws Exception {
        RestaurantEx restaurantEx = JSONObject.parseObject(obj.toJSONString(), RestaurantEx.class);
        Date currentDate = new Date();
        //获取当前用户信息
        User userInfo = userService.getCurrentUser();
        restaurantEx.setUserId(userInfo == null ? null : userInfo.getId());
        restaurantEx.setCreateDate(currentDate);
        restaurantEx.setHead(restaurantEx.getHeadStr());
        restaurantEx.setCentralKitchen(Integer.valueOf(restaurantEx.getCentralKitchenStr()));
        restaurantEx.setTerminalType(Integer.valueOf(restaurantEx.getTerminalTypeStr()));
        restaurantEx.setMenuMode(restaurantEx.getMenuModeStr());
        int result =0;
        try{
            result=restaurantMapper.insertSelective(restaurantEx);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateRestaurant(JSONObject obj, HttpServletRequest request)throws Exception {
        RestaurantEx restaurantEx = JSONObject.parseObject(obj.toJSONString(), RestaurantEx.class);
        Date currentDate = new Date();
        restaurantEx.setCreateDate(currentDate);
        //获取当前用户信息
        User userInfo = userService.getCurrentUser();
        restaurantEx.setUserId(userInfo == null ? null : userInfo.getId());
        int result =0;
        try{
            result=restaurantMapper.updateByPrimaryKeySelective(restaurantEx);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteRestaurant(Long id, HttpServletRequest request)throws Exception {
        int result =0;
        try{
            result=restaurantMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteRestaurant(String ids, HttpServletRequest request)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        RestaurantExample example = new RestaurantExample();
        example.createCriteria().andIdIn(idList);
        int result =0;
        try{
            result=restaurantMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name)throws Exception {
        RestaurantExample example = new RestaurantExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Restaurant> list =null;
        try{
            list=restaurantMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateIsDefault(Long restaurantId) throws Exception {
        int result = 0;
        try {
            //全部取消默认
            Restaurant allrestaurant = new Restaurant();
            allrestaurant.setIsDefault(false);
            RestaurantExample restaurantExample = new RestaurantExample();
            restaurantExample.createCriteria();
            restaurantMapper.updateByExampleSelective(allrestaurant, restaurantExample);
            //给指定餐厅设为默认
            Restaurant restaurant = new Restaurant();
            restaurant.setIsDefault(true);
            RestaurantExample example = new RestaurantExample();
            example.createCriteria().andIdEqualTo(restaurantId);
            restaurantMapper.updateByExampleSelective(restaurant, example);
            logService.insertLog("自营餐厅信息", BusinessConstants.LOG_OPERATION_TYPE_EDIT + restaurantId,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            result = 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean status, String ids) throws Exception {
        logService.insertLog("自营餐厅信息",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> restaurantIds = StringUtil.strToLongList(ids);
        Restaurant restaurant = new Restaurant();
        restaurant.setEnabled(status);
        RestaurantExample example = new RestaurantExample();
        example.createCriteria().andIdIn(restaurantIds);
        int result = 0;
        try {
            result = restaurantMapper.updateByExampleSelective(restaurant, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

}
