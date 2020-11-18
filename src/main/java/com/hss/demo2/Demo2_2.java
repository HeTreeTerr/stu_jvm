package com.hss.demo2;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 演示软引用（当内存紧张时回收软引用对象）
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 */
public class Demo2_2 {

    private static  final  int _4MB = 4 * 1024 * 1024;

    public static void main(String[] args) throws IOException {
        //强
        //strongCitation();
        //软
        //softReference();
        //软引用，配合引用队列
        softReferenceQueue();
    }

    //强引用
    public static void strongCitation() throws IOException {
        List<Byte[]> list = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            list.add(new Byte[_4MB]);
        }
        System.out.println("循环结束："+list.size());
        for(Byte[] b: list){
            System.out.println(b);
        }
    }
    //软引用
    public static void softReference(){
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB]);
            list.add(reference);
        }
        System.out.println("循环结束："+list.size());
        for(SoftReference<byte[]> reference : list){
            System.out.println(reference.get());
        }
    }
    //软引用，配合引用队列
    public static void softReferenceQueue(){
        List<SoftReference<byte[]>> list = new ArrayList<>();
        //引用队列
        ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            //关联了引用对象，当软引用所关联的byte[]被回收时，软引用自己会加入到queue中去
            SoftReference<byte[]> reference = new SoftReference<>(new byte[_4MB],queue);
            list.add(reference);
        }
        Reference<? extends byte[]> poll = queue.poll();
        while (poll != null){
            list.remove(poll);
            poll = queue.poll();
        }
        System.out.println("循环结束："+list.size());
        for(SoftReference<byte[]> reference : list){
            System.out.println(reference.get());
        }
    }
}
