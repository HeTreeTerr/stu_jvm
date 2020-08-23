package com.hss.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet集合的使用
 * 存储结构：
 * 哈希表
 * （数组+链表（jdk1.7））
 * （数组+链表+红黑树（jdk1.8））
 */
public class StuHashSet {

    public static void main(String[] args) {
        //新建集合
        Set<String> hashSet = new HashSet<String>();
        //1.添加元素
        hashSet.add("刘德华");
        hashSet.add("吴亦凡");
        hashSet.add("何森森");
        System.out.println("数据个数："+hashSet.size());
        System.out.println(hashSet.toString());
        //2.删除元素
        //hashSet.remove("吴亦凡");
        //System.out.println(hashSet.toString());
        //3.遍历
        System.out.println("-------------遍历1:增强for-------------");
        for (String string : hashSet){
            System.out.println(string);
        }
        System.out.println("-------------遍历2:迭代器-------------");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //4.判断
        System.out.println(hashSet.contains("何森森"));
        System.out.println(hashSet.isEmpty());
    }

}
