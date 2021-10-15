package com.hss.jvm.objectReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * java 对象引用
 * 虚引用
 *
 * -XX:+PrintGCDetails -verbose:gc
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<Object> reference = new PhantomReference<>(o1,queue);
        System.out.println(reference.get());
    }
}
