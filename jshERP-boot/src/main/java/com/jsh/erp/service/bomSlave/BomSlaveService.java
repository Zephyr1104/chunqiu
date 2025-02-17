package com.jsh.erp.service.bomSlave;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.datasource.entities.BomSlave;
import com.jsh.erp.datasource.entities.BomSlaveEx;
import com.jsh.erp.datasource.entities.BomSlaveExample;
import com.jsh.erp.datasource.entities.MaterialExtend;
import com.jsh.erp.datasource.mappers.BomSlaveMapper;
import com.jsh.erp.datasource.mappers.BomSlaveMapperEx;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.materialExtend.MaterialExtendService;
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
public class BomSlaveService {

    private Logger logger = LoggerFactory.getLogger(BomSlaveService.class);

    @Resource
    private BomSlaveMapper bomSlaveMapper;

    @Resource
    private BomSlaveMapperEx bomSlaveMapperEx;

    @Resource
    private MaterialExtendService materialExtendService;

    @Resource
    private LogService logService;

    public BomSlave getBomSlave(Long id) throws Exception {
        BomSlave result = null;
        try{
            result = bomSlaveMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<BomSlave> getBomSlaveList(String ids){
        List<Long> idList = StringUtil.strToLongList(ids);
        List<BomSlave> list = new ArrayList<>();
        try{
            BomSlaveExample example = new BomSlaveExample();
            example.createCriteria().andIdIn(idList);
            list = bomSlaveMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<BomSlave> getAllList(){
        BomSlaveExample example = new BomSlaveExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<BomSlave> list =null;
        try{
            list = bomSlaveMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<BomSlaveEx> select(Integer bomMasterId,Integer offset, Integer rows){
        List<BomSlaveEx> list = null;
        try{
            list = bomSlaveMapperEx.selectByCondition(bomMasterId,offset, rows);
            if (null != list && list.size() > 0){
                for (BomSlaveEx ex : list){

                    if (ex.getCreateTime()!= null){
                        ex.setCreateTimeStr(Tools.getCenternTime(ex.getCreateTime()));
                    }
                    if (ex.getUpdateTime()!= null){
                        ex.setUpdateTimeStr(Tools.getCenternTime(ex.getUpdateTime()));
                    }
                }
            }
        }catch (Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countSelect(Integer bomMasterId){
        Long result = null;
        try{
            result = bomSlaveMapperEx.countsBySelect(bomMasterId);
        }catch (Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertBomSlave(JSONObject obj, HttpServletRequest request) {
        BomSlave bomSlave = JSONObject.parseObject(obj.toJSONString(), BomSlave.class);
        int result = 0;
        try {
            if (bomSlave.getMaterialId() == null){
                JshException.writeStringFail(logger, "物料ID不能为空");
            }
            bomSlave.setCreateTime(new Timestamp(System.currentTimeMillis()));
            MaterialExtend infoByBarCode = materialExtendService.getInfoByBarCode(bomSlave.getMaterialId().toString());
            if (infoByBarCode == null){
                JshException.writeStringFail(logger, "商品不存在");
            }
            bomSlave.setMaterialId(infoByBarCode.getMaterialId());
            result = bomSlaveMapper.insertSelective(bomSlave);
            // 记录日志
//            logService.insertLog("[业务处理-新增子物料BOM信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(bomSlave.getBomMasterId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateBomSlave(JSONObject obj, HttpServletRequest request) {
        BomSlave bomSlave = JSONObject.parseObject(obj.toJSONString(), BomSlave.class);
        int result = 0;
        try {
            bomSlave.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            MaterialExtend infoByBarCode = materialExtendService.getInfoByBarCode(bomSlave.getMaterialId().toString());
            if (infoByBarCode == null){
                JshException.writeStringFail(logger, "商品不存在");
            }
            bomSlave.setMaterialId(infoByBarCode.getMaterialId());
            result = bomSlaveMapper.updateByPrimaryKeySelective(bomSlave);
            // 记录日志
//            logService.insertLog("[业务处理-更新主物料BOM信息]", new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(bomSlave.getBomMasterId()).toString(), request);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int deleteBomSlave(Long id, HttpServletRequest request) {
        return batchDeleteBomSlaveByIds(id.toString());
    }

    public int batchDeleteBomSlave(String ids, HttpServletRequest request) {
        return batchDeleteBomSlaveByIds(ids);
    }

    public int batchDeleteBomSlaveByIds(String ids) {
        int resut = 0;
        String[] idArray = ids.split(",");
        try {
            resut = bomSlaveMapperEx.batchDeleteByIds(idArray);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return resut;
    }





}
