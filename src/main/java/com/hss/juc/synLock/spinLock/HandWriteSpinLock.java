package com.hss.juc.synLock.spinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * spinLock 自旋锁
 * 手动实现一个自旋锁
 */
public class HandWriteSpinLock {

    private volatile AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 锁定
     */
    public void lock(){
        do{
//            System.out.println(Thread.currentThread().getName() + "\t自旋中");
        }while (!atomicReference.compareAndSet(null,Thread.currentThread()));
    }

    /**
     * 解锁
     */
    public void unLock(){
        atomicReference.compareAndSet(Thread.currentThread(),null);
    }
}
