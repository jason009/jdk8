package com.wpx.jdk.base.lambda.functions;

/**
 * Created by wpx on 2018/4/7.
 *
 * 为接口引入了一个新的注解：@FunctionalInterface
 * 表示该接口为函数式接口，只允许有一个方法。
 * 否则编译器报错
 */
@FunctionalInterface
public interface FunctionalInterfaceService {
    public abstract void run();
}
