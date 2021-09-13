package com.hss.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么？
 * compareAndSwap，比较和交换
 * 底层使用sun.misc.Unsafe
 *
 * CAS的缺点？
 * ABA问题
 * 自旋锁消耗cpu
 * 多变量共享一直行问题
 */
public class CasDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
//        如果atomicInteger等于5为true，则修改如果atomicInteger为2019
        /*System.out.println(atomicInteger.compareAndSet(5,2019) +
                "\t" + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,4396) +
                "\t" + atomicInteger.get());*/

        System.out.println(atomicInteger.incrementAndGet());
    }
}
