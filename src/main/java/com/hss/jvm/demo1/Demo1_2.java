package com.hss.jvm.demo1;

import com.hss.jvm.demo1.thread.Thread1;
import com.hss.jvm.demo1.thread.Thread2;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_2 {

    public static void main(String[] args){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

    public static void m1(){
        int x=0;
        for(int i=0; i<50; i++){
            x++;
        }
        System.out.println(x);
    }
}
