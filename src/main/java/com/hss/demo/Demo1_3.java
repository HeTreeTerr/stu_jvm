package com.hss.demo;

/**
 * 局部变量的线程安全问题
 */
public class Demo1_3 {

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        sb.append(4);
        sb.append(5);
        sb.append(6);
        new Thread(()->{
            m2(sb);
        }).start();
    }

    public static void m1(){
        //线程安全。sb是方法的局部变量，并只有m1方法使用
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    //线程不安全。sb是m2的传参，传入的值受其他线程影响
    public static void m2(StringBuilder sb){
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    public static StringBuilder m3(){
        //线程不安全。sb是m3的局部变量，但是方法将sb当做返回值传回。返回值可能被其他方法操作
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
        return sb;
    }
}
