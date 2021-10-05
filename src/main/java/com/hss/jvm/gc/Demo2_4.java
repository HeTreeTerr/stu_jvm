package com.hss.jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * GC分析
 * -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
 * |---堆空间----|-新生代-|一种垃圾回收器-|----打印垃圾回收详情-----------|
 *
 */
public class Demo2_4 {

    private static final  int _512KB = 512 * 1024;
    private static final  int _1MB = 1024 * 1024;
    private static final  int _6MB = 6 * 1024 * 1024;
    private static final  int _7MB = 7 * 1024 * 1024;
    private static final  int _8MB = 8 * 1024 * 1024;

    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        //执行一次gc
        //list.add(new byte[_7MB]);
        //执行两次gc
        //list.add(new byte[_512KB]);
        //数据晋升到老年代
        //list.add(new byte[_512KB]);


        //当要创建一个非常大的对象时（比伊甸园和to、from区域都大），直接晋升到老年代
        //list.add(new byte[_8MB]);
        //当要创建的对象太大，经过垃圾回收，老年代的空间还是不够时，直接报堆内存溢出
        //list.add(new byte[_8MB]);

        //其他线程的堆内存溢出不会导致主线程异常结束
        new Thread(){
          public void run(){
              list.add(new byte[_8MB]);
              list.add(new byte[_8MB]);
          }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 没有程序时堆的占用情况
     * Heap
     *  def new generation   total 9216K, used 2693K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)//年轻代
     *   eden space 8192K,  32% used [0x00000000fec00000, 0x00000000feea1728, 0x00000000ff400000)//伊甸园
     *   from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)//from区
     *   to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)//to区
     *  tenured generation   total 10240K, used 0K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)//老年代
     *    the space 10240K,   0% used [0x00000000ff600000, 0x00000000ff600000, 0x00000000ff600200, 0x0000000100000000)
     *  Metaspace       used 3308K, capacity 4568K, committed 4864K, reserved 1056768K//元空间
     *   class space    used 360K, capacity 392K, committed 512K, reserved 1048576K
     */
}
