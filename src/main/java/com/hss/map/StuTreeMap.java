package com.hss.map;

import com.hss.bean.Person;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 学习TreeMap:
 * 存储结构：红黑树
 */
public class StuTreeMap {

    public static void main(String[] args) {
        //创建集合
        TreeMap<Person, String> treeMap = new TreeMap<Person, String>(new Comparator<Person>() {
            //先按姓名比，然后再按年龄比
            @Override
            public int compare(Person o1, Person o2) {
                int n1 = o1.getName().compareTo(o2.getName());
                int n2 = o1.getAge() - o2.getAge();
                return n1 != 0 ? n1 : n2;
            }
        });
        //1.添加元素
        Person person1 = new Person("xyz",46);
        Person person2 = new Person("hello",35);
        Person person3 = new Person("zhangsan",15);

        treeMap.put(person1,"x");
        treeMap.put(person2,"h");
        treeMap.put(person3,"z");

        System.out.println("元素个数："+treeMap.size());
        System.out.println(treeMap.toString());
        //2.删除
//        treeMap.remove(person3);
//        System.out.println("元素个数"+treeMap.size());
        //3.遍历
        System.out.println("------------使用keySet------------");
        for(Person person : treeMap.keySet()){
            System.out.println(person+"----"+treeMap.get(person));
        }
        System.out.println("-------------使用entrySet()-------");
        for(Map.Entry<Person,String> entry: treeMap.entrySet()){
            System.out.println(entry.getKey()+"---------"+entry.getValue());
        }
        //判断
        System.out.println(treeMap.containsKey(person1));
    }
}
