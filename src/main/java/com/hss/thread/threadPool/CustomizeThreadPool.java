package com.hss.thread.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * 线程池参数配置
 */
public class CustomizeThreadPool {

    public static void main(String[] args) {
        //获取cpu核数=12
        System.out.println(Runtime.getRuntime().availableProcessors());

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,//核心线程数
                2,//临时线程数
                1,//等待时长
                TimeUnit.SECONDS,//等待单位
                new LinkedBlockingQueue<>(2),//等待队列类型及大小
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.DiscardOldestPolicy()//拒绝策略

                /*
                核心线程数计算规则：
                CPU密集型
                一般公式：核心线程数 = CPU核数 + 1个线程的线程池（13）
                IO密集型
                一般公式：核心线程数 = CPU核数 * 2（24）
                参考公式：CPU核数/（1-阻塞系数） 阻塞系数在0.8~0.9之间
                12/（1-0.8）=60
                 */

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
