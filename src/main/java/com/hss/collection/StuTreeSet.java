package com.hss.collection;

import java.util.Set;
import java.util.TreeSet;

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
        treeSet.remove("xyz");
        System.out.println("删除后："+treeSet.size());

        //3.遍历
        System.out.println("----------------增强for---------------");
        for(String string : treeSet){
            System.out.println(string);
        }
    }
}
