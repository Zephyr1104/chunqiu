package com.jsh.erp.datasource.entities;

/**
 * Description
 *
 * @Author: zzl
 * @Date: 2024/8/8 15:12
 */
public class DriverEx extends Driver{

    private String userType;

    private Integer userNumLimit;

    private String expireTime;

    private String leaderFlagStr;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getUserNumLimit() {
        return userNumLimit;
    }

    public void setUserNumLimit(Integer userNumLimit) {
        this.userNumLimit = userNumLimit;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLeaderFlagStr() {
        return leaderFlagStr;
    }

    public void setLeaderFlagStr(String leaderFlagStr) {
        this.leaderFlagStr = leaderFlagStr;
    }
}
