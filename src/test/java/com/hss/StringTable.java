package com.hss;

public class StringTable {

    public static void main(String[] args) {
        /*String a1 = "a";//在常量池中创建a
        String a2 = "b";//在常量池中创建b
        String a3 = "ab";//在常量池中创建ab
        String a4 = "a" + "b";
        String a5 = a1 + a2;//new StringBuilder().append("a").append("b").toString();
        String a6 = new String("a") + new String("b");

        String a7 = a5.intern();

        System.out.println(a3 == a4);
        System.out.println(a3 == a5);
        System.out.println(a3 == a6);
        System.out.println(a5 == a6);
        System.out.println(a7 == a5);
        System.out.println(a7 == a3);*/
        String a1 = "ab";
        String str1 = new String("a") + new String("b");
        String str2 = str1.intern();
        System.out.println(str1 == str2);
    }
}
