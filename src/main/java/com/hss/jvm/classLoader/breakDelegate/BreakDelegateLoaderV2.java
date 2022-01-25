package com.hss.jvm.classLoader.breakDelegate;

import java.io.FileInputStream;

public class BreakDelegateLoaderV2 extends ClassLoader{
    private String classPath;

    public BreakDelegateLoaderV2(String classPath){
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
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
        synchronized (getClassLoadingLock(name)){
            Class<?> c = findLoadedClass(name);
            if(c == null){
                long t1 = System.nanoTime();

                //非自定义的类还是走双亲委派加载
                if(!name.startsWith("com.hss.classLoader")){
                    c = this.getParent().loadClass(name);
                }else {
                    c = findClass(name);
                }
                sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                sun.misc.PerfCounter.getFindClasses().increment();
            }
            if(resolve){
                resolveClass(c);
            }
            return c;
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
