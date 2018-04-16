package com.wpx.jdk.base.common.interfaces;

/**
 * Created by wpx on 2018/4/15.
 *
 */
public interface CommonUserService extends LeaderService, UserService{
    /**
     * 在接口里可以使用默认方法来实现父接口的抽象方法
     *
     * @param deptId
     * @return
     */
    @Override
    default String getDeptDesc(String deptId) {
        return LeaderService.super.getDeptDesc(deptId);
    }

    /**
     *  可以在子接口里重写父接口的默认方法，使其成为抽象方法
     *
     * @return
     */
    @Override
     String getLeaderRecord();

    /**
     * 在接口里可以使用默认方法来实现父接口的抽象方法。
     *
     * @param userId
     */
    @Override
    default void getUserInfo(Long userId) {
        System.out.println("user_V2：wpx");
        System.out.println("所属部门_V2：" + getDeptDesc("001"));
    }
}
