package com.hss.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


/**
 * jdk默认提供的线程池
 * newFixedThreadPool
 * newSingleThreadExecutor
 * newCachedThreadPool
 */
public class DefaultThreadPool {

    public static void main(String[] args) {
        ExecutorService threadPool;
//        固定线程数的线程池
        threadPool = Executors.newFixedThreadPool(2);

//        单个线程的线程池
//        threadPool = Executors.newSingleThreadExecutor();

//        没有核心线程数，所有线程都是临时线程
//        threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.submit(()->{
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            threadPool.shutdown();
        }
    }
}
