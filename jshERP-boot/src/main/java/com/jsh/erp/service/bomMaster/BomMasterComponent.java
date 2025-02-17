package com.jsh.erp.service.bomMaster;


import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.BomMasterEx;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value="bomMaster_component")
@BomMasterResource
public class BomMasterComponent implements ICommonQuery {

    @Resource
    private BomMasterService bomMasterService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return bomMasterService.getBomMaster(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getBomMasterList(map);
    }

    private List<BomMasterEx> getBomMasterList(Map<String,String> map) throws Exception{
        String search = map.get("search");
        String name = StringUtil.getInfo(search,"name");
        return bomMasterService.select(name,QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        String name = StringUtil.getInfo(search,"name");
        return bomMasterService.countSelect(name);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return bomMasterService.insertBomMaster(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return bomMasterService.updateBomMaster(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return bomMasterService.deleteBomMaster(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return bomMasterService.batchDeleteBomMaster(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return bomMasterService.checkIsNameExist(id,name);
    }
}
