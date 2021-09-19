package com.hss.synLock.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 用户类
 * lock 使用注意点：
 * 一定要加锁几次，解锁几次，两两配对
 */
public class Person{
    //ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    private String name;

    private String age;

    public String getName() {
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t run getName");
        }finally {
            lock.unlock();
        }
        return name;
    }

    public String getAge() {
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t  run getAge");
        }finally {
            lock.unlock();
        }
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void getInfo(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t  run getInfo");
        this.getName();
        this.getAge();
        lock.unlock();
    }
}