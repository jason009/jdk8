package com.wpx.jdk.base.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wpx on 2018/4/7.
 */
public class ConcurrentHashMapTest {
    static int fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        System.out.println("Calculating f(" + i + ")");
        return fibonacci(i - 2) + fibonacci(i - 1);
    }

    /**
     * JDK 1.8 实现方式
     * 声明cache之后，通过Map.computeIfAbsent() 方法，
     * 可以在key所对应的value值不存在的情况下，计算一个新的value值。
     * 超高速缓存（Caching）！由于这个方法是自动执行的，而且我们使用了 ConcurrentHashMap对象，
     * 这个缓存是线程安全的，不需要手动的去写同步方法。另外，它不仅仅可以处理斐波那契额数列，在其他地方也可以被重复使用。
     * @param i
     * @return
     */
    static int fibonacciWithCache1_8(int i) {
        Map<Integer, Integer> cache = new ConcurrentHashMap<>();
        if (i == 0 || i == 1) {
            return i;
        }
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("Calculating f(" + i + ")");
            return fibonacci(i - 2) + fibonacci(i - 1);
        });

    }

    /**
     * JDK 1.7 实现方式
     * @param i
     * @return
     */
    static int fibonacciWithCache1_7(int i) {
        Map<Integer, Integer> cache = new ConcurrentHashMap<>();
        if (i == 0 || i == 1) {
            return i;
        }
        Integer result = cache.get(i);
        if(null == result) {
            synchronized (cache){
                System.out.println("slow caculation of" + i );
                result = fibonacci(i - 2) + fibonacci(i - 1);
                cache.put(i,result);
            }
        }
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("Calculating f(" + i + ")");
            return fibonacci(i - 2) + fibonacci(i - 1);
        });

    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("f(" + i + ") = " + fibonacciWithCache1_8(i));
        }
    }
}
