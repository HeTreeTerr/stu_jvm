package com.hss.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection基本使用
 */
public class StuCollection {

    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add("李二狗");
        collection.add("李狗蛋");
        collection.add("张三");

        System.out.println("----------遍历1-----------");
        for(Object str : collection){
            System.out.println(str.toString());
        }
        System.out.println("----------遍历2-----------");
        Iterator it = collection.iterator();
        // hasNext  next  remove
        while (it.hasNext()){
            System.out.println(it.next());
            //it.remove();
        }
        System.out.println("集合中：" + collection.size());
    }
}
