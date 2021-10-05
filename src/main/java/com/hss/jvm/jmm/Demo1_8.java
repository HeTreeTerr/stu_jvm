package com.hss.jvm.jmm;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示堆内存溢出
 * java.lang.OutOfMemoryError: Java heap space
 * -Xmx8m
 */
public class Demo1_8 {

    public static void main(String[] args){
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
