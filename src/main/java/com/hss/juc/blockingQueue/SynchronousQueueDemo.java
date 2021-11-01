package com.hss.juc.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列(SynchronousQueue)
 * SynchronousQueue 不存储元素的阻塞队列，也即单个元素的队列。
 */
public class SynchronousQueueDemo {

    //定义synchronousQueue阻塞队列
    private final static BlockingQueue<String> queue = new SynchronousQueue<>();

    public static void main(String[] args) {

        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + "\tput\t" + i);
                    queue.put(String.valueOf(i));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try {
                for (int i = 0; i < 3; i++) {
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "\ttake\t" + queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
