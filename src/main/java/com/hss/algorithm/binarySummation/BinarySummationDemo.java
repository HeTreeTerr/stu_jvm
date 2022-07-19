package com.hss.algorithm.binarySummation;

/**
 * 二进制求和
 */
public class BinarySummationDemo {

    public static void main(String[] args) {
        BinarySummationDemo demo = new BinarySummationDemo();
        String  a = "1011", b = "0111";
        //System.out.println(demo.addBinary1(a,b));

        System.out.println(demo.addBinary2(a,b));
    }

    /**
     * 核心实现
     * 使用java自带的进制转换实现，但是数据太大时容易溢出
     * @param a
     * @param b
     * @return
     */
    public String addBinary1(String a, String b) {
        Long res = Long.parseLong(a,2) + Long.parseLong(b,2);
        //System.out.println(res);
        return Long.toBinaryString(res);
    }

    /**
     * 核心实现
     * 使用string实现进制相加，冯二进一
     * @param a
     * @param b
     * @return
     */
    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int n = Math.max(a.length(),b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append(carry%2);
            carry /= 2;
        }
        if(carry > 0){
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }
}
