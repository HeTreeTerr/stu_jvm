package com.hss.jvm.jmm.objectTable;

/**
 * 8种包装类型和对象池
 * java中基本类型的包装类的大部分都实现了常量池技术(严格来说应该叫对象池，在堆上)，
 * 这些类是 Byte,Short,Integer,Long,Character,Boolean,
 * 另外两种浮点数类型的包装类则没有实现。
 * 另外 Byte,Short,Integer,Long,Character这5种整型的包装类也只是在对应值小于等于127时才可使用对象池，
 * 也即对象不负责创建和管理大于127的这些类的对象。因为一般这种比较小的数用到的概率相对较大。
 */
public class ObjectTableDemo {

    public static void main(String[] args) {
//        5种整形的包装类Byte,Short,Integer,Long,Character的对象，在值小于127时可以使用对象池
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);//输出true

//        值大于127时，不会从对象池中取对象
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);//输出false

//        用new关键词新生成对象不会使用对象池
        Integer i5 = new Integer(127);
        Integer i6 = new Integer(127);
        System.out.println(i5 == i6);//输出false
        System.out.println(i5.equals(i6));//输出true

//        Boolean类也实现了对象池技术
        Boolean boo1 = true;
        Boolean boo2 = true;
        System.out.println(boo1 == boo2);//输出true

//        浮点类型的包装类没有实现对象池技术
        Float f1 = 1.0f;
        Float f2 = 1.0f;
        System.out.println(f1 == f2);//输出false

        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1 == d2);//输出false
    }
}
