package com.hss.cas;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * 自旋消耗cpu：
 * CAS核心实现是获取值A作为预期值
 * 满足预期更新值
 * 不满足，通过while重复尝试
 * 如果重复尝试，一直不能满足预期值，则会一直占用cpu
 *
 * 解决方法：破坏掉for死循环，当超过一定时间或者一定次数时
 * ，return退出。JDK8新增的LongAddr,和ConcurrentHashMap类似的方法。
 * 当多个线程竞争时，将粒度变小，将一个变量拆分为多个变量，达到多个线程访问
 * 多个资源的效果，最后再调用sum把它合起来。
 */
public class SpinConsumptionDemo {

    public static void main(String[] args) {

        SpinConsumptionDemo consumptionDemo = new SpinConsumptionDemo();
        //LongAddr
        consumptionDemo.testLongAddr();
    }

    private void testLongAddr(){
        /*
        底层维护：
        成员变量 transient volatile long base;
            在开始没有竞争的情况下，将累加值累加到base
            在cells初始化的过程中，cells不可用，这时会尝试将值累加到base上
        成员变量 transient volatile Cell[] cells;
            AtomicInteger只有一个value，所有线程累加都要通过cas竞争value这一个变量，高并发下线程争用非常严重；
            在没有竞争的情况不会用到cells数组，这时使用base做累加，有了竞争后cells数组就上场了，第一次初始化长度
            为2，以后每次扩容都是变为原来的两倍，直到cells数组的长度大于等于当前服务器cpu的数量为止就不在扩容（CPU
            能够并行的CAS操作的最大数量是它的核心数），每个线程会通过线程对cells[threadLocalRandomProbe%cells.length]
            位置的Cell对象中的value做累加，这样相当于将线程绑定到了cells中的某个cell对象上。
        成员变量 transient volatile int cellsBusy;
            cellsBusy作用是当要修改cells数组时加锁，防止多线程同时修改cells数组，0为无锁，1为加锁，加锁的状况有三种
            cells数组初始化的时候
            cells数组扩容的时候
            如果cells数组中某个元素为null，给这个位置创建新的Cell对象的时候
         */
        LongAdder longAdder = new LongAdder();
        longAdder.add(1L);
        longAdder.add(2L);
        System.out.println(longAdder.sum());
    }
}
