package com.hss.jvm.gc;

import com.hss.bean.Worker;

import java.io.IOException;

/**
 * -XX:+PrintGCDetails 输出gc详细信息
 * -XX:+UseSerialGC 使用串行gc
 * -XX:MetaspaceSize=128m 元空间大小
 * -XX:MaxTenuringThreshold=15 年轻代升到老年代的阈值
 */
public class Demo2_1 {
    /**
     * 终结器引用
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Worker worker = new Worker();
        System.out.println("创建对象..");
        System.in.read();
        worker = null;
        System.out.println("可垃圾回收..");
        System.in.read();
        System.out.println("显示gc..");
        System.gc();
    }
}
