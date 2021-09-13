package com.hss.cas;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
        AbaDemo abaDemo = new AbaDemo();
//        ABA问题演示
//        abaDemo.atomicIntegerTest();
//        ABA问题解决
        abaDemo.atomicStampedReferenceTest();
    }

    public void atomicIntegerTest(){
        AtomicInteger atomicInteger = new AtomicInteger(100);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            2.线程t1 ABA
            System.out.println(Thread.currentThread().getName() +
                    "\tupdate\t" + atomicInteger.compareAndSet(atomicInteger.get(),101) +
                    "\t" + atomicInteger.get());
            System.out.println(Thread.currentThread().getName() +
                    "\tupdate\t" + atomicInteger.compareAndSet(atomicInteger.get(),100) +
                    "\t" + atomicInteger.get());

        },"t1").start();

        new Thread(()->{
//            1.线程t2获取原始值
            Integer i = atomicInteger.get();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            3.尝试CAS，成功修改
            System.out.println(Thread.currentThread().getName() +
                    "\tupdate\t" + atomicInteger.compareAndSet(i,102) +
                    "\t" + atomicInteger.get());
        },"t2").start();
    }

    public void atomicStampedReferenceTest(){
//        param1:Object param2:int
        AtomicStampedReference stampedReference = new AtomicStampedReference(100, 1);
        System.out.println("-->" + stampedReference.getReference() + "\t" + stampedReference.getStamp());

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            2.线程t1 ABA
            System.out.println(Thread.currentThread().getName() +
                    "\t" + stampedReference.compareAndSet(stampedReference.getReference(),101,stampedReference.getStamp(),2) +
                    "\t" + stampedReference.getReference());
            System.out.println(Thread.currentThread().getName() +
                    "\t" + stampedReference.compareAndSet(stampedReference.getReference(),100,stampedReference.getStamp(),3) +
                    "\t" + stampedReference.getReference());

        },"t1").start();

        new Thread(()->{
//            1.线程t2获取原始的值和版本
            Integer a = (Integer)stampedReference.getReference();
            Integer stamp = stampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            3.线程t2尝试CAS，由于版本号不对，修改失败
            System.out.println(Thread.currentThread().getName() +
                    "\t" + stampedReference.compareAndSet(a,102,stamp,2) +
                    "\t" + stampedReference.getReference());
        },"t2").start();
    }
}
