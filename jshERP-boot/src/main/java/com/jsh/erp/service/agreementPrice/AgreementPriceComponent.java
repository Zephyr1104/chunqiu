package com.jsh.erp.service.agreementPrice;

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

@Service(value = "agreementPrice_component")
@AgreementPriceResource
public class AgreementPriceComponent implements ICommonQuery {

    @Resource
    private AgreementPriceService agreementPriceService;

    @Override
    public List<?> select(Map<String, String> map) throws Exception {
        return getagreementPriceList(map);
    }

    private List<?> getagreementPriceList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        Integer material_id = StringUtil.parseInteger(StringUtil.getInfo(search, "material_id"));
        String batch_number = StringUtil.getInfo(search, "batch_number");
        return agreementPriceService.select(material_id,  batch_number, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception {
        String search = map.get(Constants.SEARCH);
        String batch_number = StringUtil.getInfo(search, "batch_number");
        Integer material_id = StringUtil.parseInteger(StringUtil.getInfo(search, "material_id"));
        return agreementPriceService.countAgreementPrice(material_id, batch_number);
    }

    @Override
    public Object selectOne(Long id) throws Exception {
        return agreementPriceService.getAgreementPrice(id);
    }

     @Override
    public int insert(JSONObject obj, HttpServletRequest request)throws Exception {
        return agreementPriceService.insertAgreementPrice(obj, request);
    }

    @Override
    public int update(JSONObject obj, HttpServletRequest request)throws Exception {
        return agreementPriceService.updateAgreementPrice(obj, request);
    }

    @Override
    public int delete(Long id, HttpServletRequest request)throws Exception {
        return agreementPriceService.deleteAgreementPrice(id, request);
    }

    @Override
    public int deleteBatch(String ids, HttpServletRequest request)throws Exception {
        return agreementPriceService.batchDeleteAgreementPrice(ids, request);
    }

    @Override
    public int checkIsNameExist(Long id,String batchNumber)throws Exception {
        return agreementPriceService.checkIsNameExist(id,batchNumber);
    }

}
