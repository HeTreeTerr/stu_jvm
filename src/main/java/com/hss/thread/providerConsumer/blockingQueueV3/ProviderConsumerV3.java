package com.hss.thread.providerConsumer.blockingQueueV3;

import java.util.concurrent.TimeUnit;

public class ProviderConsumerV3 {

    public static void main(String[] args) throws InterruptedException {
        ShareResourceV3 shareResource = new ShareResourceV3();
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
