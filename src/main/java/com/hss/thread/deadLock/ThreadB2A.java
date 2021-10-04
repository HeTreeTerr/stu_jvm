package com.hss.thread.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * 持有B的锁，想获取A的锁
 */
public class ThreadB2A implements Runnable {

    private String A;
    private String B;

    public ThreadB2A(String a, String b) {
        A = a;
        B = b;
    }

    @Override
    public void run() {
        synchronized(B){
            System.out.println(Thread.currentThread().getName() + "\t持有B，想要获取A");
            try {
                //模拟逻辑处理耗时
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A){
                System.out.println(Thread.currentThread().getName() + "\t获得A");
            }
        }
    }
}
