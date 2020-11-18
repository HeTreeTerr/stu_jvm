package com.hss.demo2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_2 {

    private static  final  int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add(new Byte[_4MB]);
        }
        System.in.read();
        for(Byte[] b: list){
            System.out.println(b);
        }
    }
}
