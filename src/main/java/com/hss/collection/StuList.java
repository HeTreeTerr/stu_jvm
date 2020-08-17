package com.hss.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * List基本使用
 */
public class StuList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String >();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add(0,"王二");
        System.out.println("list:" + list.size());
        System.out.println("-------------遍历1--------------");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("-------------遍历2--------------");
        for(String str : list){
            System.out.println(str);
        }
        System.out.println("-------------遍历3--------------");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------遍历4--------------");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex()+"--"+listIterator.next());
        }
        //判断
        System.out.println("是否包含张三："+list.contains("张三"));
        System.out.println("是否为空："+list.isEmpty());
        //获取
        System.out.println(list.get(0));

        List<Integer> listInt = new ArrayList<Integer>();
        listInt.add(10);
        listInt.add(20);
        listInt.add(30);
        listInt.add(40);
        listInt.remove((Integer)20);
    }
}
