package com.hss.jvm.objectReference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * java 对象引用
 * 虚引用
 * 与其他几种引用不同，虚引用并不会决定对象的生命周期。
 * 如果一个对象仅持有虚引用，那么它就和任何引用一样，在
 * 任何时候都可能被垃圾回收器回收，它不能单独使用也不能
 * 通过它访问对象，引用对象必须和引用队列(ReferenceQueue)
 * 联合使用
 * -XX:+PrintGCDetails -verbose:gc
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference<Object> reference = new PhantomReference<>(new Object(),queue);
        System.out.println("-----------gc 前------------");
//        不能通过虚引用访问对象
        System.out.println(reference.get());
        System.out.println(queue.poll());

        System.out.println("------------gc-----------");
        System.gc();

        System.out.println("-----------gc 后------------");
        System.out.println(reference.get());
//        垃圾回收后，对象并不会第一时间被清除，而是会进入引用队列中
        System.out.println(queue.poll());
    }
}
