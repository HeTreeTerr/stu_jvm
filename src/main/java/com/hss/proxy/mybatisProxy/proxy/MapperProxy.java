package com.hss.proxy.mybatisProxy.proxy;

import com.hss.proxy.mybatisProxy.pojo.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理之投鞭断流
 */
public class MapperProxy implements InvocationHandler {

    @SuppressWarnings("unchecked")
    public <T> T newInstance(Class<T> clz){
        return (T)Proxy.newProxyInstance(clz.getClassLoader(),new Class[]{clz},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(Object.class.equals(method.getDeclaringClass())){
            //诸如hashCode()、toString()、equals()等方法，将target指向当前this
            return method.invoke(this,args);
        }
        //投鞭断流
        return new User((Integer) args[0],"zhangsan",18);
    }
}
