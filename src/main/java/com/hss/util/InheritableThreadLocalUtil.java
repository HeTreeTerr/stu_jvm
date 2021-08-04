package com.hss.util;

import java.util.HashMap;
import java.util.Map;

public class InheritableThreadLocalUtil {

    private static ThreadLocal<Map<String,Object>> threadLocal = new InheritableThreadLocal<>();

    public static void clearThreadLocal(){
        threadLocal.remove();
    }

    public static void setThreadLocalInfo(Map<String,Object> info){
        Map<String,Object> map = variableEmpty();
        if(null != info.get(PermissionUtil.TID)){
            map.put(PermissionUtil.TID,info.get(PermissionUtil.TID));
        }
        if(null != info.get(PermissionUtil.THEAD_NAME)){
            map.put(PermissionUtil.THEAD_NAME,info.get(PermissionUtil.THEAD_NAME));
        }
        if(null != info.get(PermissionUtil.USER_NAME)){
            map.put(PermissionUtil.USER_NAME,info.get(PermissionUtil.USER_NAME));
        }
        threadLocal.set(map);
    }

    public static Map<String,Object> getThreadLocalInfo(){
        Map<String,Object> map = (Map) threadLocal.get();
        return map;
    }

    private static Map<String,Object> variableEmpty(){
        Map map = (Map) threadLocal.get();
        if(null == map){
            map = new HashMap<>();
        }
        return map;
    }
}
