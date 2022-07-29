package com.hss.operator;

/**
 * <p>
 * java 占位符
 * %d代表整数，比如int，long
 * %s代表字符串，String
 * %f代表浮点数，比如float，double
 * %b布尔型，比如true
 * </p>
 *
 * @author Hss
 * @date 2022-07-29
 */
public class Placeholder {

    public static void main(String[] args) {
        int integer = 0;
        String str = "zs";
        float pointNum = 1F;
        System.out.printf("整数:%d\n", integer);
        System.out.printf("字符串:%s\n", str);
        System.out.printf("浮点数:%f\n", pointNum);
        System.out.printf("布尔型:%b\n", true);
    }
}
