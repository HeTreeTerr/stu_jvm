package com.hss.demo;

/**
 * 演示栈内存溢出 java.lang.StackOverflowError
 * 原因两种
 * 1.栈帧过多，导致内存不够（常见）
 * 2.单个栈帧太大（不常见）
 * -Xss256k[设定程序运行的栈内存大小]
 */
public class Demo1_4 {

    private static  int count;

    public static void main(String[] args){
        try{
            method1();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }
    }

    //递归没有终止条件
    private static void method1(){
        count++;
        method1();
    }
}
