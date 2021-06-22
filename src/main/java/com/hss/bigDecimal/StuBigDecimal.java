package com.hss.bigDecimal;

import java.math.BigDecimal;

public class StuBigDecimal {

    public static void main(String[] args) {
        //保额(amount)
        BigDecimal amount = new BigDecimal("12344.00");
        //费率(fee)(单位:%)
        BigDecimal fee = new BigDecimal("1.00");
        // 保费(calAmt)=保额(amount)先乘以保险费率(fee)/100，小数点后保留两位，再往后的值直接裁掉
        BigDecimal calAmt = amount.multiply(fee).divide(new BigDecimal(100))
                .setScale(2, BigDecimal.ROUND_DOWN);

        System.out.println(calAmt);
    }
}
