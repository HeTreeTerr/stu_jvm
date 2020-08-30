package com.hss.collection;

import java.util.*;

/**
 * 演示Collection工具类的使用
 */
public class StuCollections {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(30);
        list.add(6);
        System.out.println("排序前：");
        for (Integer i : list){
            System.out.println(i);
        }
        Collections.sort(list);
        System.out.println("排序之后：");
        for (Integer i : list){
            System.out.println(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int r = o2 - o1;
                return r;
            }
        });
        System.out.println("----------自定义排序规则----------");
        for (Integer i : list){
            System.out.println(i);
        }
        //binarySearch  二分查找
        int i = Collections.binarySearch(list,15);
        System.out.println("出现位置下标："+i);

        //cope 复制
        List<Integer> dest = new ArrayList<Integer>(list.size());
        for (int i1 = 0; i1 < list.size(); i1++) {
            dest.add(0);
        }
        //需要两个集合的元素个数相等，不然会报错
        Collections.copy(dest,list);
        //shuffle打乱(每次执行后结果不唯一)
        Collections.shuffle(list);
        System.out.println("打乱之后："+list);

        //补充：list转为数组
        Object[] array = list.toArray();
        System.out.println("数组：");
        for (int i1 = 0; i1 < array.length; i1++) {
            System.out.println(array[i1]);
        }
        //数组转成集合
        String[] names = {"张三","李四","王五","影六"};
        //此集合是一个受限集合，不能添加和删除
        List<String> strings = Arrays.asList(names);
        for (int i1 = 0; i1 < strings.size(); i1++) {
            System.out.println(strings.get(i1));
        }

    }
}
