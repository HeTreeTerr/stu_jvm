package com.hss.thread.providerConsumer.lockV2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 版本V2
 * Lock
 * await
 * signal
 * 实现一个资源，多个线程去竞争
 */
public class ProviderConsumerV2 {

    public static void main(String[] args) {

        ShareObjV2 shareObj = new ShareObjV2();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObj.inResource();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObj.deResource();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObj.inResource();
            }
        },"t3").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObj.deResource();
            }
        },"t4").start();
    }
}
