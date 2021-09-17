package com.hss.synLock.tfFairLock;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁，最大程度保证等待
 * 非公平锁，吞吐量高
 */
public class TfFairLock {
    //true表示公平锁  false表示非公平锁
    private ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) throws IOException {
        TfFairLock tfFairSync = new TfFairLock();
        /**
         * new ReentrantLock()/new ReentrantLock(false)
         * 非公平锁，不能保证FIFO
         * new new ReentrantLock(true)
         * 公平锁，可以保证FIFO
         */
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                tfFairSync.fairLock();
            },String.valueOf(i)).start();
        }
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
