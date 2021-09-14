package com.hss.collection.threadUnsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * 深入了解Array为什么线程不安全
 */
public class UnsafeArrayList {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        /**
         * arrayList的底层是数组，默认大小是10。
         * 如果数组空间不够，会自动进行扩容。
         * 核心代码如下：
         * //判断当前数组空间是否够用，如果不够在当前空间基础上扩容1.5倍。够用则不扩容
         * ensureCapacityInternal(size + 1);
         * //在数组元素的下一个下标上赋值
         * elementData[size++] = e;
         *
         * 单线程场景中可以保证数据安全；
         * 多线程中不安全原因：
         * 1：当前集合中有9个值。如果集合中存够10个值，会触发第一次扩容。
         * 存在A、B线程，都向集合中添加元素。
         * A读取数组元素有9个，B也读取数组元素有9个。两个线程都不会扩容。
         * A向elementData[9++] 位置成功赋值
         * B向elementData[10++] 位置赋值，发现数组最大下标是9。发生数组越界异常
         *
         * 2：size++ 没有保证原子性。可拆分成两步：
         * elementData[size] = e;
         * size = size + 1;
         * A线程在赋值后size没有来得及+1，
         * B线程直接读取到size
         * 导致A和B线程的值都被指向arr[size]位置
         * arr[size+1]位置的值是null
         */

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    list.add(Integer.valueOf(i).toString());
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000 ; i++) {
                    list.add(Integer.valueOf(i).toString());
                }
            }
        }).start();

        Thread.sleep(1000);

        for(int i = 0; i < list.size(); i++){
            System.out.println("arr[" + i + "]==" + list.get(i));
        }
    }
}
