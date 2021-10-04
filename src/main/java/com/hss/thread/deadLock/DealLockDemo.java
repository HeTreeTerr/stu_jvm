package com.hss.thread.deadLock;

/**
 * 死锁
 * 产生原因：
 * 1.系统资源不足
 * 2.进程运行推进的不合适
 * 3.资源分配不当
 * 白话：两个或多个线程互相持有对方想要申请的锁，陷入无限的等待中
 * 排查方法：
 * jps命令定位进程号（jps -1）
 * jstack找到死锁查看（jstack 进程号）
 */
public class DealLockDemo {

    public static void main(String[] args) {
        String A = "A";
        String B = "B";

        new Thread(new ThreadA2B(A,B),"AA").start();
        new Thread(new ThreadB2A(A,B),"BB").start();
    }
}
