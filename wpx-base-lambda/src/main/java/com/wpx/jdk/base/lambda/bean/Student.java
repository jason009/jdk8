package com.wpx.jdk.base.lambda.bean;

import java.util.function.Function;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/4/19
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class Student {
    public int age;
    public String gender;

    public Student(){
    }

    public Student(int age,String gender){
        this.age = age;
        this.gender = gender;
    }
    public  String customShow(Function<Student,String> fun){
        return fun.apply(this);
    }
}
