package com.hss.collection;

import com.hss.bean.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * ArrayList的使用
 * 存储结构：数组，查找遍历速度快，增删慢
 */
public class StuArrayList {

    public static void main(String[] args) {
        //创建集合
        List arrayList = new ArrayList();
        //1.添加元素
        Student s1 = new Student("张三",15);
        Student s2 = new Student("李四",23);
        Student s3 = new Student("王五",19);

        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        //2.删除元素
        //arrayList.remove(new Student("张三",15));
        System.out.println("元素个数：" + arrayList.size());
        System.out.println(arrayList.toString());
        //3.遍历元素【重点】
        System.out.println("-------------使用迭代器1--------------");
        Iterator it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------使用列表迭代器2--------------");
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex()+"--"+listIterator.next());
        }
        System.out.println("-------------使用列表迭代器逆序3--------------");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previousIndex()+"--"+listIterator.previous());
        }
        //4判断 contains equals(重写) 可以返回true
        System.out.println("是否包含张三："+arrayList.contains(new Student("张三",15)));
        System.out.println("是否为空："+arrayList.isEmpty());

    }
}
