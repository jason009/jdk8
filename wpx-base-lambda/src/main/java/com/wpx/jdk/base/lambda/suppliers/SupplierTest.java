package com.wpx.jdk.base.lambda.suppliers;

import com.wpx.jdk.base.lambda.bean.Student;

import java.util.function.Supplier;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/4/19
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class SupplierTest {
    public static void main(String[] args) {
        // Supplier接口测试
        Supplier<Student> supplier = Student::new;
        // 调用get方法可以创建对象
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }
}
