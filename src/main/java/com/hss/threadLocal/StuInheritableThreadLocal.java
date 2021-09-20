package com.hss.threadLocal;

import com.hss.threadLocal.util.InheritableThreadLocalUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal是为了绑定线程而设计的
 * 如果需要在子线程中传递参数，使用InheritableThreadLocal
 */
public class StuInheritableThreadLocal {

    public static void main(String[] args) {
        Map map = new HashMap<String,Object>();
        map.put("threadName","父线程");
        map.put("userName","hss");
        InheritableThreadLocalUtil.setThreadLocalInfo(map);

        ThreadSon threadSon = new ThreadSon();
        Thread thread = new Thread(threadSon,"子线程");
        thread.start();
    }
}

class ThreadSon implements Runnable{

    @Override
    public void run() {
        Map<String, Object> map = InheritableThreadLocalUtil.getThreadLocalInfo();
        System.out.println(map);
    }
}
