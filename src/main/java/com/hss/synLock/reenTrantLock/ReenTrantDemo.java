package com.hss.synLock.reenTrantLock;

import com.hss.synLock.bean.Person;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁（递归锁）
 * 作用：避免死锁
 * Synchronized
 * ReentrantLock
 */
public class ReenTrantDemo {

    public static void main(String[] args) {
        ReenTrantDemo trantDemo = new ReenTrantDemo();
//        Synchronized 可重入性测试
//        trantDemo.synchronizedApply(trantDemo);

//        ReentrantLock 可重入性测试
        trantDemo.reenTrantLock(trantDemo);
    }

    public void reenTrantLock(ReenTrantDemo trantDemo){
        Person person = new Person();
        new Thread(()->{
            person.getInfo();
        },"t1").start();

        new Thread(()->{
            person.getInfo();
        },"t2").start();
    }

    public void synchronizedApply(ReenTrantDemo trantDemo){
        new Thread(()->{
            trantDemo.method1();
        },"t1").start();

        new Thread(()->{
            trantDemo.method1();
        },"t2").start();
    }

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName() + "\t run method1");
        this.method2();
    }

    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName() + "\t run method2");
    }
}

