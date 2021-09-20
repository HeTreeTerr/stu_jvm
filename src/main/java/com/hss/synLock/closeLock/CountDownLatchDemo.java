package com.hss.synLock.closeLock;

import com.hss.synLock.enums.NationEunm;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch使用演示
 * 秦灭六国
 * 让秦国等六国灭亡
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t 国被灭");
                countDownLatch.countDown();
            },String.valueOf(NationEunm.getNationName(i))).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦灭六国，一统华夏");
    }
}
