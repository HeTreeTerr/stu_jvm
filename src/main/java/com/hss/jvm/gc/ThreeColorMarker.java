package com.hss.jvm.gc;

/**
 * GC原理之：三色标记
 * 1.黑色
 * 2.灰色
 * 3.白色
 *
 * GC线程和用户线程并行运行，会导致两种情况
 * 1.漏标（问题不大，下次GC清理）
 * 2.错标（严重bug，需要解决）
 *
 * 错标发生的场景：
 * 1.灰色指向白色的引用全部断开（原始快照）
 * 2.黑色指向白色的引用被建立（增量更新）
 *
 * 原始快照和增量更新的实现原理是【写屏障】
 */
public class ThreeColorMarker {

    public static void main(String[] args) {
        /*
        假定：A是黑色 BC是灰色 D是白色
        A联系到B
        A联系到C
        B联系到D
         */
        A a = new A();

        /*
        漏标：
        切断A到B的联系，B和D都需要被清理。
        但是B已经是灰色，B无法被回收
          */
        a.b = null;

        /*
        错标：
        切断B到D的联系，再建立A到D的联系。此时D不是垃圾
        但由于B到D的联系断开，A已经被标记为黑色，所以D无法被继续标记，最终被清理
         */
        D d = a.b.d;
        a.b.d = null;
        a.d = d;
    }

}

class A{
    B b = new B();
    C C = new C();
    D d = null;

    A(){
        System.out.println("A加载...");
    }
}

class B{
    D d = new D();

    B(){
        System.out.println("B加载...");
    }
}

class C{

    C(){
        System.out.println("C加载...");
    }
}

class D{

    D(){
        System.out.println("D加载...");
    }
}