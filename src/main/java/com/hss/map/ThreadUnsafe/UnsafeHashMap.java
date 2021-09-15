package com.hss.map.ThreadUnsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 深入了解hashMap为什么线程不安全
 */
public class UnsafeHashMap {

    private volatile static Map<String,String> map = new HashMap<>();

//    private volatile static Map<String,String> map = new Hashtable<>();

//    private volatile static Map<String,String> map = Collections.synchronizedMap(new HashMap<>());

//    private volatile static Map<String,String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        /*
        1.故障现象
        java.util.ConcurrentModificationException

        2.导致原因
        高并发修改异常

        3.解决方案
        new Hashtable<>();
        Collections.synchronizedMap(new HashMap<>());
        new ConcurrentHashMap<>();
         */
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(UUID.randomUUID().toString().substring(0,8), UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName() + "\t" + map);
            },String.valueOf(i)).start();
        }
    }
}
