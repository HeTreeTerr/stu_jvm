package com.hss.operator;

/**
 * java 基础运算符
 */
public class BasicOperator {

    private final static int a = 54;

    /** 2的3次幂 */
    private final static int b = 2 *2 *2 *2;

    public static void main(String[] args) {
        BasicOperator basicOperator = new BasicOperator();
        // 位运算(&)
        //basicOperator.bitOperation();

        // 与运算(|)
        //basicOperator.andOperation();

        // 左移(<<)
        //basicOperator.shiftLeft();

        // 右移(>>)
        //basicOperator.rightLeft();

        // X % 2^n = X & (2^n – 1)
        basicOperator.surplusBit();
    }

    /**
     * 公式验证：
     * X % 2^n = X & (2^n – 1)
     */
    public void surplusBit(){
        System.out.println("\n=======%和&公式验证=======");
        // X / 2^n 等价于 X >> n, X % 2^n 等价于保留X 2进制的后n位
        Integer surplusResult = a % b;
        // 2^n – 1 二进制数后n为是1, &运算后等价于保留X 2进制的后n位
        Integer bitResult = a & (b -1);

        System.out.println(Integer.toBinaryString(surplusResult));
        System.out.println(Integer.toBinaryString(bitResult));
        System.out.println(surplusResult == bitResult);
    }

    /**
     * 右移(>>)
     * 二进制数，向右移动n位
     * 等价于 除以2的n次幂
     */
    public void rightLeft(){
        System.out.println("\n=======>>=======");
        int result = a >> 2;
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("c=00" + Integer.toBinaryString(result));
    }

    /**
     * 左移(<<)
     * 二进制数，向左移动n位
     * 等价于 乘以2的n次幂
     */
    public void shiftLeft(){
        System.out.println("\n=======<<=======");
        int result = a << 2;
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("c=" + Integer.toBinaryString(result));
    }

    /**
     * 与运算(|)
     * 二进制数对比
     * 任意一项是1则为1
     * 都是0则为0
     */
    public void andOperation(){
        System.out.println("\n=======|=======");
        int result = a | (b-1);
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("b=00" + Integer.toBinaryString(b-1));
        System.out.println("c=" + Integer.toBinaryString(result));
    }

    /**
     * 位运算(&)
     * 二进制数对比
     * 都是1则为1
     * 否则为0
     */
    public void bitOperation(){
        System.out.println("\n=======&=======");
        int result = a & (b - 1);
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("b=00" + Integer.toBinaryString(b-1));
        System.out.println("c=000" + Integer.toBinaryString(result));
    }
}
