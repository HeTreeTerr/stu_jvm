package com.hss.juc.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列(LinkedBlocking)
 * 由链表结构组成的有界（但大小默认值为Integet.MAX_VALUE）阻塞队列。
 */
public class LinkedBlockingQueueDemo {

    //定义LinkedBlockingQueue阻塞队列
    private static final BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

    public static void main(String[] args) {
        LinkedBlockingQueueDemo blockingQueueDemo = new LinkedBlockingQueueDemo();
        //抛出异常
//        blockingQueueDemo.testThrowException();
        //返回指定值
//        blockingQueueDemo.testSpecifiedValue();
        //阻塞
//        blockingQueueDemo.testBlocking();
        //超时退出
        blockingQueueDemo.testTimeOutExit();
    }

    /**
     * offer
     * poll
     * 无实现
     */
    public void testTimeOutExit(){
        try {
            System.out.println("offer\t" + queue.offer("a",3,TimeUnit.SECONDS));
            System.out.println("offer\t" + queue.offer("b",3,TimeUnit.SECONDS));
            System.out.println("offer\t" + queue.offer("c",3,TimeUnit.SECONDS));
            /**
             * 尝试3秒，如果尝试失败，返回false
             */
//            System.out.println("offer\t" + queue.offer("d",3,TimeUnit.SECONDS));

            System.out.println(queue.poll(3,TimeUnit.SECONDS));
            System.out.println(queue.poll(3,TimeUnit.SECONDS));
            System.out.println(queue.poll(3,TimeUnit.SECONDS));
            /**
             * 尝试3秒，如果尝试失败，返回null
             */
            System.out.println(queue.poll(3,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * put
     * task
     * 无实现
     */
    public void testBlocking(){

        try {
            System.out.println("put\ta");
            queue.put("a");
            System.out.println("put\tb");
            queue.put("b");
            System.out.println("put\tc");
            queue.put("c");

            /**
             如果队列指定空间已满，一直阻塞
             直到有新的位置
             */
//            System.out.println("put\td");
//            queue.put("d");

            System.out.println("task\t" + queue.take());
            System.out.println("task\t" + queue.take());
            System.out.println("task\t" + queue.take());
            /*
            如果队列中没有元素，一直阻塞
            直到有新的元素
             */
//            System.out.println("task\t" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * offer
     * poll
     * peek
     */
    public void testSpecifiedValue(){
        System.out.println("offer\t" + queue.offer("a"));
        System.out.println("offer\t" + queue.offer("b"));
        System.out.println("offer\t" + queue.offer("c"));
        /*
         如果超出队列长度，返回false
         */
        System.out.println("offer\t" + queue.offer("d"));

        System.out.println("poll\t" + queue.poll());
        System.out.println("poll\t" + queue.poll());
        System.out.println("poll\t" + queue.poll());
        /*
         如果队列中没有元素，返回null
         */
        System.out.println("poll\t" + queue.poll());

        System.out.println("peek\t" + queue.peek());
    }

    /**
     * add
     * remove
     * element
     */
    public void testThrowException(){
        System.out.println("add\t" + queue.add("a"));
        System.out.println("add\t" + queue.add("b"));
        System.out.println("add\t" + queue.add("c"));
        /*
         如果超出定义的容量，抛出异常
         java.lang.IllegalStateException: Queue full
         */
//        System.out.println("add\t" + queue.add("d"));

        System.out.println("remove\t" + queue.remove());
        System.out.println("remove\t" + queue.remove());
        System.out.println("remove\t" + queue.remove());

        /*
         如果队列中没有值，抛出异常
         java.util.NoSuchElementException
         */
        System.out.println("remove\t" + queue.remove());
//        System.out.println("element\t" + queue.element());
    }
}
