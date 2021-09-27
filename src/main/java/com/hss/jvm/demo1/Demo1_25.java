package com.hss.jvm.demo1;

import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

public class Demo1_25 {
    static int _1Gb = 1024 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        Unsafe unsafe = getUnsafe();
        Long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base,_1Gb,(byte)0);
        System.out.println("分配完毕");
        System.in.read();

        System.out.println("手动清空");
        unsafe.freeMemory(base);
        System.in.read();
    }

    public static Unsafe getUnsafe(){
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe)f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
