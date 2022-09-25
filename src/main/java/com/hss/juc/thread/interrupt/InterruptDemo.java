package com.hss.juc.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        InterruptDemo interruptDemo = new InterruptDemo();
//        interruptDemo.demo1();
        interruptDemo.demo2();
    }

    /**
     * demo1 可以得出：
     * interrupt设置线程中断，isInterrupted去判断线程是否中断，也返回true
     * 只是变更了标志位，线程并没有真正停止
     * @throws InterruptedException
     */
    public void demo1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true){

            }
        }, "t1");

        t1.start();
        t1.interrupt();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(t1.isInterrupted());
    }

    public void demo2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("interrupted,exit!");
                    break;
                }
            }
        }, "t1");
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();
    }
}
