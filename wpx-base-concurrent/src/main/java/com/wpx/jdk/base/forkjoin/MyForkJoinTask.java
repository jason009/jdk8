package com.wpx.jdk.base.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/25
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class MyForkJoinTask<V> extends ForkJoinTask<V> {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private V value;

    private boolean success = false;

    @Override
    public V getRawResult() {
        return value;
    }

    @Override
    protected void setRawResult(V value) {
        this.value = value;
    }


    @Override
    protected boolean exec() {
        System.out.println("exec");
        return this.success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean isSuccess) {
        this.success = isSuccess;
    }


    public static void testForkJoinSubmit() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();

        task.setSuccess(true); // 是否在此任务运行完毕后结束阻塞
        ForkJoinTask<String> result = forkJoinPool.submit(task);
        result.get(); // 如果exec()返回值是false，在此处会阻塞，直到调用complete
    }

    public static void testForkJoinSubmit2() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();

        forkJoinPool.submit(task);
        Thread.sleep(1000);
    }

    public static void testForkJoinSubmit3() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                task.complete("test");
            }
        }).start();

        ForkJoinTask<String> result = forkJoinPool.submit(task);
        // exec()返回值是false，此处阻塞，直到另一个线程调用了task.complete(...)
        result.get();
        Thread.sleep(1000);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testForkJoinSubmit3();
    }

}
