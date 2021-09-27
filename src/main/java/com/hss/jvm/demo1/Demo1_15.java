package com.hss.jvm.demo1;

public class Demo1_15 {

    public static void main(String[] args){
//        String x = "ab";
        //堆 new String("a") new String("b") new String("ab")
        String s = new String("a")+new String("b");//new String("ab")
        //将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则放入串池
        String s2 = s.intern();//

        System.out.println(s2 == "ab");
        System.out.println(s == "ab");
    }
}
