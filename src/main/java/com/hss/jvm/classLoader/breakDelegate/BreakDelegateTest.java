package com.hss.jvm.classLoader.breakDelegate;

import java.lang.reflect.Method;

/**
 * 尝试打破双亲委派机制
 * MyClassLoader.loadClass中，尝试用自己改写类加载机制去
 * 加载自己写的java.lang.String.class
 */
public class BreakDelegateTest {

    public static void main(String[] args) throws Exception{

//        BreakDelegateTest.breakDelegateLoaderV1();

        BreakDelegateTest.breakDelegateLoaderV2();
    }

    /**
     * 两个相同包名和类名的类对象可以共存，因为他们的类加载器可以不一 样，所以看两个类对象是否是同一个，
     * 除了看类的包名和类名是否都相同之外，还需要他们的类 加载器也是同一个才能认为他们是同一个
     * @throws Exception
     */
    public static void breakDelegateLoaderV2() throws Exception{
        /*
        E:/data/com/hss/classLoader目录下，
        准备User1.class
         */
        BreakDelegateLoaderV2 classLoader = new BreakDelegateLoaderV2("E:/data");
        Class<?> aClass = classLoader.loadClass("com.hss.classLoader.User1");
        //创建实例
        Object obj = aClass.newInstance();
        //获取声明方法，并执行
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(obj,null);

        System.out.println("==========自定义类加载器==========");
        System.out.println(aClass.getClassLoader());

        /*
        E:/data1/com/hss/classLoader目录下，
        准备User1.class
         */
        BreakDelegateLoaderV2 classLoader1 = new BreakDelegateLoaderV2("E:/data1");
        Class<?> aClass1 = classLoader1.loadClass("com.hss.classLoader.User1");
        //创建实例
        Object obj1 = aClass1.newInstance();
        //获取声明方法，并执行
        Method method1 = aClass1.getDeclaredMethod("sout", null);
        method1.invoke(obj1,null);

        System.out.println("==========自定义类加载器==========");
        System.out.println(aClass1.getClassLoader());
    }
    /*
    运行结果：
==============test my class loader 111111=============
==========自定义类加载器==========
com.hss.jvm.classLoader.breakDelegate.BreakDelegateLoaderV2@4ca8195f

==============test my class loader 222=============
==========自定义类加载器==========
com.hss.jvm.classLoader.breakDelegate.BreakDelegateLoaderV2@b065c63
     */

    /**
     * 重写loadClass，不委派给父类
     * 尝试在自定义的类加载器中，加载java.lang.String
     * @throws Exception
     */
    public static void breakDelegateLoaderV1() throws Exception{
        BreakDelegateLoaderV1 classLoader = new BreakDelegateLoaderV1("E:/data");

        //在data目录下，创建 java.lang目录，提供String.class
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        //创建实例
        Object obj = aClass.newInstance();
        //获取声明方法，并执行
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(obj,null);
    }
    /*
    运行结果：
    java.lang.SecurityException: Prohibited package name: java.lang
        at java.lang.ClassLoader.preDefineClass(ClassLoader.java:662)
        at java.lang.ClassLoader.defineClass(ClassLoader.java:761)
     */


}