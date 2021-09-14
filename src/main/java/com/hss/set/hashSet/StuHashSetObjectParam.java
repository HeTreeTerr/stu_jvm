package com.hss.set.hashSet;

import com.hss.bean.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet集合的使用
 * 存储结构：
 * 哈希表
 * （数组+链表（jdk1.7））
 * （数组+链表+红黑树（jdk1.8））
 * 存储过程：
 * （1）根据hashcode计算保存的位置，如果此位置为空，则直接保存。如果不为空执行第二步。
 * （2）再执行equals方法。如果equals方法为true,则认为是重复，否则形成链表(单链)
 * （3）jdk1.8后，链表使用尾插，jdk1.8前链表使用头插
 */
public class StuHashSetObjectParam {

    public static void main(String[] args) {
        //新建HashSet集合
        Set<Person> personSet = new HashSet<Person>();
        //1.添加集合
        Person person1 = new Person("刘德华",46);
        Person person2 = new Person("吴亦凡",35);
        Person person3 = new Person("何森森",18);

        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person3);//重复
        //可以成功添加，重写Person的hashCode方法和equals后，会重复
        personSet.add(new Person("何森森",18));

        //2.删除操作
        //personSet.remove(person1);
        //重写Person的hashCode方法和equals，可以这样删除
        //personSet.remove(new Person("何森森",18));
        System.out.println("元素个数："+personSet.size());
        System.out.println(personSet.toString());
        //3.遍历
        System.out.println("-------------遍历1:增强for-------------");
        for (Person person : personSet){
            System.out.println(person);
        }
        System.out.println("-------------遍历2:迭代器-------------");
        Iterator<Person> iterator = personSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //4.判断
        System.out.println(personSet.contains(new Person("何森森",18)));
        System.out.println(personSet.isEmpty());
    }
}
