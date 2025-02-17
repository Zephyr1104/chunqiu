package com.jsh.erp.service.materialR;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.MaterialRMapper;
import com.jsh.erp.datasource.mappers.MaterialRMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.accountItem.AccountItemService;
import com.jsh.erp.service.depot.DepotService;
import com.jsh.erp.service.depotHead.DepotHeadService;
import com.jsh.erp.service.log.LogService;
import com.jsh.erp.service.orgaUserRel.OrgaUserRelService;
import com.jsh.erp.service.supplier.SupplierService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jsh.erp.utils.Tools.getCenternTime;

@Service
public class MaterialRService {
    private Logger logger = LoggerFactory.getLogger(MaterialRService.class);
    @Resource
    private MaterialRMapper materialRMapper;
    @Resource
    private MaterialRMapperEx materialRMapperEx;
    @Resource
    private OrgaUserRelService orgaUserRelService;
    @Resource
    private AccountItemService accountItemService;
    @Resource
    private DepotHeadService depotHeadService;
    @Resource
    private UserService userService;
    @Resource
    private SupplierService supplierService;
    @Resource
    private DepotService depotService;
    @Resource
    private LogService logService;

    public MaterialR getMaterialR(long id) throws Exception {
        MaterialR result=null;
        try{
            result=materialRMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<MaterialR> getMaterialRListByIds(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<MaterialR> list = new ArrayList<>();
        try{
            MaterialREx example = new MaterialREx();
            example.createCriteria().andIdIn(idList);
            list = materialRMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<MaterialR> getMaterialR() throws Exception{
        MaterialREx example = new MaterialREx();
        List<MaterialR> list=null;
        try{
            list=materialRMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<MaterialRVo4ListEx> select(String type, String qualityNo, String beginTime, String endTime,
                                             Long organId, Long creator, Long auditor, Long depotId, String status,
                                             String remark, String number, int offset, int rows) throws Exception{
        List<MaterialRVo4ListEx> resList = new ArrayList<>();
        try{
            String [] creatorArray = getCreatorArray();
            beginTime = Tools.parseDayToTime(beginTime,BusinessConstants.DAY_FIRST_TIME);
            endTime = Tools.parseDayToTime(endTime,BusinessConstants.DAY_LAST_TIME);
            List<MaterialRVo4ListEx> list = materialRMapperEx.selectByConditionMaterialR(type, creatorArray, qualityNo,
                    beginTime, endTime, organId, creator, auditor, depotId, status, remark, number, offset, rows);
            if (null != list) {
                for (MaterialRVo4ListEx ah : list) {
                    if(ah.getOrganId() != null) {
                      ah.setOrganName(supplierService.getSupplier(ah.getOrganId()).getSupplier());
                    }
                    if(ah.getDepotId() != null) {
                        ah.setDepotName(depotService.getDepot(ah.getDepotId()).getName());
                    }
                    if(ah.getCreator() != null) {
                        ah.setUserName(userService.getUser(ah.getCreator()).getUsername());
                    }
                    if(ah.getAuditor() != null) {
                        ah.setAuditorName(userService.getUser(ah.getAuditor()).getUsername());
                    }
                    if(ah.getQualityTime() !=null) {
                        ah.setBillTimeStr(getCenternTime(ah.getQualityTime()));
                    }
                    resList.add(ah);
                }
            }
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return resList;
    }

    public Long countMaterialR(String type, String qualityNo, String beginTime, String endTime,
                                 Long organId, Long creator, Long auditor, Long depotId, String status,
                                 String remark, String number) throws Exception{
        Long result=null;
        try{
            String [] creatorArray = getCreatorArray();
            beginTime = Tools.parseDayToTime(beginTime,BusinessConstants.DAY_FIRST_TIME);
            endTime = Tools.parseDayToTime(endTime,BusinessConstants.DAY_LAST_TIME);
            result = materialRMapperEx.countsByMaterialR(type, creatorArray, qualityNo,
                    beginTime, endTime, organId, creator, auditor, depotId, status, remark, number);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    /**
     * 根据角色类型获取操作员数组
     * @return
     * @throws Exception
     */
    private String[] getCreatorArray() throws Exception {
        String creator = "";
        User user = userService.getCurrentUser();
        String roleType = userService.getRoleTypeByUserId(user.getId()).getType(); //角色类型
        if(BusinessConstants.ROLE_TYPE_PRIVATE.equals(roleType)) {
            creator = user.getId().toString();
        } else if(BusinessConstants.ROLE_TYPE_THIS_ORG.equals(roleType)) {
            creator = orgaUserRelService.getUserIdListByUserId(user.getId());
        }
        String [] creatorArray=null;
        if(StringUtil.isNotEmpty(creator)){
            creatorArray = creator.split(",");
        }
        return creatorArray;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertMaterialR(JSONObject obj, HttpServletRequest request) throws Exception{
        MaterialR materialR = JSONObject.parseObject(obj.toJSONString(), MaterialR.class);
        int result=0;
        try{
            User userInfo=userService.getCurrentUser();
            materialR.setCreator(userInfo==null?null:userInfo.getId());
            result = materialRMapper.insertSelective(materialR);
            logService.insertLog("原料质检报告",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(materialR.getQualityNo()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateMaterialR(JSONObject obj, HttpServletRequest request)throws Exception {
        MaterialR materialR = JSONObject.parseObject(obj.toJSONString(), MaterialR.class);
        int result=0;
        try{
            result = materialRMapper.updateByPrimaryKeySelective(materialR);
            logService.insertLog("原料质检报告",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(materialR.getQualityNo()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteMaterialR(Long id, HttpServletRequest request)throws Exception {
        return batchDeleteMaterialRByIds(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialR(String ids, HttpServletRequest request)throws Exception {
        return batchDeleteMaterialRByIds(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteMaterialRByIds(String ids)throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        User userInfo=userService.getCurrentUser();
        String [] idArray=ids.split(",");
        //删除原料质检报告
        materialRMapperEx.batchDeleteMaterialRByIds(new Date(),userInfo==null?null:userInfo.getId(),idArray);
        logService.insertLog("原料质检报告", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        return 1;
    }

    /**
     * 校验质检编号是否存在
     * @param id
     * @param billNo
     * @return
     * @throws Exception
     */
    public int checkIsBillNoExist(Long id, String billNo)throws Exception {
        MaterialREx example = new MaterialREx();
        example.createCriteria().andIdNotEqualTo(id).andBillNoEqualTo(billNo).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<MaterialR> list = null;
        try{
            list = materialRMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(String status, String materialRIds)throws Exception {
        int result = 0;
        try{
            List<Long> ahIds = new ArrayList<>();
            List<Long> ids = StringUtil.strToLongList(materialRIds);
            for(Long id: ids) {
                MaterialR materialR = getMaterialR(id);
                if("0".equals(status)){
                    if("1".equals(materialR.getStatus())) {
                        ahIds.add(id);
                    }
                } else if("1".equals(status)){
                    if("0".equals(materialR.getStatus())) {
                        ahIds.add(id);
                    }
                }
            }
            if(ahIds.size()>0) {
                MaterialR materialR = new MaterialR();
                materialR.setStatus(status);
                MaterialREx example = new MaterialREx();
                example.createCriteria().andIdIn(ahIds);
                result = materialRMapper.updateByExampleSelective(materialR, example);
            } else {
                return 1;
            }
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void addMaterialR(String beanJson, String rows, HttpServletRequest request) throws Exception {
        MaterialR materialR = JSONObject.parseObject(beanJson, MaterialR.class);
        JSONArray rowArr = JSONArray.parseArray(rows);
        if (null != rowArr && rowArr.size()>0) {
            for (int i = 0; i < rowArr.size(); i++) {
                JSONObject rowObj = JSONObject.parseObject(rowArr.getString(i));
                materialR.setMaterialId(Long.parseLong(rowObj.getString("barCode")));
                materialR.setMaterialName(rowObj.getString("name"));
                materialR.setMaterialUnit(rowObj.getString("unit"));
                materialR.setBasicNumber(new BigDecimal(rowObj.getString("operNumber")));
                materialR.setOperNumber(new BigDecimal(rowObj.getString("operNumber")));
                materialR.setDepotId(Long.parseLong(rowObj.getString("depotId")));
                materialR.setBatchNumber(rowObj.getString("batchNumber"));
                materialR.setRemark(rowObj.getString("remark"));
            }
        }
       /* //校验单号是否重复
        if(checkIsBillNoExist(0L, materialR.getQualityNo())>0) {
            throw new BusinessRunTimeException(ExceptionConstants.ACCOUNT_HEAD_BILL_NO_EXIST_CODE,
                    String.format(ExceptionConstants.ACCOUNT_HEAD_BILL_NO_EXIST_MSG));
        }*/
        User userInfo=userService.getCurrentUser();
        materialR.setCreator(userInfo==null?null:userInfo.getId());
        if(StringUtil.isEmpty(materialR.getStatus())) {
            materialR.setStatus(BusinessConstants.BILLS_STATUS_UN_AUDIT);
        }
        materialR.setCreateTime(new Date());
        materialRMapper.insertSelective(materialR);
        logService.insertLog("原料质检报告",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(materialR.getQualityNo()).toString(), request);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public void updateMaterialR(String beanJson, String rows, HttpServletRequest request) throws Exception {
        MaterialR materialR = JSONObject.parseObject(beanJson, MaterialR.class);
        //校验单号是否重复
        if(checkIsBillNoExist(materialR.getId(), materialR.getQualityNo())>0) {
            throw new BusinessRunTimeException(ExceptionConstants.ACCOUNT_HEAD_BILL_NO_EXIST_CODE,
                    String.format(ExceptionConstants.ACCOUNT_HEAD_BILL_NO_EXIST_MSG));
        }
        materialRMapper.updateByPrimaryKeySelective(materialR);

        logService.insertLog("原料质检报告",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(materialR.getQualityNo()).toString(), request);
    }



    public List<MaterialR> getMaterialRByReportId(Long reportId) {
        return materialRMapperEx.getMaterialRByReportId(reportId);
    }
}
