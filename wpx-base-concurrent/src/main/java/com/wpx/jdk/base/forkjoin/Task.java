package com.wpx.jdk.base.forkjoin;

/**
 * @ClassName:
 * @Description:
 * @author: 慎独
 * @date: 2018/5/25
 * @mail: wangpeixuaninfo@jd.com
 * @version: v1.0
 * @since: JDK 1.7
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;

    private List<Integer> numberList;
    private int start;
    private int end;
    private int THRESHOLD = 2;

    public Task(List<Integer> numberList) {
        this.numberList = numberList;
        start = 0;
        end = this.numberList.size() - 1;
    }

    public Task(List<Integer> numberList, int start, int end) {
        this.numberList = numberList;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
           // System.out.println("start=" + start + ";end=" + end);
            return sum();
        } else {
            int pivot = (end + start) / 2;
            Task task1 = new Task(numberList, start, pivot);
            Task task2 = new Task(numberList, pivot + 1, end);
            task1.fork();
            task2.fork();
            return task1.join() + task2.join();
        }

    }

    private Integer sum() {
        Integer sum = 0;
        for (int i = start; i <= end; i++) {
            sum += this.numberList.get(i);
        }
        return sum;
    }




}