package com.hss.collection.set.treeSet;

import com.hss.bean.Person;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 使用TreeSet保存数据
 * 存储结构：红黑树
 * 要求：元素必须要实现Comparable接口,
 * compareTo()方法返回值为0,认为是重复元素
 */
public class StuTreeSetObjectParam {

    public static void main(String[] args) {

        //元素需要实现Comparable，并覆盖compareTo方法
        //Set<Person> treeSet = new TreeSet<Person>();

        //创建集合
        Set<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
            //先按姓名比，然后再按年龄比
            @Override
            public int compare(Person o1, Person o2) {
                int n1 = o1.getName().compareTo(o2.getName());
                int n2 = o1.getAge() - o2.getAge();
                return n1 != 0 ? n1 : n2;
            }
        });
        //1.添加
        Person person1 = new Person("xyz",46);
        Person person2 = new Person("hello",35);
        Person person3 = new Person("zhangsan",15);
        Person person4 = new Person("zhangsan",18);

        treeSet.add(person1);
        treeSet.add(person2);
        treeSet.add(person3);
        treeSet.add(person4);
        System.out.println("元素个数：" + treeSet.size());
        System.out.println(treeSet.toString());
        //2.删除
//        treeSet.remove(new Person("zhangsan",18));
//        System.out.println(treeSet.toString());
        //3.遍历
        System.out.println("----------------增强for----------------");
        for(Person person : treeSet){
            System.out.println(person.toString());
        }
        System.out.println("-----------------迭代器----------------");
        Iterator<Person> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4.判断
        System.out.println(treeSet.contains(new Person("zhangsan",18)));
        System.out.println(treeSet.isEmpty());
    }
}
