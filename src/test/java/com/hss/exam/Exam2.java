package com.hss.exam;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author hss
 * @Date 2020/11/10 15:02:00
 */
public class Exam2 {

    private final static int i = 0;

    private static int j = 1;

    private final int k = 2;

    private final List<Object> list = new ArrayList<Object>();

    @Test
    public void test1(){
        System.out.println(Exam2.j);

        Exam2.j = 4;

        System.out.println(Exam2.j);
        //报错，final修饰的变量不可变
        //k = 2;

        list.add(1);
    }

    /**
     * 1.无下标
     * 2.不允许重复
     * 3.无序（指不保证先进先出）
     */
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
        Iterator<Map.Entry<String, Object>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println("key:"+next.getKey()+"-------------value:"+next.getValue());
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

    @Test
    public void test3(){
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        //存值
        concurrentHashMap.put("111","111");
        concurrentHashMap.put("222","222");
        concurrentHashMap.put("333","333");
        //获取值
        System.out.println(concurrentHashMap.get("333"));
        //遍历
        Iterator<Map.Entry<String, Object>> iterator = concurrentHashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println("key:"+entry.getKey()+"------------------value:"+entry.getValue());
        }
        //判断
        System.out.println(concurrentHashMap.isEmpty());
        //System.out.println(concurrentHashMap.);
        System.out.println(concurrentHashMap.remove("333"));
    }
}
