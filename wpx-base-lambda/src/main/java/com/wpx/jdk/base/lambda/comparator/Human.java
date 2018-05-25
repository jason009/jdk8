package com.wpx.jdk.base.lambda.comparator;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/24
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class Human {
    private String name;
    private int age;

    public Human() {
        super();
    }

    public Human(final String name, final int age) {
        super();

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
