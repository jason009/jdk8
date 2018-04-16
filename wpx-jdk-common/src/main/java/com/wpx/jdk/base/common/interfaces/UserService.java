package com.wpx.jdk.base.common.interfaces;

/**
 * Created by wpx on 2018/4/15.
 */
@FunctionalInterface
public interface UserService {
    /**
     * 查询用户信息
     */
    void getUserInfo(Long userId);

    /**
     * 使用 default 关键字 ,提供默认实现
     *
     * @param deptId
     * @return
     */
    default String getDeptDesc(String deptId) {
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

    /**
     * 可以在接口中定义 static 方法
     */
    static void sayHello(String msg) {
        System.out.println("Hello, " + msg);
    }
}
