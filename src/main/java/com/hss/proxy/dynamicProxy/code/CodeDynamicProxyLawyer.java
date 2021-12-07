package com.hss.proxy.dynamicProxy.code;

import com.hss.proxy.service.Speaker;

/**
 * 律师动态代理（代码版）
 */
public class CodeDynamicProxyLawyer implements Speaker {

    private Speaker proxy;

    public CodeDynamicProxyLawyer(Speaker proxy){
        this.proxy = proxy;
    }

    @Override
    public void speak() {
        System.out.println("法律不允许！");
        proxy.speak();
        System.out.println("道德不允许！");
    }
}
