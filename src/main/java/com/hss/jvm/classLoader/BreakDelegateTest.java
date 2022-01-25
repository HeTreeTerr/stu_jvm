package com.hss.jvm.classLoader;

import java.lang.reflect.Method;

/**
 * 尝试打破双亲委派机制
 * MyClassLoader.loadClass中，尝试用自己改写类加载机制去
 * 加载自己写的java.lang.String.class
 */
public class BreakDelegateTest {

    public static void main(String[] args) throws Exception{

        MyClassLoader classLoader = new MyClassLoader("E:/data");

        //在data目录下，创建 java.lang目录，提供String.class
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        //创建实例
        Object obj = aClass.newInstance();
        //获取声明方法，并执行
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(obj,null);
    }
}
/*
运行结果：
java.lang.SecurityException: Prohibited package name: java.lang
	at java.lang.ClassLoader.preDefineClass(ClassLoader.java:662)
	at java.lang.ClassLoader.defineClass(ClassLoader.java:761)
 */