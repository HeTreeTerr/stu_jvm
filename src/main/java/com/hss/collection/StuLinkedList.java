package com.hss.collection;

import com.hss.bean.Student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList 使用
 * 存储结构：链表结构实现，增删快，查询慢。
 */
public class StuLinkedList {

    public static void main(String[] args) {
        //创建集合
        List<Object> linkedList = new LinkedList<Object>();
        //1.添加
        Student s1 = new Student("张三",15);
        Student s2 = new Student("李四",23);
        Student s3 = new Student("王五",19);
        linkedList.add(s1);
        linkedList.add(s2);
        linkedList.add(s3);

        System.out.println("元素个数:" + linkedList.size());
        System.out.println(linkedList.toString());

        //2.删除
//        linkedList.remove(0);
//        linkedList.remove(new Student("李四",23));
//        System.out.println("删除之后:" + linkedList.size());

        //3.遍历
        System.out.println("---------------遍历1-------------");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("---------------遍历2-------------");
        for(Object stu : linkedList){
            System.out.println((Student)stu);
        }
        System.out.println("---------------遍历3-------------");
        Iterator<Object> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            //iterator.remove();
        }
        System.out.println("---------------遍历4--------------");
        ListIterator<Object> listIterator = linkedList.listIterator();
        //正
        while (listIterator.hasNext()){
            System.out.println(listIterator.nextIndex() +"--"+ listIterator.next());
            //listIterator.remove();
        }
        //逆
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previousIndex() +"--"+ listIterator.previous());
        }
        //4.判断
        System.out.println("是否包含张三："+linkedList.contains(new Student("张三",15)));
        System.out.println("是否为空："+linkedList.isEmpty());
        //5.获取
        System.out.println(linkedList.indexOf(s1));
        System.out.println(linkedList.get(0));
    }
}
