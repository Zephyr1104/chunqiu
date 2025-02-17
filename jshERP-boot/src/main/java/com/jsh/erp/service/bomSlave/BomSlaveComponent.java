package com.jsh.erp.service.bomSlave;


import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.datasource.entities.BomMaster;
import com.jsh.erp.datasource.entities.BomSlave;
import com.jsh.erp.datasource.entities.BomSlaveEx;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.bomMaster.BomMasterResource;
import com.jsh.erp.service.bomMaster.BomMasterService;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value="bomSlave_component")
@BomSlaveResource
public class BomSlaveComponent implements ICommonQuery {

    @Resource
    private BomSlaveService bomSlaveService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return bomSlaveService.getBomSlave(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getBomSlaveList(map);
    }

    private List<BomSlaveEx> getBomSlaveList(Map<String,String> map) throws Exception{
        String search = map.get("search");
        Integer bomMasterId = StringUtil.parseInteger(StringUtil.getInfo(search,"bomMasterId"));
        return bomSlaveService.select(bomMasterId,QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get("search");
        Integer bomMasterId = StringUtil.parseInteger(StringUtil.getInfo(search,"bomMasterId"));
        return bomSlaveService.countSelect(bomMasterId);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception {
        return bomSlaveService.insertBomSlave(obj,request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request) throws Exception {
        return bomSlaveService.updateBomSlave(obj,request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request) throws Exception {
        return bomSlaveService.deleteBomSlave(id,request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request) throws Exception {
        return bomSlaveService.batchDeleteBomSlave(ids,request);
    }

    @Override
    public int checkIsNameExist(Long id, String name) throws Exception {
        return 0;
    }
}
