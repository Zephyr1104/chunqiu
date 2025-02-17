package com.jsh.erp.service.driver;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.service.ICommonQuery;
import com.jsh.erp.utils.Constants;
import com.jsh.erp.utils.QueryUtils;
import com.jsh.erp.utils.StringUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "driver_component")
@DriverResource
public class DriverComponent implements ICommonQuery {

    @Resource
    private DriverService driverService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return driverService.getDriver(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getDriverList(map);
    }

    private List<?> getDriverList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String loginName = StringUtil.getInfo(search, "loginName");
        String driverName = StringUtil.getInfo(search, "driverName");
        return driverService.select(loginName, driverName, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String loginName = StringUtil.getInfo(search, "loginName");
        String driverName = StringUtil.getInfo(search, "driverName");
        return driverService.countDriver(loginName, driverName);
    }

    @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return driverService.insertDriver(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return driverService.updateDriver(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return driverService.deleteDriver(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return driverService.batchDeleteDriver(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return driverService.checkIsNameExist(id, name);
    }

}
