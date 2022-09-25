package com.hss.juc.thread.yield;

/**
 * 线程关键字yield：
 * yield 礼让
 */
public class StuYield {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new YieldThread1(),"线程1");
        Thread thread2 = new Thread(new YieldThread2(thread1),"线程2");
        //设置优先级
        thread1.setPriority(5);
        thread2.setPriority(10);
        thread1.start();
        thread2.start();
    }
}

class YieldThread1 implements Runnable{

    private Thread thread2;

    public YieldThread1(){

    }

    public YieldThread1(Thread thread2){
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {

            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}

class YieldThread2 implements Runnable{

    private Thread thread1;

    public YieldThread2(){

    }

    public YieldThread2(Thread thread1){
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if(i == 40){
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}