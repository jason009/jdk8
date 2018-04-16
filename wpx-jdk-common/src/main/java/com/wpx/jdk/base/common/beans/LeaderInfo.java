package com.wpx.jdk.base.common.beans;

import java.math.BigDecimal;

/**
 * Created by wpx on 2018/4/15.
 */
public class LeaderInfo {
    private UserInfo userInfo;
    /**
     * 级别
     */
    private int positionLevel;
    /**
     * 薪水
     */
    private BigDecimal salary;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(int positionLevel) {
        this.positionLevel = positionLevel;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
