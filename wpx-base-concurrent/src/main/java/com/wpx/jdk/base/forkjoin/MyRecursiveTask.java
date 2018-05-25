package com.wpx.jdk.base.forkjoin;

import java.util.concurrent.*;

/**
 * @ClassName:
 * @Description:
 * 1. http://tigerlchen.iteye.com/blog/1807648
 * 2. https://www.liaoxuefeng.com/article/001493522711597674607c7f4f346628a76145477e2ff82000
 * 3. http://www.importnew.com/27334.html
 * 4. http://www.infoq.com/cn/articles/fork-join-introduction
 *
 * @author: 慎独
 * @date: 2018/5/25
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class MyRecursiveTask extends RecursiveTask<Integer> {
    final int n;

    MyRecursiveTask(int n) {
        this.n = n;
    }

    private int compute(int small) {
        final int[] results = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89 };
        return results[small];
    }
    @Override
    public Integer compute() {
        if (n <= 10) {
            return compute(n);
        }
        MyRecursiveTask f1 = new MyRecursiveTask(n - 1);
        MyRecursiveTask f2 = new MyRecursiveTask(n - 2);
        /**
         * 注意：如果不invokeAll，会造成资源的浪费。
         * https://blog.csdn.net/cxl0921/article/details/76460909
         * https://www.liaoxuefeng.com/article/001493522711597674607c7f4f346628a76145477e2ff82000
         */
        invokeAll(f1, f2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }

    /**
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Long begin = System.currentTimeMillis();
        ForkJoinTask<Integer> fjt = new MyRecursiveTask(45);
        ForkJoinPool fjpool = new ForkJoinPool();
        /**
         * 异步执行,	execute(ForkJoinTask)	ForkJoinTask.fork
         * 等待获取结果,	invoke(ForkJoinTask)	ForkJoinTask.invoke
         * 执行，获取Futrue,	submit(ForkJoinTask)	ForkJoinTask.fork(ForkJoinTasks are Futures)
         */
        Future<Integer> result = fjpool.submit(fjt);

        System.out.println(result.get());
        Long end = System.currentTimeMillis();
        System.out.println("result=" + (end-begin));

        //1836311903
        //result=1094

        //1836311903
        //result=1015
    }
}
