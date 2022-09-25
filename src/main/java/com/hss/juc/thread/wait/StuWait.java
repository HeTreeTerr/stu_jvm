package com.hss.juc.thread.wait;

/**
 * 线程关键字wait:
 * 因为wait需释放锁，所以必须在synchronized中使用
 * （没有锁定怎么可以释放？没有锁时使用会抛出IllegalMonitorStateException（正在等待的对象没有锁））
 */
public class StuWait {

    public static void main(String[] args) throws InterruptedException {
        WaitThread1 waitThread1 = new WaitThread1();
        Thread thread1 = new Thread(waitThread1,"Thread1");

        synchronized (thread1){
            System.out.println(Thread.currentThread().getName() + "正在start...");
            thread1.start();
            System.out.println(Thread.currentThread().getName() + "正在wait...");
            //thread1.wait(3000);
            thread1.wait();
            System.out.println(Thread.currentThread().getName() + "跳出wait...");
        }
    }
}

/**
 * 线程一
 */
class WaitThread1 implements Runnable{

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(5000); //  使当前线阻塞 1 s，确保主程序的 t1.wait(); 执行之后再执行 notify()
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" call notify()");
            // 唤醒当前的wait线程
            this.notify();
        }
    }
}
