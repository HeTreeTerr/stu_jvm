package com.hss.threadLocal;

import com.hss.threadLocal.util.PermissionUtil;
import com.hss.threadLocal.util.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

public class StuThreadLocal {

    public static void main(String[] args) {
        //启动线程1
        //new Thread(new Thread1(),"t1").start();
        //启动线程2
        new Thread(new Thread2(),"t2").start();
    }

}

class Thread1 implements Runnable{

    @Override
    public void run() {
        Map<String,Object> info = new HashMap<>();
        info.put(PermissionUtil.TID,Thread.currentThread().getId());
        info.put(PermissionUtil.THEAD_NAME,Thread.currentThread().getName());
        info.put(PermissionUtil.USER_NAME,"hss");
        ThreadLocalUtil.setThreadLocalInfo(info);

        try {
            Thread.sleep(1000);
            Map<String, Object> map = ThreadLocalUtil.getThreadLocalInfo();
            System.out.println(Thread.currentThread().getName()+ "------>"+map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        Map<String,Object> info = new HashMap<>();
        info.put(PermissionUtil.TID,Thread.currentThread().getId());
        info.put(PermissionUtil.THEAD_NAME,Thread.currentThread().getName());
        info.put(PermissionUtil.USER_NAME,"hqq");
        ThreadLocalUtil.setThreadLocalInfo(info);
        try {
            Thread.sleep(2000);
            Map<String, Object> map = ThreadLocalUtil.getThreadLocalInfo();
            System.out.println(Thread.currentThread().getName()+ "------>" +map);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
