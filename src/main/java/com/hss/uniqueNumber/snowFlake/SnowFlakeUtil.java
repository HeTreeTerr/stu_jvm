package com.hss.uniqueNumber.snowFlake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 雪花算法工具类
 * 集成hutool依赖实现
 */
public class SnowFlakeUtil {

    /** 机器编号 */
    private long machineId ;
    /** 数据中心id（暂时理解为机房） */
    private long dataCenterId ;


    public SnowFlakeUtil(long machineId, long dataCenterId) {
        this.machineId = machineId;
        this.dataCenterId = dataCenterId;
    }

    /**
     * 外部调用获取SnowFlakeUtil的实例对象，确保不可变
     */
    public static SnowFlakeUtil getInstance() {
        return IdGenHolder.instance;
    }

    /**
     * 初始化构造，无参构造有参函数，默认节点都是0
     */
    public SnowFlakeUtil() {
        this(0L, 0L);
    }

    private Snowflake snowflake = IdUtil.createSnowflake(machineId,dataCenterId);

    public synchronized long id(){
        return snowflake.nextId();
    }

    public static Long getId() {
        return SnowFlakeUtil.getInstance().id();
    }

    /**
     * 成员类，SnowFlakeUtil的实例对象的保存域
     * 单例模式
     */
    private static class IdGenHolder {
        private static final SnowFlakeUtil instance = new SnowFlakeUtil();
    }

    /**
     * 生成id
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 生成唯一id
            Long id = SnowFlakeUtil.getId();
            System.out.println(String.valueOf(id));
        }
    }
}
