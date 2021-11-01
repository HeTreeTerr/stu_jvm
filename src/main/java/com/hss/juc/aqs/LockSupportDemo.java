package com.hss.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport
 * 线程等待唤醒机制
 * park 阻塞
 * unpark 唤醒
 */
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

//        simple();

        unParkAfterPark();
    }

    /**
     * 先unpark后park
     * @throws InterruptedException
     */
    public static void unParkAfterPark(){
        //        定义线程
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
//            睡眠3秒
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 阻塞\t" + System.currentTimeMillis());
//            被阻塞，等待唤醒放行
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t 唤醒\t" + System.currentTimeMillis());
        }, "t1");
//        启动线程
        t1.start();
//        唤醒
        LockSupport.unpark(t1);
    }

    /**
     * LockSupport简单实用
     * @throws InterruptedException
     */
    public static void simple() throws InterruptedException {
//        定义线程
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            System.out.println(Thread.currentThread().getName() + "\t 阻塞\t" + System.currentTimeMillis());
//            被阻塞，等待唤醒放行
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t 唤醒\t" + System.currentTimeMillis());
        }, "t1");
//        启动线程
        t1.start();
//        睡眠3秒
        TimeUnit.SECONDS.sleep(3);
//        唤醒
        LockSupport.unpark(t1);
    }
}
