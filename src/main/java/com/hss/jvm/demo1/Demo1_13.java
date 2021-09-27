package com.hss.jvm.demo1;

//StringTable["a" ,"b","ab"] hashtable 结构，不能扩容
public class Demo1_13 {
    /**
     * javap -v Demo1_13.class(查看class文件)
     * 常量池中的信息，都会被加载到运行时常量池中，这时a b ab 都是常量池中的符号，
     * 还没有变为java字符串对象
     * ldc #2 会把a符号变为"a"字符串对象
     * ldc #3 会把b符号变为"b"字符串对象
     * ldc #4 会把ab符号变为"ab"字符串对象
     */
    public static void main(String[] args){
        String s1 = "a";//懒惰的
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;//new StringBuilder().append("a").append("b").toString();

        String s5 = "a"+"b";//javac在编译期间的优化，结果已经在编译期间确定为abd
        //s3在常量池中值是ab,s4是new出的String对象，在堆中值为ab
        System.out.println(s4 == s3);
        System.out.println(s5 == s3);
    }
}
