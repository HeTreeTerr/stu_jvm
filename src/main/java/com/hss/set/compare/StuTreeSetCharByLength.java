package com.hss.set.compare;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 需求：使用TreeSet集合实现字符串按照长度排序
 */
public class StuTreeSetCharByLength {

    public static void main(String[] args) {

        TreeSet<String> strings = new TreeSet<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = o1.length() - o2.length();
                int n2 = o1.compareTo(o2);
                return n1 == 0? n2:n1;
            }
        });

        strings.add("aaaa");
        strings.add("aaa");
        strings.add("bbb");
        strings.add("aaaaaaaaa");
        strings.add("aaaaaa");
        for(String str : strings){
            System.out.println(str);
        }
    }
}
