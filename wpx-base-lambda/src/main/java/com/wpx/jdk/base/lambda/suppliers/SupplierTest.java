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
    public SupplierTest(){

    }
    public SupplierTest(String s , int ii){

    }
    /**
     * 测试引用地址
     *
     * 其简洁的声明，会让人以为不是函数。这个抽象方法的声明，
     * 同Consumer相反，是一个只声明了返回值，不需要参数的函数（这还叫函数？）。
     * 也就是说Supplier其实表达的不是从一个参数空间到结果空间的映射能力，而是表达一种生成能力，
     * 因为我们常见的场景中不止是要consume（Consumer）或者是简单的map（Function），还包括了new这个动作。
     * 而Supplier就表达了这种能力。
     */
    public static void testObjectRef(){
        // Supplier接口测试
        Supplier<Student> supplier = Student::new;
        // 调用get方法可以创建对象
        System.out.println(supplier.get());
        System.out.println(supplier.get());
    }

    /**
     *这保证supplier对象输出的一直是1。
     */
    public static void testValueRef(){
        Supplier<Integer> supplier = () -> 1;
        System.out.println(supplier.get());
    }

    /**
     * 利用构造函数
     */
    public static void testConstructRef(){
        Supplier<SupplierTest> anotherSupplier = SupplierTest::new;
        for (int i = 0; i < 10; i++) {
            System.out.println(anotherSupplier.get());
        }
    }


    public static void main(String[] args) {
        testConstructRef();
    }



}
