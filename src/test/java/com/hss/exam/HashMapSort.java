package com.hss.exam;

import java.util.*;

/**
 * 实现hashMap有序排列
 */
public class HashMapSort {

    public static void main(String[] args) {
        //定义hashMap并赋值
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zhao",21);
        map.put("qian",46);
        map.put("sun",18);
        map.put("li",55);
        map.put("zhou",78);

        //定义list
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();
        //遍历map，将map中的键值对存入list中
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            list.add(entry);
        }
        //借助list方法，自定义排序规则
        list.sort((el,e2) -> el.getValue().compareTo(e2.getValue()));

        //将排好序的键值放入linkedHashMap中,保证插入顺序
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list){
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }

        System.out.println(linkedHashMap);
    }
}
