package com.hss.synLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * jvm读写锁
 */
public class ReadWriteLock {
    /** 读写锁 要占有锁需要获取示例锁 */
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {

    }

    public void readWriteLock(){
        boolean tryLock = readWriteLock.readLock().tryLock();
    }

    public void test(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(
                System.out::println
        );
    }
}
