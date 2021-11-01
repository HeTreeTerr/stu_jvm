package com.hss.juc.providerConsumer.synV1;

/**
 * 资源类
 */
public class ShareObjV1 {

    private int share = 0;

    /**
     * 加
     */
    public synchronized void inResource(){
        try {
            while (share != 0){
               this.wait();
            }
            share++;
            System.out.println(Thread.currentThread().getName() + "\t" + share);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 减
     */
    public synchronized void deResource(){
        try {
            while (share == 0){
                this.wait();
            }
            share--;
            System.out.println(Thread.currentThread().getName() + "\t" + share);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
