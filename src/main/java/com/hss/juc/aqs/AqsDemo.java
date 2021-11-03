package com.hss.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS原理探究
 * 带入一个银行办理业务的案例来模拟我们的AQS，如何进行线程的管理和唤醒机制
 * ReentrantLock
 *  Sync extends AbstractQueuedSynchronizer
 */
public class AqsDemo {

    public static void main(String[] args) {
//        3个线程，模拟3个来银行网点受理窗口办理业务的顾客
        ReentrantLock lock = new ReentrantLock();

//        A顾客就是第一个顾客，此实受理窗口没有任何人，A可以直接办理
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("A Thread come in");
                TimeUnit.MINUTES.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"A").start();

//        B顾客，由于受理业务的窗口只有一个（只能一个线程持有锁），此时B只能等待
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("B Thread come in");
            }finally {
                lock.unlock();
            }
        },"B").start();

//        C顾客，由于受理业务的窗口只有一个（只能一个线程持有锁），此时C只能等待
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("C Thread come in");
            }finally {
                lock.unlock();
            }
        },"C").start();
    }
}
