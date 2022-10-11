package com.hss.uniqueNumber.snowFlake;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * 雪花算法工具类
 * 集成hutool依赖实现
 *
 * 算法原理：
 * 生成结果是一个64bit大小的整数
 * 1、1bit，默认赋0（二进制中最高位：1表示负数 0表示正数）
 * 2、41bit，时间戳（记录时间戳，毫秒级）
 * 3、10bit，工作机器id，用来记录工作机器id
 * 4、12bit，序列号（用来记录同毫秒内产生的不同id）
 *
 * 优势：
 * 1、趋势递增（生成的id按时间趋势递增）
 * 2、全局唯一（整个分布式系统内不会产生重复id）
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
