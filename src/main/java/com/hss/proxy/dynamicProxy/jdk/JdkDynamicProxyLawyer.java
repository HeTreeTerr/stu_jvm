package com.hss.proxy.dynamicProxy.jdk;

import com.hss.proxy.service.Speaker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 律师动态代理演示（jdk版）
 */
public class JdkDynamicProxyLawyer implements InvocationHandler {

    private Object object;

    public Object getInstance(Object proxy){
        this.object = proxy;
        Class<?> clazz = object.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("speak")){
            System.out.println("法律不允许！");
            method.invoke(object,args);
            System.out.println("道德不允许！");
        }
        return null;
    }
}
