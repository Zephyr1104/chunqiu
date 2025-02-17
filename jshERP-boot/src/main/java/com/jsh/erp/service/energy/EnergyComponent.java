package com.jsh.erp.service.energy;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.service.energy.EnergyResource;
import com.jsh.erp.service.energy.EnergyService;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "energy_component")
@EnergyResource
public class EnergyComponent implements ICommonQuery {

    @Resource
    private EnergyService energyService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return energyService.getEnergy(id);
    }

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getEnergyList(map);
    }

    private List<?> getEnergyList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String category = StringUtil.getInfo(search, "category");
        String orgNo = StringUtil.getInfo(search, "orgNo");
        return energyService.select(category,  orgNo, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String category = StringUtil.getInfo(search, "category");
        String orgNo = StringUtil.getInfo(search, "orgNo");
        return energyService.countEnergy(category, orgNo);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request) throws Exception{
        return energyService.insertEnergy(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return energyService.updateEnergy(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return energyService.deleteEnergy(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return energyService.batchDeleteEnergy(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String category)throws Exception {
        return energyService.checkIsNameExist(id, category);
    }

}
