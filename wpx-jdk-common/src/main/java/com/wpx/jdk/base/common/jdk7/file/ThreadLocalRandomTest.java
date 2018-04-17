package com.wpx.jdk.base.common.jdk7.file;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wpx on 2018/4/7.
 * ThreadLocalRandom 并发下随机数生成类，保证并发下的随机数生成的线程安全，
 * 实际上就是使用threadlocal
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        final int MAX = 100000;
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        long start = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            threadLocalRandom.nextDouble();
        }
        long end = System.nanoTime() - start;
        System.out.println("use time1 : " + end);


        long start2 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            Math.random();
        }
        long end2 = System.nanoTime() - start2;
        System.out.println("use time2 : " + end2);
    }
}
