package com.hss.exam;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author hss
 * @Date 2020/11/10 15:02:00
 */
public class Exam2 {

    private final static int i = 0;

    private static int j = 1;

    private final int k = 2;

    @Test
    public void test1(){
        System.out.println(Exam2.j);

        Exam2.j = 4;

        System.out.println(Exam2.j);
    }

    @Test
    public void test2() {
        System.out.println("---------------- 默认 排序结果-----------------");
        //TreeMap 默认排序规则：按照key的字典顺序来排序（升序）
        //createDefaultSortTreeMap();
        System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();
    }

    public void createDefaultSortTreeMap(){
        Map<String,Object> treeMap = new TreeMap<String, Object>();
        treeMap.put("aa","aa");
        treeMap.put("ee","ee");
        treeMap.put("cc","cc");
        treeMap.put("bb","bb");
        treeMap.put("dd","dd");
        Set<String> keySet = treeMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println("key:"+key+"-------------value:"+treeMap.get(key));
        }
    }

    public void createDefinitionSortTreeMap(){
        Map<Integer,Object> treeMap = new TreeMap<Integer,Object>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {//自定义排序

                return o1.compareTo(o2);
            }
        });

        treeMap.put(1,1);
        treeMap.put(5,5);
        treeMap.put(2,2);
        treeMap.put(4,4);
        treeMap.put(3,3);
        Iterator<Map.Entry<Integer, Object>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Object> next = iterator.next();
            System.out.println("key:"+next.getKey()+"------------value:"+next.getValue());
        }
    }
}
