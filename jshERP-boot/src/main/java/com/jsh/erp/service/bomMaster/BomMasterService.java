package com.jsh.erp.service.bomMaster;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.datasource.entities.BomMasterEx;
import com.jsh.erp.datasource.entities.BomMasterExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.BomMasterMapper;
import com.jsh.erp.datasource.mappers.BomMasterMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.user.UserService;
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
public class BomMasterService {

    private Logger logger = LoggerFactory.getLogger(BomMasterService.class);

    @Resource
    private BomMasterMapper bomMasterMapper;

    @Resource
    private BomMasterMapperEx bomMasterMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    public BomMaster getBomMaster(Long id) throws Exception {
        BomMaster result = null;
        try {
            result = bomMasterMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    /**
     * 根据ID列表获取BomMaster列表
     *
     * @param ids ID列表，多个ID之间用逗号分隔
     * @return BomMaster列表
     */
    public List<BomMaster> getBomMasterListByIds(String ids) {
        // 将字符串类型的ids转换为Long类型的列表
        List<Long> idList = StringUtil.strToLongList(ids);
        // 创建一个空的BomMaster列表
        List<BomMaster> list = new ArrayList<>();
        try {
            // 创建一个BomMasterExample对象
            BomMasterExample example = new BomMasterExample();
            // 创建一个Criteria对象
            example.createCriteria().andIdIn(idList);
            // 根据Criteria对象查询BomMaster列表
            list = bomMasterMapper.selectByExample(example);
        } catch (Exception e) {
            // 捕获异常并记录错误信息
            JshException.readFail(logger, e);
        }
        // 返回查询到的BomMaster列表
        return list;
    }


    public List<BomMaster> getAllList() {
        BomMasterExample example = new BomMasterExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<BomMaster> list = null;
        try {
            list = bomMasterMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<BomMasterEx> select(String name, Integer offset, Integer rows) {
        List<BomMasterEx> list = null;
        try {
            list = bomMasterMapperEx.selectByCondition(name, offset, rows);
            if (null != list && list.size() > 0) {
                for (BomMasterEx ex : list) {
                    if (ex.getCreateTime() != null) {
                        ex.setCreateTimeStr(Tools.getCenternTime(ex.getCreateTime()));
                    }
                    if (ex.getUpdateTime() != null) {
                        ex.setUpdateTimeStr(Tools.getCenternTime(ex.getUpdateTime()));
                    }
                }
            }
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(String name) {
        Long result = null;
        try {
            result = bomMasterMapperEx.countsSelect(name);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertBomMaster(JSONObject obj, HttpServletRequest request) {
        BomMaster bomMaster = JSONObject.parseObject(obj.toJSONString(), BomMaster.class);
        int result = 0;
        try {
            User userInfo = userService.getCurrentUser();
            bomMaster.setCreator(userInfo == null ? null : userInfo.getId());
            bomMaster.setCreateTime(new Timestamp(System.currentTimeMillis()));
            result = bomMasterMapper.insertSelective(bomMaster);
            // 记录日志
            logService.insertLog("[业务处理-新增主物料BOM信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(bomMaster.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateBomMaster(JSONObject obj, HttpServletRequest request) {
        BomMaster bomMaster = JSONObject.parseObject(obj.toJSONString(), BomMaster.class);
        int result = 0;
        try {
            bomMaster.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            result = bomMasterMapper.updateByPrimaryKeySelective(bomMaster);
            // 记录日志
            logService.insertLog("[业务处理-更新主物料BOM信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(bomMaster.getName()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int deleteBomMaster(Long id, HttpServletRequest request) {
        return batchDeleteBomMasterByIds(id.toString());
    }

    public int batchDeleteBomMaster(String ids, HttpServletRequest request) {
        return batchDeleteBomMasterByIds(ids);
    }

    public int batchDeleteBomMasterByIds(String ids) {
        int resut = 0;
        String[] idArray = ids.split(",");
        try {
            resut = bomMasterMapperEx.batchDeleteByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return resut;
    }

    public int checkIsNameExist(Long id, String name) {
        BomMasterExample example = new BomMasterExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(name).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<BomMaster> list = null;
        try {
            list = bomMasterMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }


}
