package com.hss.collection.threadUnsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 深入了解Array为什么线程不安全
 *
 * arrayList的底层是数组，默认大小是10。
 * 如果数组空间不够，会自动进行扩容。
 * 核心代码如下：
 * //判断当前数组空间是否够用，如果不够在当前空间基础上扩容1.5倍。够用则不扩容
 * ensureCapacityInternal(size + 1);
 * //在数组元素的下一个下标上赋值
 * elementData[size++] = e;
 *
 * 单线程场景中可以保证数据安全；
 *
 * 多线程中不安全原因：
 * t1：当前集合中有9个值。如果集合中存够10个值，会触发第一次扩容。
 * 存在A、B线程，都向集合中添加元素。
 * A读取数组元素有9个，B也读取数组元素有9个。两个线程都不会扩容。
 * A向elementData[9++] 位置成功赋值
 * B向elementData[10++] 位置赋值，发现数组最大下标是9。发生数组越界异常
 *
 * t2：size++ 没有保证原子性。可拆分成两步：
 * elementData[size] = e;
 * size = size + 1;
 *
 * A线程在赋值后size没有来得及+1，
 * B线程直接读取到size
 * 导致A和B线程的值都被指向arr[size]位置
 * arr[size+1]位置的值是null
 */
public class UnsafeArrayList {

//    private volatile static List<String> list = new ArrayList<>();

//    private volatile static List<String> list = new Vector<>();

//    private volatile static List<String> list = Collections.synchronizedList(new ArrayList<>());

    private volatile static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        /*
        1.故障现象
            java.util.ConcurrentModificationException

        2.导致原因
            并发争抢修改

        3.解决方法
            3.1 new Vector<>();
            3.2 Collections.synchronizedList(new ArrayList<>());
            3.3 new CopyOnWriteArrayList<>();
            读写分离：
            写使用ReentrantLock锁保证线程安全，拷贝一份来操作，修改结束后使用新的数组覆盖旧值
            读无限制
         */

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            },String.valueOf(i)).start();
        }
    }
}
