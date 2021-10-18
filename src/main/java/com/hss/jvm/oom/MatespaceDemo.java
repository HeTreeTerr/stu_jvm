package com.hss.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Matespace
 * 元空间不足
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 */
public class MatespaceDemo {

    public static void main(String[] args) {
        int i = 0;
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OmmTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }
        }catch (Exception e){
            System.out.println("---------------多少次后发生异常：" + i);
            e.printStackTrace();
        }
    }
}

class OmmTest{
    public OmmTest() {
    }
}