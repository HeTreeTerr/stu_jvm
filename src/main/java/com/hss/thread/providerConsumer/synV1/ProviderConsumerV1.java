package com.hss.thread.providerConsumer.synV1;

/**
 * 版本V1
 * 主要实现：
 * synchronized
 * wait
 * notify
 */
public class ProviderConsumerV1 {

    public static void main(String[] args) {
        ShareObjV1 shareObjV1 = new ShareObjV1();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObjV1.inResource();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObjV1.deResource();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObjV1.inResource();
            }
        },"t3").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareObjV1.deResource();
            }
        },"t4").start();
    }
}
