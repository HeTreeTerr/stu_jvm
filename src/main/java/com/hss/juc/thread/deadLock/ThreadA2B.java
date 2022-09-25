package com.hss.juc.thread.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * 持有A的锁，想获取B的锁
 */
public class ThreadA2B implements Runnable {

    private String A;
    private String B;

    public ThreadA2B(String a, String b) {
        A = a;
        B = b;
    }

    @Override
    public void run() {
        synchronized(A){
            System.out.println(Thread.currentThread().getName() + "\t持有A，想要获取B");
            try {
                //模拟逻辑处理耗时
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B){
                System.out.println(Thread.currentThread().getName() + "\t获得B");
            }
        }
    }
}
