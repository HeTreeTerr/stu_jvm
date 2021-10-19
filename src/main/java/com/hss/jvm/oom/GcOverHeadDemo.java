package com.hss.jvm.oom;

import java.util.ArrayList;

/**
 * GC overhead limit exceeded
 * Gc回收过头
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 */
public class GcOverHeadDemo {

    public static void main(String[] args) {
        int i = 0;
        ArrayList<String> list = new ArrayList<>();

        try {
            while (true){
//                Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
                list.add(String.valueOf(++i));
            }
        }catch (Exception e){
            System.out.println("------------i=" + i);
            e.printStackTrace();
            throw e;
        }
    }
}
