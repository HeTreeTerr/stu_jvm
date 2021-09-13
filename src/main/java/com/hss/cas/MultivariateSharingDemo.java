package com.hss.cas;


import com.hss.bean.Person;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 多变量共享一致性
 * 解决方法：
 * 使用锁
 * 或者将多个共享变量合封装成一个对象来保证原子性(AtomicRefrence)
 */
public class MultivariateSharingDemo {

    public static void main(String[] args) {

        AtomicReference<Person> atomicReference = new AtomicReference<>();

        Person z3 = new Person("张三",18);
        Person li4 = new Person("张三",18);
        System.out.println("equals\t" + z3.equals(li4));
        System.out.println("hash\t" + (z3.hashCode() == li4.hashCode()));

        atomicReference.set(z3);

        System.out.println("init\t" + atomicReference.get().toString());
//        atomicReference.compareAndSet判定和对象地址有关，和equals、hashCode方法无关
        System.out.println("update\t" + atomicReference.compareAndSet(z3,li4) + "\t" + atomicReference.get());
        System.out.println("update\t" + atomicReference.compareAndSet(z3,li4) + "\t" + atomicReference.get());
    }
}
