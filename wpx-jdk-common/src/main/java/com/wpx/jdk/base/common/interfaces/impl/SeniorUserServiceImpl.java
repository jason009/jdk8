package com.wpx.jdk.base.common.interfaces.impl;

import com.wpx.jdk.base.common.beans.LeaderInfo;
import com.wpx.jdk.base.common.interfaces.LeaderService;
import com.wpx.jdk.base.common.interfaces.UserService;

/**
 * Created by wpx on 2018/4/15.
 * 高级员工实现
 * <p>
 * 实现多个接口时，接口中有重名的方法体的实现 (default 修饰的方法)。
 * 如果同时实现两个具有相同方法名且实现了该方法的接口，
 * 需要提供自己对该方法的实现。才可以解决冲突。
 */
public class SeniorUserServiceImpl implements UserService, LeaderService {

    @Override
    public void getUserInfo(Long userId) {
        System.out.println("user：wpx");
        System.out.println("所属部门：" + getDeptDesc("001"));
    }

    @Override
    public LeaderInfo getLeaderInfo(Long userId) {
        return null;
    }

    /**
     * 实现多个接口时，接口中有重名的方法体的实现 (default 修饰的方法)。
     * 如果同时实现两个具有相同方法名且实现了该方法的接口，
     * 需要提供自己对该方法的实现。才可以解决冲突。
     *
     * @param deptId
     * @return
     */
    @Override
    public String getDeptDesc(String deptId) {
        //可以修改如下进行重写，用super明确调用哪个接口的方法：
        //LeaderService.super.getDeptDesc(deptId);

        //也可以自己重新实现
        switch (deptId) {
            case "001":
                return "前台研发部";
            case "002":
                return "中台研发部";
            case "003":
                return "后台研发部";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        UserService userService = new SeniorUserServiceImpl();
        UserService.sayHello("wpx");
        userService.getUserInfo(0L);
        UserService.sayHello("wpx");
    }
}
