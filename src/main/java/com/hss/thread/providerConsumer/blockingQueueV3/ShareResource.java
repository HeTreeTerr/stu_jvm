package com.hss.thread.providerConsumer.blockingQueueV3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 共享资源类
 */
public class ShareResource {
    /**
     * 是否可以生产消费
     */
    private volatile Boolean flag = true;

    private volatile AtomicInteger integer = new AtomicInteger();
    /**
     * 定义阻塞队列
     */
    private volatile BlockingQueue<Integer> queue;

    /**
     * 构造器
     */
    public ShareResource(){
        this(new ArrayBlockingQueue<Integer>(3));
    }

    public ShareResource(BlockingQueue queue) {
        this.queue = queue;
    }

    /**
     * 生产者
     */
    public void provider(){
        Integer obj;
        while (flag){
            //生产
            try {
                obj = integer.getAndAdd(1);
                if(queue.offer(obj,3,TimeUnit.SECONDS)){
                    System.out.println(Thread.currentThread().getName() + "\t生产\t"
                            + obj);
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t flag关闭,停止生产");
    }

    /**
     * 消费者
     */
    public void consumer(){
        Integer obj;
        while (flag){
            //消费
            try {
                obj = queue.poll(3,TimeUnit.SECONDS);
                if(obj != null){
                    System.out.println(Thread.currentThread().getName() + "\t消费\t"
                            + obj);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t flag关闭同时队列为空,停止消费");
    }

    /**
     * 停止
     */
    public void stop(){
        System.out.println(Thread.currentThread().getName() + "\t stop");
        this.flag = false;
    }
}
