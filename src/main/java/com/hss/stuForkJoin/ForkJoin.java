package com.hss.stuForkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * 想要使用Fork-Jion
 * 类必须继承
 * RecursiveAction(无返回值)
 * or
 * RecursiveTask(有返回值)
 */
public class ForkJoin extends RecursiveTask<Integer> {

    private static final Integer MAX = 200;

    // 子任务开始计算的值
    private Integer start;

    // 子任务结束计算的值
    private Integer end;

    public ForkJoin(Integer start , Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // 如果条件成立，说明这个任务所需要计算的数值分为足够小了
        // 可以正式进行累加计算了
        if(end - start < MAX) {
            System.out.println("开始计算的部分：startValue = " + start + ";endValue = " + end);
            Integer sum = 0;
            for(int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        // 否则再进行任务拆分，拆分成两个任务
        else {
            ForkJoin subTask1 = new ForkJoin(start, (start + end) / 2);
            subTask1.fork();
            ForkJoin subTask2 = new ForkJoin((start + end) / 2 + 1 , end);
            subTask2.fork();
            return subTask1.join() + subTask2.join();
        }
    }

}
