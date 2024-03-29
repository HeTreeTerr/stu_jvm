package com.hss.math.bigDecimal;

import java.math.BigDecimal;

public class StuBigDecimal {

    public static void main(String[] args) {

        //费用计算
//        countPremium();

        //比较大小
//        comparisonOfSize();

        //基础运算
//        basicOperations();

        //小数点
        decimalPoint();
    }

    /**
     * 费用计算
     */
    public static void countPremium(){
        //保额(amount)
        BigDecimal amount = new BigDecimal("12344.00");
        //费率(fee)(单位:%)
        BigDecimal fee = new BigDecimal("1.00");
        // 保费(calAmt)=保额(amount)先乘以保险费率(fee)/100，小数点后保留两位，再往后的值直接裁掉
        BigDecimal calAmt = amount.multiply(fee).divide(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_DOWN);

        System.out.println("费用：" + calAmt);
    }

    /**
     * 比较大小
     */
    public static void comparisonOfSize(){
        BigDecimal param1 = new BigDecimal(800);
        BigDecimal param2 = new BigDecimal(800);
        int res = param1.compareTo(param2);
        if(res == 1){
            System.out.println("p1 大于 p2");
        }else if (res == 0){
            System.out.println("p1 等于 p2");
        }else if (res == -1){
            System.out.println("p1 小于 p2");
        }

        // 0
        BigDecimal zero = BigDecimal.ZERO;
        System.out.println(zero.toString());
    }

    /**
     * 基础运算
     * 加/减/乘/除
     */
    public static void basicOperations(){
        BigDecimal param1 = new BigDecimal("10");
        BigDecimal param2 = new BigDecimal("3");
        BigDecimal res = null;
        //加
        res = param1.add(param2);
        System.out.println("p1 p2 相加 = " + res);
        //减
        res = param1.subtract(param2);
        System.out.println("p1 p2 相减 = " + res);
        //乘
        res = param1.multiply(param2);
        System.out.println("p1 p2 相乘 = " + res);
        //除（四舍五入）
        res = param1.divide(param2,BigDecimal.ROUND_HALF_UP);
        System.out.println("p1 p2 相除 = " + res);
    }

    /**
     * 小数点
     */
    public static void decimalPoint(){
        /*
        舍入模式：
        ROUND_DOWN 舍弃多余的小数位
        ROUND_UP 多余的小数位向上补
        ROUND_HALF_UP 四舍五入（5向上补）
        ROUND_HALF_DOWN 四舍五入（5向下舍）

        todo 待验证...
        ROUND_CEILING 接近正无穷大的舍入
        ROUND_FLOOR 接近负无穷大的舍入
        ROUND_HALF_EVEN 向最接近的数字舍入
         */
        BigDecimal param1 = new BigDecimal("3.1415926");
        System.out.println("小数点位数：" + param1.scale());
        //保留小数点后两位，并四舍五入
        BigDecimal res = param1.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("res = " + res);
    }
}
