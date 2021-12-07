package com.hss.proxy.staticProxy;

import com.hss.proxy.service.Speaker;
import com.hss.proxy.service.impl.Zhangshan;

/**
 * 静态代理演示
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        Zhangshan zhangshan = new Zhangshan();
        System.out.println("==========》1.张三自己申辩");
        zhangshan.speak();
        System.out.println("==========》1.end 败诉\n");

        System.out.println("==========》2.张三请律师申辩");
        Speaker speaker = new LawyerStaticProxy();
        speaker.speak();
        System.out.println("==========》2.end 成功");
    }
}
