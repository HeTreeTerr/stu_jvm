package com.hss.jvm.demo1;

/**
 * 演示字符串自变量也是[延迟]成为对象的
 */
public class Demo1_14 {

    public static void main(String[] args){
        int x = args.length;
        System.out.println();//字符串个数

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");
        System.out.println("1");//字符串个数
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0");
        System.out.println(x);
    }
}
