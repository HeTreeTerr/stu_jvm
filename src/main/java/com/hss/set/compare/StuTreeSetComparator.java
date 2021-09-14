package com.hss.set.compare;

import com.hss.bean.Person;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet集合
 * Comparator:实现定制比较（比较器）
 * Comparable:可比较的
 */
public class StuTreeSetComparator {

    public static void main(String[] args) {
        //创建集合,自定义比较规则
        Set<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
            //先按姓名比，然后再按年龄比
            @Override
            public int compare(Person o1, Person o2) {
                int n1 = o1.getName().compareTo(o2.getName());
                int n2 = o1.getAge() - o2.getAge();
                return n1!=0? n1:n2;
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

    }
}
