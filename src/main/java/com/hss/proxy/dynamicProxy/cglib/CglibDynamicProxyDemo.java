package com.hss.proxy.dynamicProxy.cglib;

import com.hss.proxy.service.impl.Zhangshan;
import net.sf.cglib.proxy.Enhancer;

/**
 * 动态代理演示（cglib）
 * 第三方提供，需要引入包
 * 是对jdk动态代理的补充，不需要被代理类实现接口
 */
public class CglibDynamicProxyDemo {

    public static void main(String[] args) {
        Zhangshan zhangshan = new Zhangshan();
        System.out.println("==========》1.张三自己申辩");
        zhangshan.speak();
        System.out.println("==========》1.end 败诉\n");

        System.out.println("==========》2.张三请律师申辩");

        Zhangshan speaker = null;
        try {
            speaker = (Zhangshan)new CglibDynamicProxyLawyer().getInstance(Zhangshan.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        speaker.speak();
        System.out.println("==========》2.end 成功");
    }
}
