package com.hss.jvm.objectReference;

import java.lang.ref.WeakReference;

/**
 * java 对象引用
 * 弱引用
 * 只要发生GC，就会回收对象
 * 使用场景：用于对内存变化敏感的场景
 * -XX:+PrintGCDetails -verbose:gc
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {

//        happenGC();

        unHappenGC();
    }

    /**
     * 发生GC
     */
    public static void unHappenGC(){
        WeakReference<Object> reference = new WeakReference<>(new Object());
        System.out.println(reference.get());

        System.gc();
        System.out.println("-------------gc------------");

        System.out.println(reference.get());
    }

    /**
     * 不发生GC
     */
    public static void happenGC(){
        WeakReference<Object> reference = new WeakReference<>(new Object());
        System.out.println(reference.get());
    }
}
