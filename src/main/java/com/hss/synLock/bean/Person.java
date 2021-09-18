package com.hss.synLock.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 用户类
 */
public class Person{
    //ReentrantLock
    private final ReentrantLock lock = new ReentrantLock();

    private String name;

    private String age;

    public String getName() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t run getName");
        lock.unlock();
        return name;
    }

    public String getAge() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t  run getAge");
        lock.unlock();
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