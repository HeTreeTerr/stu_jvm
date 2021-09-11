package com.hss.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LinkedHashMap集合使用
 * 数据结构：双向链表+[数组+链表+红黑树]
 * 继承了hashMap，在hashMap的基础上维护了一个双向链表，来保证顺序
 * 这里accessOrder设置为false，表示不是访问顺序而是插入顺序存储的，
 * 这也是默认值，表示LinkedHashMap中存储的顺序是按照调用put方法插
 * 入的顺序进行排序的。
 */
public class StuLinkedHashMap {

    public static void main(String[] args) {
        //第三个参数用于指定accessOrder值
        Map<Object, Object> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("aaa","123");
        linkedHashMap.put("bbb","456");
        linkedHashMap.put("ccc","789");

        System.out.println("开始时顺序：");
        Set<Map.Entry<Object, Object>> set = linkedHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Object, Object> entry = iterator.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println(key+"----------"+value);
        }
        //获取值
        linkedHashMap.get("aaa");

        System.out.println("结束时顺序：");
        Set<Map.Entry<Object, Object>> set2 = linkedHashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            Map.Entry<Object, Object> entry = iterator2.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println(key+"----------"+value);
        }
    }
}
