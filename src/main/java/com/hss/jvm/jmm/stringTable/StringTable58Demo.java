package com.hss.jvm.jmm.stringTable;

/**
 * 运行环境：win10 jkd1.8
 * jdk1.8中，方法区由堆中迁移至本地内存中；
 * 运行时常量池，存在于元空间（堆）中；
 * 字符串常量池，存在于堆中；
 */
public class StringTable58Demo {

    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
//        输出str1
        System.out.println(str1);
//        从池中拿值(池中没有，直接使用堆中的对象；池中已存在，则返回池中的值)
        System.out.println(str1.intern());
//        返回true
        System.out.println((str1 == str1.intern()) + "\n");


        String str2 = new StringBuilder("ja").append("va").toString();
//        输出str2
        System.out.println(str2);
//        从池中拿值(池中没有，直接使用堆中的对象；池中已存在，则返回池中的值)
        System.out.println(str2.intern());
        /*
        正常来说返回true，但代码返回false。为什么返回false呢？

        jvm默认会加载java.lang.System，在System类的1186行中，
        调用了sun.misc.Version.init();

        sun.misc.Version类11行中已经在字符串常量池中，放入了"java"
        private static final String launcher_name = "java";
         */
        System.out.println((str2 == str2.intern()) + "\n");
    }
}
