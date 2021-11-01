package com.hss.juc.synLock.stuSynchronized;

public class Test1 {

    private int i = 0;
    private static int j = 0;
    private final Test1 instance = new Test1();

    //对成员变量加锁，必须获得该类的示例对象的锁，才能进入同步块
    public synchronized void add1(){
        i++;
    }

    public static synchronized void add2(){
        j++;
    }

    public void method(){
        synchronized (Test1.class){
            //同步块，执行前必须获得Test1类的锁
        }

        synchronized (instance){
            //同步块，执行前必须先获得示例对象的锁
        }
    }
}
