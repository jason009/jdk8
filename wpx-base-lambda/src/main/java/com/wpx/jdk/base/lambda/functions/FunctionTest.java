package com.wpx.jdk.base.lambda.functions;

import java.util.function.Function;

/**
 * http://www.importnew.com/17209.html
 * BiFunction 是接收两个参数的Function
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/4/19
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class FunctionTest {
    public static void testFunction(){
        //简单的,只有一行
        Function<Integer, String> function1 = (x) ->{
            String s = "test result: " + x;
            System.out.println("function1="+x);
            System.out.println("function1="+s);
            return s;
        } ;
        //标准的,有花括号, return, 分号.
        Function<String, String> function2 = (x) -> {
            String s = "after function1";
            System.out.println("after function1="+x);
            System.out.println("after function1="+s);
            return s;
        };
        //System.out.println(function1.apply(6));
        System.out.println(function1.andThen(function2).apply(6));
    }

    /**
     * 在compose里面，先执行squared的apply(4)方法，然后再把结果给times2让他去执行16×2的方法。
     * 而andThen恰恰相反，由英文来理解，先后顺序，即先执行times2的apply方法，
     * 再把结果执行squared的apply方法。
     */
    public static void testFunction2(){
        Function<Integer, Integer> times2 = i -> i*2;
        Function<Integer, Integer> squared = i -> i*i;
        System.out.println(times2.apply(4));
        System.out.println(squared.apply(4));
        System.out.println(times2.compose(squared).apply(4));  //32 先4×4然后16×2,先执行apply(4)，在times2的apply(16),先执行参数，再执行调用者。
        System.out.println(times2.andThen(squared).apply(4));  //64 先4×2,然后8×8,先执行times2的函数，在执行squared的函数。

        //虽然有compose方法，但是前一个的Function.identity并没有任何方法，因为identity仅仅是返回一个方法，所以也就执行了squared这一个方法而已。
        System.out.println(Function.identity().compose(squared).apply(4));   //16
    }
    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println();backToString.apply("123");     // "123"
       // testFunction();
        testFunction2();

    }
}
