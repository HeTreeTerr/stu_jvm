package com.hss.synLock.readWriteLock;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * jvm读写锁
 */
public class ReadWriteLock {
    /** 读写锁 要占有锁需要获取实例锁 */
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws IOException, InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread thread1 =  new Thread("thread1"){
          public void run(){
              readWriteLock.writeLock();
          }
        };

        Thread thread2 =  new Thread("thread2"){
            public void run(){
                readWriteLock.readLock();
            }
        };

        thread1.start();
        Thread.sleep(500);
        thread2.start();
    }

    public void readLock(){
        //尝试获取读锁
        System.out.println(Thread.currentThread().getName()+"尝试获取锁");
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"读操作---start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读操作---end");
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void writeLock(){
        //尝试获取写锁
        System.out.println(Thread.currentThread().getName()+"尝试获取锁");
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"写操作---start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写操作---end");
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
