package com.hss.demo;

public class Demo1_16 {

    public static void main(String[] args){
        String s1 = "a";
        String s2 = "b";
        String s3 = "a" + "b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

        //问
        System.out.println(s3 == s4);//false
        System.out.println(s3 == s5);//true
        System.out.println(s3 == s6);//true

        String x2 = new String("c") + new String("d");//堆中
        x2.intern();//将x2【"cd"】放入串池中
        String x1 = "cd";//从串池获取先有的[cd]值

        //问，如果调换了x1和x2的位置呢，如果是jdk136呢？
        System.out.println(x1 == x2);
        /**
         *  x1,x2 [1.8]false [1.6]false
         *  x2,x1 [1.8]true [1.6]false
         */
    }
}
