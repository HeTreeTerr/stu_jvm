package com.hss.demo1;

public class Demo1_17 {

    public static void main(String[] args){
        String a ="ab";
        String s = new String("a") + new String("b");
        //堆 new String("a") new String("b") new String("ab")
        //将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则放入串池，会把串池中的对象返回
        String s2 = s.intern();
        System.out.println("ab" == s);
        System.out.println("ab" == s2);
    }
}
