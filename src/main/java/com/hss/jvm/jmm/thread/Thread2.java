package com.hss.jvm.jmm.thread;

import com.hss.jvm.jmm.Demo1_2;

public class Thread2 extends Thread {

    //覆写run方法
    public void run() {
        System.out.println("---start with Thread2");
        Demo1_2.m1();
        System.out.println("---end with Thread2");
    }
}
