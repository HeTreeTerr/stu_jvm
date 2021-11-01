package com.hss.juc.synLock.syncCompareLock;

/**
 * 题目：synchronized和lock的区别？用新的lock有什么好处？你举例说说
 * 1.原始构成
 * synchronized是关键字，属于jvm层面
 *      monitorenter(底层是通过monitor对象来完成，其实wait/notify等方法也依赖monitor对象。
 *      只有在同步块或者方法中才能掉wait/notify等方法)
 *      monitorexit
 * lock是具体类(java.util.concurrent.locks.lock)是api层面的锁
 *
 * 2.使用方面
 * synchronized不需要用户手动释放锁，当synchronized代码执行完后，系统会自动让线程释放对锁的占用
 * ReentrantLock则需要用户去手动释放锁，若没有主动释放锁，就有可能出死锁现象。
 * 需要lock()和unLock()方法配合try/finally语句快来完成。
 *
 * 3.等待是否可中断
 * synchronized不可中断，除非抛出异常或者正常运行完成。
 * ReentrantLock可中断。
 *      1.设置超时方法 tryLock(Long timeout, TimeUnit unit)
 *      2.lockInterruptibly()放代码中，调用interrupt()方法可中断
 *
 * 4.加锁是否公平
 * synchronized是非公平锁。
 * ReentrantLock两者都可以，默认公平锁，构造方法可以传入boolean值，true是公平锁，false为非公平锁
 *
 * 5.锁绑定多个条件Condition
 * synchronized没有
 * ReentrantLock用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像synchronized要么随机唤醒一个
 * 线程，要么唤醒全部线程。
 *
 * 举例：
 * 使用lock，实现aa,bb,cc三个线程轮流去打印东西5次、10次、15次，循环5轮
 */
public class SyncCompareLockDemo {

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareResource.print5();
            }
        },"t1").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareResource.print10();
            }
        },"t2").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                shareResource.print15();
            }
        },"t3").start();
    }
}