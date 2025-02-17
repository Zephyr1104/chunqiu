package com.jsh.erp.service.information;

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

@Service(value = "information_component")
@InformationResource
public class InformationComponent implements ICommonQuery {

    @Resource
    private InformationService informationService;

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getInformationList(map);
    }

    private List<?> getInformationList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return informationService.select(name, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        return informationService.countInformation(name);
    }

    @Override
    public Object selectOne(Long id) throws Exception {
        return informationService.getInformation(id);
    }

     @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return informationService.insertInformation(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return informationService.updateInformation(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return informationService.deleteInformation(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return informationService.batchDeleteInformation(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return informationService.checkIsNameExist(id,name);
    }

}
