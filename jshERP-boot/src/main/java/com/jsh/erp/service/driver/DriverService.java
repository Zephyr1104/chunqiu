package com.jsh.erp.service.driver;

import com.alibaba.fastjson.JSONObject;
import com.jsh.erp.constants.BusinessConstants;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.DriverMapper;
import com.jsh.erp.datasource.mappers.DriverMapperEx;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.log.LogService;
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
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class DriverService {
    private Logger logger = LoggerFactory.getLogger(DriverService.class);

    @Resource
    private DriverMapper driverMapper;

    @Resource
    private DriverMapperEx driverMapperEx;
    @Resource
    private LogService logService;

    public Driver getDriver(long id)throws Exception {
        Driver result=null;
        try{
            result=driverMapper.selectByPrimaryKey(id);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }

    public List<Driver> getDriverListByIds(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        List<Driver> list = new ArrayList<>();
        try{
            DriverExample example = new DriverExample();
            example.createCriteria().andIdIn(idList);
            list = driverMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Driver> getDriver()throws Exception {
        DriverExample example = new DriverExample();
        example.createCriteria().andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<Driver> list=null;
        try{
            list=driverMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public List<Driver> select(String loginName, String driverName, int offset, int rows)throws Exception {
        List<Driver> list=null;
        try{
            list=driverMapperEx.selectByConditionDriver(loginName, driverName, offset, rows);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list;
    }

    public Long countDriver(String loginName, String driverName)throws Exception {
        Long result=null;
        try{
            result=driverMapperEx.countsByDriver(loginName, driverName);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return result;
    }
    /**
     * create by: zzl
     * description:
     * 添加事务控制
     * create time: 2024/8/11 14:30
     * @Param: beanJson
     * @Param: request
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertDriver(JSONObject obj, HttpServletRequest request)throws Exception {
        Driver driver = JSONObject.parseObject(obj.toJSONString(), Driver.class);
        String password = "123456";
        //因密码用MD5加密，需要对密码进行转化
        try {
            password = Tools.md5Encryp(password);
            driver.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error(">>>>>>>>>>>>>>转化MD5字符串错误 ：" + e.getMessage());
        }
        int result=0;
        try{
            result=driverMapper.insertSelective(driver);
            logService.insertLog("用户",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_ADD).append(driver.getLoginName()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * create by: zzl
     * description:
     * 添加事务控制
     * create time: 2024/8/11 14:31
     * @Param: beanJson
     * @Param: id
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDriver(JSONObject obj, HttpServletRequest request) throws Exception{
        Driver driver = JSONObject.parseObject(obj.toJSONString(), Driver.class);
        int result=0;
        try{
            result=driverMapper.updateByPrimaryKeySelective(driver);
            logService.insertLog("司机",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(driver.getLoginName()).toString(), request);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * create by: zzl
     * description:
     * 添加事务控制
     * create time: 2024/8/11 14:32
     * @Param: user
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateDriverByObj(Driver driver) throws Exception{
        logService.insertLog("司机",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(driver.getId()).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        int result=0;
        try{
            result=driverMapper.updateByPrimaryKeySelective(driver);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }
    /**
     * create by: zzl
     * description:
     *  添加重置密码事务控制
     * create time: 2024/08/11 14:33
     * @Param: md5Pwd
     * @Param: id
     * @return int
     */
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int resetPwd(String md5Pwd, Long id) throws Exception{
        int result=0;
        logService.insertLog("司机",
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(id).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        Driver driver = new Driver();
        driver.setId(id);
        driver.setPassword(md5Pwd);
        try{
            result=driverMapper.updateByPrimaryKeySelective(driver);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        return result;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteDriver(Long id, HttpServletRequest request)throws Exception {
        return batDeleteDriver(id.toString());
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteDriver(String ids, HttpServletRequest request)throws Exception {
        return batDeleteDriver(ids);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batDeleteDriver(String ids) throws Exception{
        int result=0;
        StringBuffer sb = new StringBuffer();
        sb.append(BusinessConstants.LOG_OPERATION_TYPE_DELETE);
        List<Driver> list = getDriverListByIds(ids);
        for(Driver driver: list){
            sb.append("[").append(driver.getLoginName()).append("]");
        }
        logService.insertLog("司机", sb.toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        String idsArray[]=ids.split(",");
        try{
            result=driverMapperEx.batDeleteOrUpdateDriver(idsArray,BusinessConstants.USER_STATUS_DELETE);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        if(result<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids:[{}]",
                    ExceptionConstants.USER_DELETE_FAILED_CODE,ExceptionConstants.USER_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.USER_DELETE_FAILED_CODE,
                    ExceptionConstants.USER_DELETE_FAILED_MSG);
        }
        return result;
    }

    public int checkIsNameExist(Long id, String name)throws Exception {
        DriverExample example = new DriverExample();
        List <Byte> driverStatus=new ArrayList<Byte>();
        driverStatus.add(BusinessConstants.USER_STATUS_DELETE);
        driverStatus.add(BusinessConstants.USER_STATUS_BANNED);
        example.createCriteria().andIdNotEqualTo(id).andLoginNameEqualTo(name).andStatusNotIn(driverStatus);
        List<Driver> list=null;
        try{
            list= driverMapper.selectByExample(example);
        }catch(Exception e){
            JshException.readFail(logger, e);
        }
        return list==null?0:list.size();
    }

    /**
     * 根据司机登录账号查询id
     * @param loginName
     * @return
     */
    public Long getIdByLoginName(String loginName) {
        Long id = 0L;
        DriverExample example = new DriverExample();
        example.createCriteria().andLoginNameEqualTo(loginName).andStatusEqualTo(BusinessConstants.USER_STATUS_NORMAL);
        List<Driver> list = driverMapper.selectByExample(example);
        if(list!=null) {
            id = list.get(0).getId();
        }
        return id;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public DriverEx addDriver(DriverEx driverEx) throws Exception{
        /** zzl 2024-08-11
         * 新增司机默认设置
         * 1、密码默认123456
         * 2是否系统自带默认为非系统自带
         * 3是否管理者默认为员工
         * 4默认用户状态为正常
         * */
        driverEx.setPassword(Tools.md5Encryp(BusinessConstants.USER_DEFAULT_PASSWORD));
        driverEx.setIsystem(BusinessConstants.USER_NOT_SYSTEM);
        if(driverEx.getIsmanager()==null){
            driverEx.setIsmanager(BusinessConstants.USER_NOT_MANAGER);
        }
        driverEx.setStatus(BusinessConstants.USER_STATUS_NORMAL);
        int result=0;
        try{
            result= driverMapper.insertSelective(driverEx);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        if(result>0){
            return driverEx;
        }
        return null;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public DriverEx updateDriver(DriverEx driverEx)throws Exception{
        int result =0;
        try{
            result=driverMapper.updateByPrimaryKeySelective(driverEx);
        }catch(Exception e){
            JshException.writeFail(logger, e);
        }
        if(result>0){
            return driverEx;
        }
        return null;
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchSetStatus(Byte status, String ids, HttpServletRequest request)throws Exception {
        int result=0;
        List<Driver> list = getDriverListByIds(ids);
        StringBuilder driverStr = new StringBuilder();
        List<Long> idList = new ArrayList<>();
        for(Driver driver: list) {
                idList.add(driver.getId());
            driverStr.append(driver.getLoginName()).append(" ");
        }
        String statusStr ="";
        if(status == 0) {
            statusStr ="批量启用";
        } else if(status == 2) {
            statusStr ="批量禁用";
        }
        if(idList.size()>0) {
            Driver driver = new Driver();
            driver.setStatus(status);
            DriverExample example = new DriverExample();
            example.createCriteria().andIdIn(idList);
            result = driverMapper.updateByExampleSelective(driver, example);
            logService.insertLog("司机",
                    new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(driverStr).append("-").append(statusStr).toString(),
                    ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        } else {
            result = 1;
        }
        return result;
    }
}
