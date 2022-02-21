package com.hss.jvm.objectCreation;

import com.hss.bean.Address;
import org.openjdk.jol.info.ClassLayout;

/**
 * 计算对象大小
 * 启用指针压缩:­XX:+UseCompressedOops(默认开启)，
 * 禁止指针压缩:­XX:­UseCompressedOops
 */
public class CalculateObjectSize {

    public static void main(String[] args) {

        ClassLayout classLayout = ClassLayout.parseInstance(new Object());
        System.out.println(classLayout.toPrintable());
/*
java.lang.Object object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)//mark word标记字段
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)//mark word标记字段
      8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)//Klass Pointer类型指针
     12     4        (loss due to the next object alignment)
Instance size: 16 bytes
Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
 */

        ClassLayout classLayout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(classLayout1.toPrintable());
/*
[I object internals:
 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
      0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)//mark word
      4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)//mark word
      8     4        (object header)                           6d 01 00 f8 (01101101 00000001 00000000 11111000) (-134217363)//Klass Pointer
     12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)//数组长度，只有数组对象才有
     16     0    int [I.<elements>                             N/A
Instance size: 16 bytes
Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
 */

        ClassLayout classLayout2 = ClassLayout.parseInstance(new Address());
        System.out.println(classLayout2.toPrintable());
/*
com.hss.bean.Address object internals:
 OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
      0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)//mark word
      4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)//mark word
      8     4                    (object header)                           68 ce 00 f8 (01101000 11001110 00000000 11111000) (-134164888)//Klass Pointer
     12     4   java.lang.String Address.province                          null
     16     4   java.lang.String Address.city                              null
     20     4   java.lang.String Address.county                            null
Instance size: 24 bytes
Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
 */
    }
}
