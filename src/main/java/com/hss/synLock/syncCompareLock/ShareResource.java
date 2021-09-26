package com.hss.synLock.syncCompareLock;

import com.hss.synLock.enums.FrequencyEunm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源
 */
public class ShareResource {
    /**
     * 定义资源 1-t1 2-t2 3-t3
     */
    private int resource = 1;
    /**
     * 定义可重入锁
     */
    private Lock lock = new ReentrantLock();

    /**
     * 定义三个条件（钥匙）
     */
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    /**
     * t1打印5次
     */
    public void print5(){
        //加锁
        lock.lock();
        try{
            //等待
            while (resource != 1){
                c1.await();
            }
            //打印
            print();
            //唤醒
            resource = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * t2打印10次
     */
    public void print10(){
        //加锁
        lock.lock();
        try{
            //等待
            while (resource != 2){
                c2.await();
            }
            //打印
            print();
            //唤醒
            resource = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * t3打印15次
     */
    public void print15(){
        //加锁
        lock.lock();
        try{
            //等待
            while (resource != 3){
                c3.await();
            }
            //打印
            print();
            //唤醒
            resource = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印方法
     */
    private void print(){
        //获取具体的执行次数
        int num = FrequencyEunm.getNumByTid(resource);
        for (int i = 1; i <= num; i++) {
            //输出线程和次数
            System.out.println(Thread.currentThread().getName() + "\t" + i);
        }
    }
}
