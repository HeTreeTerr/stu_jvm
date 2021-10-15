package com.hss.jvm.objectReference;

/**
 * java 对象引用
 * 强引用
 * 宁愿堆内存溢出，都不清理
 * -XX:+PrintGCDetail -verbose:gc
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;

        System.out.println("-----------gc 前----------");
        System.out.println(o2);

        System.out.println("-----------gc----------");
        System.gc();

        System.out.println("-----------gc 后----------");
        System.out.println(o2);
    }
}
