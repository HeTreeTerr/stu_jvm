package com.hss.jvm.classLoader.myClassLoader;

import java.lang.reflect.Method;

/**
 * 自定义类加载器测试
 */
public class MyClassLoaderTest {

    public static void main(String[] args) throws Exception {
        /*
        初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类
        加载器的父加载 器设置为应用程序类加载器AppClassLoader
         */
        MyClassLoader classLoader = new MyClassLoader("E:/data");
        //在data目录下，创建 com/hss/classLoader目录，提供User1.class
        Class<?> aClass = classLoader.loadClass("com.hss.classLoader.User1");
        //创建实例
        Object obj = aClass.newInstance();
        //获取声明方法，并执行
        Method method = aClass.getDeclaredMethod("sout", null);
        method.invoke(obj,null);

        System.out.println("==========自定义类加载器==========");
        System.out.println(aClass.getClassLoader().getClass().getName());
    }
}
