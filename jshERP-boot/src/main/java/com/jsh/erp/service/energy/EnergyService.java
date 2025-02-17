package com.jsh.erp.service.energy;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.Energy;
import com.jsh.erp.datasource.entities.EnergyExample;
import com.jsh.erp.datasource.entities.RestaurantExample;
import com.jsh.erp.datasource.entities.User;
import com.jsh.erp.datasource.mappers.DepotItemMapperEx;
import com.jsh.erp.datasource.mappers.EnergyMapper;
import com.jsh.erp.datasource.mappers.EnergyMapperEx;
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
 * @author zzl
 * @date 2024/08/20 time:16:36
 */
@Service
public class EnergyService {
    private Logger logger = LoggerFactory.getLogger(EnergyService.class);

    @Resource
    private EnergyMapper energyMapper;

    @Resource
    private EnergyMapperEx energyMapperEx;

    @Resource
    private UserService userService;

    @Resource
    private LogService logService;

    @Resource
    private DepotItemMapperEx depotItemMapperEx;

    public Energy getEnergy(long id) throws Exception {
        Energy result = null;
        try {
            result = energyMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }


    public List<Energy> getEnergyListByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Energy> list = new ArrayList<>();
        try {
            EnergyExample example = new EnergyExample();
            example.createCriteria().andIdIn(idList);
            list = energyMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Energy> getEnergy() throws Exception {
        EnergyExample example = new EnergyExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Energy> list = null;
        try {
            list = energyMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Energy> getAllList() throws Exception {
        EnergyExample example = new EnergyExample();
        example.createCriteria().andEnabledEqualTo(true).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        example.setOrderByClause("sort asc, id desc");
        List<Energy> list = null;
        try {
            list = energyMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Energy> select(String category, String orgNo, int offset, int rows) throws Exception {
        List<Energy> list = null;
        try {
            list = energyMapperEx.selectByConditionEnergy(category, orgNo, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }


    public Long countEnergy(String name, String remark) throws Exception {
        Long result = null;
        try {
            result = energyMapperEx.countsByEnergy(name, remark);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertEnergy(JSONObject obj, HttpServletRequest request) throws Exception {
        Energy energy = JSONObject.parseObject(obj.toJSONString(), Energy.class);
        int result = 0;
        try {
            List<Energy> EnergyList = getEnergy();
            if (EnergyList.size() == 0) {
                energy.setIsDefault(true);
            } else {
                energy.setIsDefault(false);
            }
            energy.setEnabled(true);
            result = energyMapper.insertSelective(energy);
            logService.insertLog("能效",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(energy.getCategory()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateEnergy(JSONObject obj, HttpServletRequest request) throws Exception {
        Energy energy = JSONObject.parseObject(obj.toJSONString(), Energy.class);
        int result = 0;
        try {
            result = energyMapper.updateByPrimaryKeySelective(energy);
            logService.insertLog("能效",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(energy.getCategory()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteEnergy(Long id, HttpServletRequest request) throws Exception {
        return batchDeleteEnergyByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteEnergy(String ids, HttpServletRequest request) throws Exception {
        return batchDeleteEnergyByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteEnergyByIds(String ids) throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        EnergyExample example = new EnergyExample();
        example.createCriteria().andIdIn(idList);
        int result =0;
        try{
            result=energyMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String category) throws Exception {
        EnergyExample example = new EnergyExample();
        example.createCriteria().andIdNotEqualTo(id).andNameEqualTo(category).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Energy> list = null;
        try {
            list = energyMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list == null ? 0 : list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateIsDefault(Long energyId) throws Exception {
        int result = 0;
        try {
            //全部取消默认
            Energy allEnergy = new Energy();
            allEnergy.setIsDefault(false);
            EnergyExample allExample = new EnergyExample();
            allExample.createCriteria();
            energyMapper.updateByExampleSelective(allEnergy, allExample);
            //给指定能效设为默认
            Energy energy = new Energy();
            energy.setIsDefault(true);
            EnergyExample example = new EnergyExample();
            example.createCriteria().andIdEqualTo(energyId);
            energyMapper.updateByExampleSelective(energy, example);
            logService.insertLog("能效", BusinessConstants.LOG_OPERATION_TYPE_EDIT + energyId,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            result = 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean status, String ids) throws Exception {
        logService.insertLog("能效",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> energyIds = StringUtil.strToLongList(ids);
        Energy energy = new Energy();
        energy.setEnabled(status);
        EnergyExample example = new EnergyExample();
        example.createCriteria().andIdIn(energyIds);
        int result = 0;
        try {
            result = energyMapper.updateByExampleSelective(energy, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

}
