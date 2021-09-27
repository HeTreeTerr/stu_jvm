package com.hss.thread.providerConsumer.blockingQueueV3;

import java.util.concurrent.TimeUnit;

public class ProviderConsumerV3 {

    public static void main(String[] args) throws InterruptedException {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            shareResource.provider();
        },"t1").start();

        new Thread((
        )->{
            shareResource.consumer();
        },"t2").start();

        TimeUnit.SECONDS.sleep(10);
        shareResource.stop();
    }
}
