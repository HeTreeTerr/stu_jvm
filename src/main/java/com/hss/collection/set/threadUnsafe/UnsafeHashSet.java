package com.hss.collection.set.threadUnsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 深入了解hashSet为什么线程不安全
 */
public class UnsafeHashSet {

//    private volatile static Set<String> set = new HashSet<>();

//    private volatile static Set<String> set = Collections.synchronizedSet(new HashSet<>());

    private volatile static Set<String> set = new CopyOnWriteArraySet<>();

    public static void main(String[] args) {
        /*
        1.故障现象
            java.util.ConcurrentModificationException

        2.导致原因
            并发争抢修改

        3.解决方法
            3.1 Collections.synchronizedSet(new HashSet<>())
            3.2 new CopyOnWriteArraySet<>()
         */
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName() + "\t" + set);
            },String.valueOf(i)).start();
        }
    }
}
