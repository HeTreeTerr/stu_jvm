package com.hss.demo;

import com.hss.bean.Worker;

import java.io.IOException;

public class Demo1_26 {

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
