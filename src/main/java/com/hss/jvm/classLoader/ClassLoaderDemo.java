package com.hss.jvm.classLoader;

import sun.misc.Launcher;

import java.net.URL;

/**
 * 类加载机制
 * 1.字节码
 * 2.类加载过程
 *
 * 3.双亲委派模型
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println("\n==============类加载器类型===========");
        System.out.println("the bootstrapLoader：" + String.class.getClassLoader());
        System.out.println("the extClassloader：" + com.sun.crypto.provider.DESedeKeyFactory.class.getClassLoader());
        System.out.println("the appClassLoader：" + ClassLoaderDemo.class.getClassLoader());

        System.out.println("\n==============双亲委派机制===============");
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
            /*
            sun.misc.Launcher$AppClassLoader@18b4aac2(应用类加载器)
            sun.misc.Launcher$ExtClassLoader@7bfcd12c(扩展类加载器)
             */
        }

        System.out.println("\n============类加载器的负责范围===========");
        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urLs.length; i++) {
            System.out.println(urLs[i]);
        }

        System.out.println("\nextClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("\nappClassLoader加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));
    }
}
