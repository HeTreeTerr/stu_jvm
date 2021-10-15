package com.hss.jvm.objectReference;

import java.lang.ref.SoftReference;

/**
 * java 对象引用
 * 软引用
 * 当堆内存快要溢出，才会清理
 * 适用场景：做急速缓存，内存充足正常，内存不足则回收掉
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class SoftReferenceDemo {

    private static  final  int _2MB = 2 * 1024 * 1024;

    public static void main(String[] args) {

//        heapAdequate();

        headShortage();
    }

    /**
     * 内存紧缺
     */
    public static void headShortage(){
        SoftReference<Byte[]> softReference = new SoftReference<>(new Byte[_2MB]);
        System.out.println("--------------内存充足-------------");
        System.out.println(softReference.get());
        //创建大对象，让内存吃紧
        Byte[] bytes = new Byte[_2MB];
        System.out.println("--------------内存吃紧-------------");
        System.out.println(softReference.get());
    }

    /**
     * 内存充足
     */
    public static void heapAdequate(){
        SoftReference<Byte[]> softReference = new SoftReference<>(new Byte[_2MB]);
        System.out.println(softReference.get());
    }

}
