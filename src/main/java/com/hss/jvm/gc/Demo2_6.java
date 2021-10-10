package com.hss.jvm.gc;

import java.io.IOException;

/**
 * 使用java代码输出虚拟机内存信息
 */
public class Demo2_6 {

    public static void main(String[] args) throws IOException {
//        返回java虚拟机中的内存总量(-XX:InitialHeapSize)
        long totalMemory = Runtime.getRuntime().totalMemory();
//        返回java虚拟机试图使用的最大内存重量(-XX:MaxHeapSize)
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.in.read();
        System.out.println("TOTAL_MEMORY(-Xms)=" + totalMemory + "(字节)、" + totalMemory/(1024*1024) + "(MB)");
        System.out.println("MAX_MEMORY(-Xmx)=" + maxMemory + "(字节)、" + maxMemory/(1024*1024) + "(MB)");
    }
}
