package com.hss.synLock;

import java.util.concurrent.CountDownLatch;

/**
 * 1.countDownLatch这个类使一个线程等待其
 * 它线程各自执行完毕后再执行。
 * 2.是通过一个计数器来实现的，计数器的初
 * 始值是线程的数量。每当一个线程执行完毕后，
 * 计数器的值就-1，当计数器为0时，表示所有
 * 线程都执行完毕，然后在【闭锁】上等待的线程就
 * 可以恢复工作了。
 */
public class StuCountDownLatch {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        System.out.println("主线程开始执行————");
        //第一个子线程执行
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行..");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread1").start();
        //第二个子线程执行
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行..");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread2").start();

        System.out.println("等待两个线程执行完毕————");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个子线程都执行完毕，继续执行主线程");
    }
}
