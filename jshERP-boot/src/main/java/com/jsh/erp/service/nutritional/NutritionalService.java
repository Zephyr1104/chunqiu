package com.jsh.erp.service.nutritional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.Nutritional;
import com.jsh.erp.datasource.entities.NutritionalExample;
import com.jsh.erp.datasource.entities.MaterialVo4Unit;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.depot.DepotService;
import com.jsh.erp.service.log.LogService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NutritionalService {
    private Logger logger = LoggerFactory.getLogger(NutritionalService.class);

    @Resource
    private NutritionalMapper nutritionalMapper;
    @Resource
    private NutritionalMapperEx nutritionalMapperEx;
    @Resource
    private LogService logService;


    public Long countNutritional(String name)throws Exception {
        Long result=null;
        try{
            result=nutritionalMapperEx.countsByNutritional(name);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Nutritional> select(String name, int offset, int rows) throws Exception {
        List<Nutritional> list = null;
        try {
            list = nutritionalMapperEx.selectByConditionNutritional(name, offset, rows);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Nutritional getNutritional(long id)throws Exception {
        Nutritional result=null;
        try{
            result=nutritionalMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Nutritional> getAllList() throws Exception {
        NutritionalExample example = new NutritionalExample();
        example.setOrderByClause("id desc");
        List<Nutritional> list = null;
        try {
            list = nutritionalMapper.selectByExample(example);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Nutritional> getNutritional()throws Exception {
        NutritionalExample example = new NutritionalExample();
        example.createCriteria().andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Nutritional> list=null;
        try{
            list=nutritionalMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }


    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertNutritional(JSONObject obj, HttpServletRequest request)throws Exception {
        Nutritional nutritional = JSONObject.parseObject(obj.toJSONString(), Nutritional.class);
        int result =0;
        try{
            result=nutritionalMapper.insertSelective(nutritional);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateNutritional(JSONObject obj, HttpServletRequest request)throws Exception {
        Nutritional Nutritional = JSONObject.parseObject(obj.toJSONString(), Nutritional.class);
        int result =0;
        try{
            result=nutritionalMapper.updateByPrimaryKeySelective(Nutritional);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteNutritional(Long id, HttpServletRequest request)throws Exception {
        int result =0;
        try{
            result=nutritionalMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteNutritional(String ids, HttpServletRequest request)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        NutritionalExample example = new NutritionalExample();
        example.createCriteria().andIdIn(idList);
        int result =0;
        try{
            result=nutritionalMapper.deleteByExample(example);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public int checkIsNameExist(Long materialId, String batchNumber)throws Exception {
        NutritionalExample example = new NutritionalExample();
        example.createCriteria().andIdNotEqualTo(materialId).andDeleteFlagNotEqualTo(BusinessConstants.DELETE_FLAG_DELETED);
        List<Nutritional> list =null;
        try{
            list=nutritionalMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateIsDefault(Long nutritionalId) throws Exception {
        int result = 0;
        try {
            //全部取消默认
            Nutritional allnutritional = new Nutritional();
            allnutritional.setIsDefault(false);
            NutritionalExample nutritionalExample = new NutritionalExample();
            nutritionalExample.createCriteria();
            nutritionalMapper.updateByExampleSelective(allnutritional, nutritionalExample);
            //给指定餐次设为默认
            Nutritional nutritional = new Nutritional();
            nutritional.setIsDefault(true);
            NutritionalExample example = new NutritionalExample();
            example.createCriteria().andIdEqualTo(nutritionalId);
            nutritionalMapper.updateByExampleSelective(nutritional, example);
            logService.insertLog("国际营养成分", BusinessConstants.LOG_OPERATION_TYPE_EDIT + nutritionalId,
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
            result = 1;
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Boolean status, String ids) throws Exception {
        logService.insertLog("国际营养成分",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ENABLED).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        List<Long> nutritionalIds = StringUtil.strToLongList(ids);
        Nutritional nutritional = new Nutritional();
        nutritional.setEnabled(status);
        NutritionalExample example = new NutritionalExample();
        example.createCriteria().andIdIn(nutritionalIds);
        int result = 0;
        try {
            result = nutritionalMapper.updateByExampleSelective(nutritional, example);
        } catch (Exception e) {
            JshException.writeFail(logger, e);
        }
        return result;
    }

    public JSONObject parseMapByExcelData(String barCodes, List<Map<String, String>> detailList, String prefixNo) throws Exception {
        JSONObject map = new JSONObject();
        JSONArray arr = new JSONArray();
        List<MaterialVo4Unit> list = nutritionalMapperEx.getBillItemByParam(barCodes);
        Map<String, MaterialVo4Unit> materialMap = new HashMap<>();
        Map<String, Long> depotMap = new HashMap<>();
        for (MaterialVo4Unit material: list) {
            materialMap.put(material.getmBarCode(), material);
        }
        for (Map<String, String> detailMap: detailList) {
            JSONObject item = new JSONObject();
            String barCode = detailMap.get("barCode");
            if(StringUtil.isNotEmpty(barCode)) {
                MaterialVo4Unit m = materialMap.get(barCode);
                if(m!=null) {
                    //判断仓库是否存在
                    String depotName = detailMap.get("depotName");
                    if(StringUtil.isNotEmpty(depotName)) {
                        if(depotMap.get(depotName)!=null) {
                            item.put("depotName", depotName);
                            item.put("depotId", depotMap.get(depotName));
                        } else {
                            throw new BusinessRunTimeException(ExceptionConstants.DEPOT_ITEM_DEPOTNAME_IS_NOT_EXIST_CODE,
                                    String.format(ExceptionConstants.DEPOT_ITEM_DEPOTNAME_IS_NOT_EXIST_MSG, depotName));
                        }
                    }
                    String anotherDepotName = detailMap.get("anotherDepotName");
                    if(StringUtil.isNotEmpty(anotherDepotName)) {
                        if(depotMap.get(anotherDepotName)!=null) {
                            item.put("anotherDepotName", anotherDepotName);
                            item.put("anotherDepotId", depotMap.get(anotherDepotName));
                        } else {
                            throw new BusinessRunTimeException(ExceptionConstants.DEPOT_ITEM_DEPOTNAME_IS_NOT_EXIST_CODE,
                                    String.format(ExceptionConstants.DEPOT_ITEM_DEPOTNAME_IS_NOT_EXIST_MSG, anotherDepotName));
                        }
                    }

                    item.put("barCode", barCode);
                    item.put("name", m.getName());
                    item.put("standard", m.getStandard());
                    if(StringUtil.isNotEmpty(m.getModel())) {
                        item.put("model", m.getModel());
                    }
                    if(StringUtil.isNotEmpty(m.getColor())) {
                        item.put("color", m.getColor());
                    }
                    if(StringUtil.isNotEmpty(m.getSku())) {
                        item.put("sku", m.getSku());
                    }
                    BigDecimal stock = BigDecimal.ZERO;
/*                    if(StringUtil.isNotEmpty(m.getSku())){
                        stock = getSkuStockByParam(null, m.getMeId(),null,null);
                    } else {
                        stock = getCurrentStockByParam(null, m.getId());
                    }*/
                    item.put("stock", stock);
                    item.put("unit", m.getCommodityUnit());
                    BigDecimal operNumber = BigDecimal.ZERO;
                    BigDecimal unitPrice = BigDecimal.ZERO;
                    BigDecimal taxRate = BigDecimal.ZERO;
                    BigDecimal currentStock = BigDecimal.ZERO;
                    if(StringUtil.isNotEmpty(detailMap.get("currentStock"))) {
                        currentStock = new BigDecimal(detailMap.get("currentStock"));
                    }
                    if(StringUtil.isNotEmpty(detailMap.get("num"))) {
                        operNumber = new BigDecimal(detailMap.get("num"));
                    }
                    if(StringUtil.isNotEmpty(detailMap.get("unitPrice"))) {
                        unitPrice = new BigDecimal(detailMap.get("unitPrice"));
                    } else {
                        if("CGDD".equals(prefixNo)) {
                            unitPrice = m.getPurchaseDecimal();
                        } else if("XSDD".equals(prefixNo)) {
                            unitPrice = m.getWholesaleDecimal();
                        }else if("PDLR".equals(prefixNo)) {
                            unitPrice = m.getPurchaseDecimal();
                        } else if ("DBCK".equals(prefixNo)) {
                            unitPrice = m.getPurchaseDecimal();
                        }
                    }
                    if(StringUtil.isNotEmpty(detailMap.get("taxRate"))) {
                        taxRate = new BigDecimal(detailMap.get("taxRate"));
                    }
                    String remark = detailMap.get("remark");
                    item.put("currentStock", currentStock);
                    item.put("operNumber", operNumber);
                    item.put("unitPrice", unitPrice);
                    BigDecimal allPrice = BigDecimal.ZERO;
                    if(unitPrice!=null && unitPrice.compareTo(BigDecimal.ZERO)!=0) {
                        allPrice = unitPrice.multiply(operNumber);
                    }
                    BigDecimal taxMoney = BigDecimal.ZERO;
                    if(taxRate.compareTo(BigDecimal.ZERO) != 0) {
                        taxMoney = taxRate.multiply(allPrice).divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP);
                    }
                    BigDecimal taxLastMoney = allPrice.add(taxMoney);
                    item.put("allPrice", allPrice);
                    item.put("taxRate", taxRate);
                    item.put("taxMoney", taxMoney);
                    item.put("taxLastMoney", taxLastMoney);
                    item.put("remark", remark);
                    arr.add(item);
                } else {
                    throw new BusinessRunTimeException(ExceptionConstants.DEPOT_ITEM_BARCODE_IS_NOT_EXIST_CODE,
                            String.format(ExceptionConstants.DEPOT_ITEM_BARCODE_IS_NOT_EXIST_MSG, barCode));
                }
            }
        }
        map.put("rows", arr);
        return map;
    }
}
