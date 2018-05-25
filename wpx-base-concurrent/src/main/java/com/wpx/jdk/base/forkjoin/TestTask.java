package com.wpx.jdk.base.forkjoin;

import com.jd.trans.utils.common.utils.ThreadPoolUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/25
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */
public class TestTask {
    private static List<Integer> getData(int len) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= len; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        for (int j=0;j<20; j++){
            ThreadPoolUtil.execute(new Runnable() {
                @Override
                public void run() {
                    long begin = System.currentTimeMillis();
                    System.out.println(System.currentTimeMillis());
                    ForkJoinPool pool = new ForkJoinPool();
                    Task task = new Task(getData(100));
                    Future<Integer> result = pool.submit(task);
                    try {
                        System.out.println("time=" + (System.currentTimeMillis() - begin) + "| result=" + result.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
