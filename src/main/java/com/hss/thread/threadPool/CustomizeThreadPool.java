package com.hss.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 */
public class CustomizeThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,//核心线程数
                2,//临时线程数
                1,//等待时长
                TimeUnit.SECONDS,//等待单位
                new LinkedBlockingQueue<>(2),//等待队列类型及大小
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.DiscardOldestPolicy()//拒绝策略
                /*
                四大拒绝策略
                ThreadPoolExecutor.AbortPolicy 中止策略，线程池没有位置，直接抛出异常
                ThreadPoolExecutor.CallerRunsPolicy 调用者运行策略，线程池没有位置，有主线程执行
                ThreadPoolExecutor.DiscardPolicy 丢弃策略，丢弃不能处理的策略
                ThreadPoolExecutor.DiscardOldestPolicy 丢弃最久等待策略
                 */
        );

        try{
            for (int i = 1; i <= 10; i++) {
                final int fini = i;
                poolExecutor.submit(()->{
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t执行任务--" + fini);
                        TimeUnit.SECONDS.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            poolExecutor.shutdown();
        }
    }
}
