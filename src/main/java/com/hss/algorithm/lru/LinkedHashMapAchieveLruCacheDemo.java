package com.hss.algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 手写lru算法
 * 使用LinkedHashMap实现
 */
public class LinkedHashMapAchieveLruCacheDemo extends LinkedHashMap<Object,Object> {

    /** 缓存坑位 */
    private int capacity;

    public LinkedHashMapAchieveLruCacheDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Object,Object> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LinkedHashMapAchieveLruCacheDemo lruCacheDemo = new LinkedHashMapAchieveLruCacheDemo(3);
//        1.空间充足时，按照顺序入队
        lruCacheDemo.put(1,"a");
        lruCacheDemo.put(2,"b");
        lruCacheDemo.put(3,"c");
        System.out.println(lruCacheDemo.keySet());
//        2.当key被操作后（get/put），热度变高
        lruCacheDemo.get(1);
        lruCacheDemo.put(2,"b");
        System.out.println(lruCacheDemo.keySet());
//        3.当位置不够时，删除热度最低的键，再将新的键入队
        lruCacheDemo.put(4,"d");
        System.out.println(lruCacheDemo.keySet());
    }
}
