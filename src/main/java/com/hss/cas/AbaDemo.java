package com.hss.cas;

import java.util.Date;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题简述：
 * 线程t1，将变量又A变为B，又将B变成A
 * 线程t2，使用A为预期量，CAS检查时判定没有发生改变
 * 可能会造成数据的缺失。
 *
 * 解决方法：
 * CAS还是类似于乐观锁，同数据乐观锁的方式给它加一个
 * 版本号或者时间戳。
 * 如AtomicStampedReference
 */
public class AbaDemo {

    public static void main(String[] args) {
        Integer a = 0;
        Integer stamp = 4396;
        AtomicStampedReference stampedReference = new AtomicStampedReference(a, stamp);
        System.out.println("-->" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
//        比较和替换（param1:预期值,param2：更新值,param3：预期印章,param4：更新印章）
        System.out.println("比较和替换：" + stampedReference.compareAndSet(0,1,4396,4399));
        System.out.println("-->" + stampedReference.getReference() + "\t" + stampedReference.getStamp());
    }
}
