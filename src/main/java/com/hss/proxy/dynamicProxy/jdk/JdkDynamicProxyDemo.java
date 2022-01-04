package com.hss.proxy.dynamicProxy.jdk;

import com.hss.proxy.service.Speaker;
import com.hss.proxy.service.impl.Zhangshan;

import java.lang.reflect.Proxy;

/**
 * 动态代理演示（jdk版）
 * 缺点：要求被代理的类必须实现接口，否则不能代理
 */
public class JdkDynamicProxyDemo {

    public static void main(String[] args) {
        Zhangshan zhangshan = new Zhangshan();
        System.out.println("==========》1.张三自己申辩");
        zhangshan.speak();
        System.out.println("==========》1.end 败诉\n");

        System.out.println("==========》2.张三请律师申辩");
        Speaker speaker = (Speaker)new JdkDynamicProxyLawyer().getInstance(zhangshan);
        speaker.speak();
        System.out.println("==========》2.end 成功");
    }
}
