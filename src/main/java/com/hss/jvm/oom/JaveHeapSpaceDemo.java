package com.hss.jvm.oom;

/**
 * Java heap space
 * java堆内存溢出
 * -Xms5m -Xmx5m
 */
public class JaveHeapSpaceDemo {

    public static void main(String[] args) {
        int _4MB = 4 * 1024 * 1024;
//        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        Byte[] aByte = new Byte[_4MB];
        System.out.println(aByte);
    }
}
