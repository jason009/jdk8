package com.wpx.jdk.base.common.interfaces.impl;

import com.wpx.jdk.base.common.interfaces.UserService;

/**
 * 普通员工实现
 * <p>
 * Created by wpx on 2018/4/15.
 */
public class OrdinaryUserServiceImpl implements UserService {

    @Override
    public void getUserInfo(Long userId) {
        System.out.println("user：wpx");
        System.out.println("所属部门：" + getDeptDesc("001"));
    }

    /**
     *
     * 类方法的 优先级 高于 接口方法
     *
     * @param deptId
     * @return
     */
    @Override
    public String getDeptDesc(String deptId) {
        switch (deptId) {
            case "001":
                return "前台研发部 clz";
            case "002":
                return "中台研发部 clz";
            case "003":
                return "后台研发部 clz";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        UserService userService = new OrdinaryUserServiceImpl();
        userService.getUserInfo(0L);
    }
}
