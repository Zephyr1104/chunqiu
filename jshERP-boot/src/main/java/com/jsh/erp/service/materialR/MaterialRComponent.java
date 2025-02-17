package com.jsh.erp.service.materialR;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.materialR.MaterialRResource;
import com.jsh.erp.service.materialR.MaterialRService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "materialR_component")
@MaterialRResource
public class MaterialRComponent implements ICommonQuery {

    @Resource
    private MaterialRService materialRService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return materialRService.getMaterialR(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getMaterialRList(map);
    }

    private List<?> getMaterialRList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String qualityNo = StringUtil.getInfo(search, "qualityNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        Long organId = StringUtil.parseStrLong(StringUtil.getInfo(search, "organId"));
        Long creator = StringUtil.parseStrLong(StringUtil.getInfo(search, "creator"));
        Long auditor = StringUtil.parseStrLong(StringUtil.getInfo(search, "auditor"));
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));
        String status = StringUtil.getInfo(search, "status");
        String remark = StringUtil.getInfo(search, "remark");
        String number = StringUtil.getInfo(search, "number");
        return materialRService.select(type, qualityNo, beginTime, endTime, organId, creator, auditor,
                depotId, status, remark,number, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String type = StringUtil.getInfo(search, "type");
        String qualityNo = StringUtil.getInfo(search, "qualityNo");
        String beginTime = StringUtil.getInfo(search, "beginTime");
        String endTime = StringUtil.getInfo(search, "endTime");
        Long organId = StringUtil.parseStrLong(StringUtil.getInfo(search, "organId"));
        Long creator = StringUtil.parseStrLong(StringUtil.getInfo(search, "creator"));
        Long depotId = StringUtil.parseStrLong(StringUtil.getInfo(search, "depotId"));
        Long accountId = StringUtil.parseStrLong(StringUtil.getInfo(search, "accountId"));
        String status = StringUtil.getInfo(search, "status");
        String remark = StringUtil.getInfo(search, "remark");
        String number = StringUtil.getInfo(search, "number");
        return materialRService.countMaterialR(type, qualityNo, beginTime, endTime, organId, creator, depotId,
                accountId, status, remark, number);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception{
        return materialRService.insertMaterialR(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return materialRService.updateMaterialR(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return materialRService.deleteMaterialR(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return materialRService.batchDeleteMaterialR(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }

}
