package com.hss.jvm.classLoader;

import java.io.FileInputStream;

/**
 * 自定义类加载器
 * 两个核心方法：
 * loadClass(String, boolean)，实现了双亲委派机制。
 * 还有一个方法是findClass，默认实现是空方法，所以我们
 * 自定义类加载器主要是重写findClass方法。
 */
public class MyClassLoader extends ClassLoader {

    private String classPath;

    public MyClassLoader(String classPath){
        this.classPath = classPath;
    }

    /**
     * 模板模式
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
//            defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.","/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;

    }
}
