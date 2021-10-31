package com.hss.thread.providerConsumer.lockV2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源类
 */
class ShareObjV2{
    private Integer share = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * 加
     */
    public void inResource(){
        lock.lock();
        try {
            /*
            多线程环境下，需要用while来判定，以防止出现假唤醒
             */
            while (share != 0){
                condition.await();
            }
            share++;
            System.out.println(Thread.currentThread().getName() + "\t" + share);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 减
     */
    public void deResource(){
        lock.lock();
        try {
            /*
            多线程环境下，需要用while来判定
             */
            while (share == 0){
                condition.await();
            }
            share--;
            System.out.println(Thread.currentThread().getName() + "\t" + share);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
