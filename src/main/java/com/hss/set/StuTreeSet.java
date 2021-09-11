package com.hss.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 使用TreeSet保存数据
 * 存储结构：红黑树
 */
public class StuTreeSet {

    public static void main(String[] args) {
        //创建集合
        Set<String> treeSet = new TreeSet<String>();
        //1.添加元素
        treeSet.add("xyz");
        treeSet.add("abc");
        treeSet.add("hello");
        treeSet.add("xyz");
        System.out.println("元素个数："+treeSet.size());
        System.out.println(treeSet.toString());

        //2.删除
//        treeSet.remove("xyz");
//        System.out.println("删除后："+treeSet.size());

        //3.遍历
        System.out.println("----------------增强for---------------");
        for(String string : treeSet){
            System.out.println(string);
        }
        System.out.println("----------------使用迭代器-------------");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4.判断
        System.out.println(treeSet.contains("abc"));
    }
}
