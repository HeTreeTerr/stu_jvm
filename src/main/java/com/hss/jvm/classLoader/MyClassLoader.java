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
     * 读取class文件
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
//            defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

    /**
     * 打破双亲委派机制
     * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    /*public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
        synchronized (getClassLoadingLock(name)){
            Class<?> c = findLoadedClass(name);
            if(c == null){
                long t1 = System.nanoTime();
                c = findClass(name);

                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if(resolve){
                resolveClass(c);
            }
            return c;
        }
    }*/

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
