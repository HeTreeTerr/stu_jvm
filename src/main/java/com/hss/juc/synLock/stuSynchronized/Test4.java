package com.hss.juc.synLock.stuSynchronized;

/**
 * synchronized的锁消除
 */
public class Test4 {

    public void method1(){
        Object object = new Object();
        synchronized (object){
            //执行同步代码
            System.out.println("hello world.");
        }
    }

    //优化后的方法，和上面method1执行效率一样
    public void method2(){
        Object object = new Object();
        System.out.println("hello world..");
    }
}
