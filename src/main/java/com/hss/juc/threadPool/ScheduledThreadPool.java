package com.hss.juc.threadPool;

import java.util.concurrent.*;

/**
 * jdk提供的线程池
 * newScheduledThreadPool
 */
public class ScheduledThreadPool {

    public static void main(String[] args) {

        /*
        1、核心线程数
        2、线程工厂
        3、拒绝策略
         */
        ScheduledThreadPoolExecutor poolExecutor = new ScheduledThreadPoolExecutor(5,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        //任务延迟3秒后处理
        /*ScheduledFuture<Integer> future = poolExecutor.schedule(() -> {
            System.out.println(Thread.currentThread().getName() + "=jojojo");
            return 1;
        }, 3, TimeUnit.SECONDS);
        Integer res = future.get();
        System.out.println(Thread.currentThread().getName() + "=" + res);*/

        //延迟1秒后执行任务，3秒调度一次（存在消息堆积）
        poolExecutor.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + "=jojojo");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,3,TimeUnit.SECONDS);

        //延迟1秒后执行任务，任务执行完以后，延迟3秒执行新任务（无消息堆积）
        /*poolExecutor.scheduleWithFixedDelay(()->{
            System.out.println(Thread.currentThread().getName() + "=jojojo");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1,3,TimeUnit.SECONDS);*/

    }

}
