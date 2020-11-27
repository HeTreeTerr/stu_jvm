package com.hss.synLock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TfFairSync {
    //true表示公平锁  false表示非公平锁
    private ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) throws IOException {
        TfFairSync tfFairSync = new TfFairSync();
        Thread thread1 = new Thread("Thread1"){
            public void run(){
                tfFairSync.fairLock();
            }
        };

        Thread thread2 = new Thread("Thread2"){
            public void run(){
                tfFairSync.fairLock();
            }
        };
        System.out.println("线程1启动");
        thread1.start();
        System.in.read();
        System.out.println("线程2启动");
        thread2.start();
    }

    public void fairLock(){
        boolean falg = false;
        try {
            falg = this.lock.tryLock(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(falg){
            try{
                System.out.println(Thread.currentThread().getName()+"--获取到锁");
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println(e.getStackTrace());
            }finally {
                lock.unlock();
            }
        }else{
            System.out.println(Thread.currentThread().getName()+"--尝试获取锁失败");
        }
    }
}
