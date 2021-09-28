package com.hss.jvm.classLoader;

/**
 * 参考资料：https://zhuanlan.zhihu.com/p/73078336
 * 类加载机制
 * 1.字节码
 * 2.类加载过程
 *
 * 3.双亲委派模型
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        ClassLoader loader = ClassLoaderDemo.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
            /*
            sun.misc.Launcher$AppClassLoader@18b4aac2(应用类加载器)
            sun.misc.Launcher$ExtClassLoader@7bfcd12c(扩展类加载器)
             */
        }
    }
}
