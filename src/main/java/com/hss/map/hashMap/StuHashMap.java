package com.hss.map.hashMap;

import com.hss.bean.Worker;

import java.util.HashMap;

/**
 * HashMap集合的使用
 * 存储结构：哈希表（数组+链表+红黑树）
 */
public class StuHashMap {

    public static void main(String[] args) {
        //创建集合
        HashMap<Worker, String> hashMap = new HashMap<Worker, String>();
        //添加元素
        Worker worker1 = new Worker("罗志祥",186);
        Worker worker2 = new Worker("范仲淹",104);
        Worker worker3 = new Worker("周杰伦",102);
        hashMap.put(worker1,"北");
        hashMap.put(worker2,"上");
        hashMap.put(worker3,"广");
        hashMap.put(worker3,"杭");

        System.out.println("元素个数"+hashMap.size());
        System.out.println(hashMap.toString());
    }
}
