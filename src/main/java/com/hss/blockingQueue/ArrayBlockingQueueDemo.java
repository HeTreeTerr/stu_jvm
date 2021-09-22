package com.hss.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列(BlockingQueue)
 * ArrayBlockingQueue 由数组结构组成的有界阻塞队列
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {
        ArrayBlockingQueueDemo arrayBlockingQueueDemo = new ArrayBlockingQueueDemo();
        //throw exception(抛出异常)
//        arrayBlockingQueueDemo.testThrowException();

        //return special value(返回指定值)
//        arrayBlockingQueueDemo.testReturnSpecialValue();

        //always blocking(一直阻塞)
//        arrayBlockingQueueDemo.testAlwaysBlocking();

        //time out exit(超时退出)
        arrayBlockingQueueDemo.testTimeOutExit();
    }

    /**
     * offer(e,time,unit)
     * poll(time,unit)
     * 无
     */
    public void testTimeOutExit(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        try {
            System.out.println("offer\t" + queue.offer("a", 3, TimeUnit.SECONDS));
            System.out.println("offer\t" + queue.offer("b", 3, TimeUnit.SECONDS));
            System.out.println("offer\t" + queue.offer("c", 3, TimeUnit.SECONDS));
            /*
            三秒内添加失败，返回false
             */
            System.out.println("offer\t" + queue.offer("d", 3, TimeUnit.SECONDS));

            System.out.println("poll\t" + queue.poll(3, TimeUnit.SECONDS));
            System.out.println("poll\t" + queue.poll(3, TimeUnit.SECONDS));
            System.out.println("poll\t" + queue.poll(3, TimeUnit.SECONDS));
            /**
             * 三秒内获取失败，返回null
             */
            System.out.println("poll\t" + queue.poll(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * put
     * task
     * 无
     */
    public void testAlwaysBlocking(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        try {
            queue.put("a");
            queue.put("b");
            queue.put("c");
            /*
            * 当想给队列中放入第四个元素是，线程阻塞，直到队列中出现空位
            */
//            queue.put("d");

            System.out.println("take\t" + queue.take());
            System.out.println("take\t" + queue.take());
            System.out.println("take\t" + queue.take());
            /**
             * 当队列为空时，线程阻塞，直到队列中有值
             */
//            System.out.println("take\t" + queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * offer
     * poll
     * peek
     */
    public void testReturnSpecialValue(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println("offer\t" + queue.offer("a"));
        System.out.println("offer\t" + queue.offer("b"));
        System.out.println("offer\t" + queue.offer("c"));
        /*
        成功入队，返回true
        队列满员，返回fasle
         */
        System.out.println("offer\t" + queue.offer("d"));

        System.out.println("poll\t" + queue.poll());
        System.out.println("poll\t" + queue.poll());
        System.out.println("poll\t" + queue.poll());
        /**
         * 队首元素出队
         * 如果队列中没有元素，返回null
         */
        System.out.println("poll\t" + queue.poll());

        /**
         * 返回队首元素，但不删除
         * 队列没有元素，返回null
         */
        System.out.println("peek\t" + queue.peek());
    }

    /**
     * add
     * remove
     * element
     */
    public void testThrowException(){
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println("add\t" + queue.add("a"));
        System.out.println("add\t" + queue.add("b"));
        System.out.println("add\t" + queue.add("c"));
        /*
         * 如果队列已满，抛出异常
         * java.lang.IllegalStateException: Queue full
         */
        System.out.println(queue.add("d"));

        System.out.println("remove\t" + queue.remove());
        System.out.println("remove\t" + queue.remove());
        System.out.println("remove\t" + queue.remove());

        /*
         * 队首元素出队，如果队列中没有元素，抛出异常
         * java.util.NoSuchElementException
         */
//        System.out.println("remove\t" + queue.remove());

        /*
         * 返回队首元素,但是不删除
         * 如果队列中没有元素，抛出异常
         * java.util.NoSuchElementException
         */
//        System.out.println("element\t" + queue.element());
    }
}
