package com.hss.threadLocal;

import com.hss.util.PermissionUtil;
import com.hss.util.ThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

public class StuThreadLocal {

    public static void main(String[] args) {
        new Thread(new Thread1(),"t1").start();
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
