package com.wpx.jdk.base.common.interfaces;

import com.wpx.jdk.base.common.beans.LeaderInfo;

/**
 * Created by wpx on 2018/4/15.
 */
@FunctionalInterface
public interface LeaderService {

    LeaderInfo getLeaderInfo(Long userId);

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
     * 获取履历信息
     * @return
     */
    default String getLeaderRecord(){
        return "暂时不知道履历信息";
    }
}

