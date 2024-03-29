package com.hss.jvm.jmm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 演示永久代内存溢出(jdk1.6)
 * -XX:MaxPermSize=8m
 */
public class Demo1_12 extends ClassLoader{

    public static void main(String[] args){
        int j = 0;
        try {
            Demo1_12 test = new Demo1_12();
            for(int i = 0; i<10000; i++,j++){
                //ClassWriter 作用是生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                //版本号,public，类名，包名，父类，接口
                cw.visit(Opcodes.V1_6,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                //返回byte[]
                byte[] code = cw.toByteArray();
                //执行了类的加载
                test.defineClass("Class"+i,code,0,code.length);
            }
        }finally {
            System.out.println(j);
        }
    }
}
