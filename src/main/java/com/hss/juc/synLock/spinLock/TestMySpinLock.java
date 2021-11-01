package com.hss.juc.synLock.spinLock;

import java.util.concurrent.TimeUnit;

/**
 * 测试自旋锁
 * 定义：
 * 是指尝试获取锁的线程不会立即阻塞，而是采用循环的方式去尝试获取锁，这样的好处
 * 是减少线程上下文切换的消耗，缺点是循环会消耗CPU。
 */
public class TestMySpinLock {

    private final HandWriteSpinLock lock = new HandWriteSpinLock();

    /**
     * method1 加锁
     */
    public void method1(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t lock");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
            System.out.println(Thread.currentThread().getName() + "\t unlock");
        }
    }

    public static void main(String[] args) {
        TestMySpinLock testMySpinLock = new TestMySpinLock();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                testMySpinLock.method1();
            },String.valueOf(i)).start();
        }
    }
}
