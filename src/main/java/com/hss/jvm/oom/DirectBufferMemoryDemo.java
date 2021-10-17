package com.hss.jvm.oom;

import java.nio.ByteBuffer;

/**
 * Direct buffer memory
 * 本地内存溢出
 * MaxDirectMemorySize表示直接内存的大小，默认是系统内存的1/4
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {
        System.out.println("配置maxDirectMemorySize:" + sun.misc.VM.maxDirectMemory()/(1024 * 1024) + "MB");

        int _1Gb = 1024 * 1024 * 1024;
//        Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println(byteBuffer);
    }
}
