package com.hss.jvm.gc;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示弱引用（只要gc就会触发弱引用对象回收）
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * Minor GC(年轻代gc)现象：清除出可以存放新对象的空间，不全部清除
 * Major GC/Full GC现象：将所有的弱引用对象回收
 */
public class Demo2_3 {

    private static int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) {
        //弱
        //weakReference();
        //弱，配合引用队列
        weakReferenceQueue();
    }
    //弱引用
    public static void weakReference(){
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            //定义弱引用对象
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[_4MB]);
            System.out.println((i+1)+"---");
            list.add(weakReference);
            for(WeakReference<byte[]> ref : list){
                System.out.println(ref.get()+" ");
            }
        }
        System.out.println("循环结束："+list.size());
        for(WeakReference<byte[]> weakReference : list){
            System.out.println(weakReference.get());
        }
    }
    //弱引用，配合引用队列使用
    public static void weakReferenceQueue(){
        List<WeakReference<byte[]>> list = new ArrayList<>();
        //定义引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 10; i++) {
            //定义弱引用对象
            WeakReference<byte[]> weakReference = new WeakReference<>(new byte[_4MB],queue);
            System.out.println((i+1)+"---");
            list.add(weakReference);
            for(WeakReference<byte[]> ref : list){
                System.out.println(ref.get()+" ");
            }
            Reference<? extends byte[]> poll = queue.poll();
            while (poll != null){
                list.remove(poll);
                poll = queue.poll();
            }
        }
        System.out.println("循环结束："+list.size());
        for(WeakReference<byte[]> weakReference : list){
            System.out.println(weakReference.get());
        }
    }
}
