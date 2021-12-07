package com.hss.proxy.dynamicProxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 律师动态代理（cglib版）
 */
public class CglibDynamicProxyLawyer implements MethodInterceptor {

    private Object object;

    public CglibDynamicProxyLawyer(Object proxy){
        this.object = proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if(method.getName().equals("speak")){
            System.out.println("法律不允许！");
            method.invoke(object,objects);
            System.out.println("道德不允许！");
        }
        return null;
    }
}
