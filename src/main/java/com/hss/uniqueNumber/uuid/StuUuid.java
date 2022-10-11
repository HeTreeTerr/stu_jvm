package com.hss.uniqueNumber.uuid;

import java.util.UUID;

/**
 * uuid
 * 获取32为随机码
 *
 * 生成策略：
 * UUID的方式能生成一串唯一随机32位长度数据，它是无序的一串数据，按照开放软
 * 件基金会(OSF)制定的标准计算，UUID的生成用到了以太网卡地址、纳秒级时间、
 * 芯片ID码和许多可能的数字。
 *
 * 格式：
 * UUID 的十六个八位字节被表示为 32个十六进制数字，以连字号分隔的五组来显示，
 * 形式为 8-4-4-4-12，总共有 36个字符(即三十二个英数字母和四个连字号)。
 *
 * 结论：
 * UUID的底层是由一组32位数的16进制数字构成，是故 UUID 理论上的总数为16的32次方
 * 所以这足够我们的使用了，也能够保证唯一性。
 */
public class StuUuid {

    public static void main(String[] args) {
        String lId = UUID.randomUUID().toString().replace("-","");

        System.out.println(lId);

        System.out.println(lId.length());
    }
}

