package com.jsh.erp.service.menu;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.MenuMapper;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    private Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private LogService logService;

    public Menu getMenu(Long id) throws Exception {
        Menu result = null;
        try {
            result = menuMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Menu> getMenuListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Menu> list = new ArrayList<>();
        try {
            MenuExample example = new MenuExample();
            example.createCriteria().andIdIn(idList);
            list = menuMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Menu> getAllList() throws Exception {
        MenuExample example = new MenuExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort asc,id desc");
        List<Menu> list = null;
        try {
            list = menuMapper.selectByExample(example);
            list.stream().forEach(menu -> {

            });
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMenu(JSONObject obj, HttpServletRequest request) throws Exception {
        Menu menu = JSONObject.parseObject(obj.toJSONString(), Menu.class);
        int result = 0;
        try {
            result = menuMapper.insertSelective(menu);
            logService.insertLog("菜谱",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(menu.getMealDate()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMenu(JSONObject obj, HttpServletRequest request) throws Exception {
        Menu menu = JSONObject.parseObject(obj.toJSONString(), Menu.class);
        int result = 0;
        try {
            result = menuMapper.updateByPrimaryKeySelective(menu);
            logService.insertLog("菜谱",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(menu.getMealDate()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMenu(Long id, HttpServletRequest request) throws Exception {
        int result = 0;
        try {
            result = menuMapper.deleteByPrimaryKey(id);
            logService.insertLog("菜谱",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(id).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name)throws Exception {
        MenuExample example = new MenuExample();
        example.createCriteria().andIdNotEqualTo(id).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Menu> list = null;
        try {
            list = menuMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

}
