package com.hss.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 测试Set接口的使用
 * 特点：1、无序、无下标 2、不能重复
 */
public class StuSet {

    public static void main(String[] args) {
        //创建集合
        Set<String> stringSet = new HashSet<String>();
        //1.添加元素
        stringSet.add("小米");
        stringSet.add("苹果");
        stringSet.add("魅族");
        System.out.println("数据个数："+stringSet.size());
        System.out.println(stringSet.toString());
        //2.删除元素
        //stringSet.remove("小米");
        //System.out.println(stringSet.toString());
        //3.遍历
        System.out.println("-------------遍历1:增强for-------------");
        for (String string : stringSet){
            System.out.println(string);
        }
        System.out.println("-------------遍历2:迭代器-------------");
        Iterator<String> iterator = stringSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //4.判断
        System.out.println(stringSet.contains("小米"));
        System.out.println(stringSet.isEmpty());
    }
}
