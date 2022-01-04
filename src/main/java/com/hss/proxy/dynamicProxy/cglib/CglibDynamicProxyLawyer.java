package com.hss.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 律师动态代理（cglib版）
 */
public class CglibDynamicProxyLawyer implements MethodInterceptor {

    public Object getInstance(Class<?> clazz) throws Exception{
        Enhancer enhancer = new Enhancer();
        //要把哪个设置为即将生成的新类父类
         enhancer.setSuperclass(clazz);
         enhancer.setCallback(this);
         return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("speak")){
            System.out.println("法律不允许！");
            methodProxy.invokeSuper(o,objects);
            System.out.println("道德不允许！");
        }
        return null;
    }
}
