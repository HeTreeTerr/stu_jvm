package com.hss.math.bigDecimal;

import java.math.BigDecimal;

public class StuBigDecimal {

    public static void main(String[] args) {

        //费用计算
//        countPremium();

        //比较大小
        comparisonOfSize();
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
}
