package com.hss.map.weakHashMap;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * weakHashMap
 * 此种Map的特点是，当除了自身有对key的引用外，此key没有其他引用那么此map会自动丢弃
 * 此值，所以比较适合做缓存。
 *
 * 这种特性比较适合实现类似本地、堆内缓存的存储机制——缓存的失效依赖于GC收集器的行为
 */
public class StuWeakHashMap {

    public static void main(String[] args) throws InterruptedException {
//        定义weakHashMap
        Map<String, String> weakHashMap = new WeakHashMap<>();
//        赋予变量
        String key = new String("key");
        String value = new String ("values");
        weakHashMap.put(key,value);
//        直接输出
        System.out.println(weakHashMap);

//        key设为空后，GC后，输出
        key = null;
        System.gc();
        System.out.println(weakHashMap);
    }
}
