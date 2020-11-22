package com.hss.collection.map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap基础学习
 */
public class StuConcurrentHashMap {

    public static void main(String[] args) {
        Map<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        //存值
        concurrentHashMap.put("111","111");
        concurrentHashMap.put("222","222");
        //判断
        System.out.println(concurrentHashMap.isEmpty());
        System.out.println(concurrentHashMap.containsKey("111"));
        //遍历
        Set<Map.Entry<String, Object>> set = concurrentHashMap.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey()+"------------"+entry.getValue());
        }
        //移除
        concurrentHashMap.remove("222");
    }
}
