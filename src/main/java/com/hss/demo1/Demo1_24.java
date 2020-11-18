package com.hss.demo1;

import java.io.IOException;
import java.nio.ByteBuffer;

public class Demo1_24 {

    static int _1Gb = 1024 * 1024 * 1024;

    /**
     * -XX:+DisableExplicitGC 禁用显式的垃圾回收
     */
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1Gb);
        System.out.println("分配完毕...");
        System.in.read();
        System.out.println("开始回收...");
        byteBuffer = null;
        System.gc();//显式的垃圾回收，full Gc
        System.in.read();
    }
}
