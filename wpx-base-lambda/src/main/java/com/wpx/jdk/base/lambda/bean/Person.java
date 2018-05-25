package com.wpx.jdk.base.lambda.bean;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/23
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class Person {
    String firstName;
    String lastName;
    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
