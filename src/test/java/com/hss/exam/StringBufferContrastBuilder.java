package com.hss.exam;

import org.junit.Test;

/**
 * String
 * StringBuffer
 * StringBuilder
 * 对比
 */
public class StringBufferContrastBuilder {

    /**
     * value 本质上是一个 char 类型数组
     * 被 final 修饰，一旦定义则不可变（浪费内存）
     */
    @Test
    public void string(){
        String s1 = new String("z3");
        System.out.println(s1);
    }

    /**
     * value 本质上是一个 char 类型数组
     * append 等方法，本质上是操作 char 数组（节省内存）
     * 核心方法被 synchronized 修饰，可以保证并发安全
     */
    @Test
    public void stringBuffer(){
        StringBuffer s1 = new StringBuffer("l4");
        s1.append("jojo");
        System.out.println(s1);
    }

    /**
     * value 本质上是一个 char 类型数组
     * append 等方法，本质上是操作 char 数组（节省内存）
     * 不能保证并发安全
     */
    @Test
    public void stringBuilder(){
        StringBuilder s1 = new StringBuilder("w5");
        s1.append("12138");
        System.out.println(s1);
    }
}
