package com.hss.thread.join;

/**
 * 线程关键字join:
 * join在线程里面意味着“插队”
 */
public class StuJoin {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread1(),"MyThread1");
        Thread thread2 = new Thread(new MyThread2(thread1),"MyThread2");

        thread1.start();
        thread2.start();
    }
}

class MyThread1 implements Runnable{

    private Thread thread2;

    public MyThread1() {
    }

    public MyThread1(Thread thread2) {
        this.thread2 = thread2;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}

class MyThread2 implements Runnable{

    private Thread thread1;

    public MyThread2() {
    }

    public MyThread2(Thread thread1) {
        this.thread1 = thread1;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if(i==2){
                try {
                    //线程1插队
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("线程1异常");
                }
            }
            System.out.println(Thread.currentThread().getName()+"--"+i);
        }
    }
}


