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
        // 位与运算(&)
        //basicOperator.bitOperation();

        // 位或运算(|)
        //basicOperator.andOperation();

        // 异或运算符(^)
        //basicOperator.xorOperation();

        // 取反运算符(~)
        //basicOperator.negateOperation();

        // 左移(<<)
        //basicOperator.shiftLeft();

        // 右移(>>)
        //basicOperator.moveRight();

        //无符号右移(>>>)
        //basicOperator.unsignedMoveRight();

        // 复合运算
        //basicOperator.compoundOperation();

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
     * 复合运算
     */
    public void compoundOperation(){
        System.out.println("\n=======复合运算=======");
        /*
        1、&= 例：a &= b 相当于a=a & b
        2、|= 例：a |= b 相当于a=a | b
        3、>>= 例：a >>= b 相当于a=a >> b
        4、<<= 例：a <<= b 相当于a=a << b
        5、^= 例：a ^= b 相当于a=a ^ b
         */
        System.out.println("emo!!!");
    }

    /**
     * 无符号右移(>>>)
     * 表示无符号右移，也叫逻辑右移。
     * 即若该数为正，则高位补0；
     * 而若该数为负数，则右移后高位同样补0；
     */
    public void unsignedMoveRight(){
        /*System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-4));
        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-16));*/
        System.out.println("\n=======>>>=======");
        int c = 16;
        int d = -16;
        System.out.println("c=" + Integer.toBinaryString(c));
        System.out.println("C=00" + Integer.toBinaryString((c >>> 2)));

        System.out.println("d=" + Integer.toBinaryString(d));
        System.out.println("D=00" + Integer.toBinaryString((d >>> 2)));

    }

    /**
     * 右移(>>)
     * 二进制数，向右移动n位
     * 等价于 除以2的n次幂
     */
    public void moveRight(){
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
     * 取反运算符(~)
     * 二进制数，所有位取反
     */
    public void negateOperation(){
        System.out.println("\n=======~=======");
        int result = ~a;
        /*
        int 类型，占据32bit(位),4byte(字节)
         */
        System.out.println("a=00000000000000000000000000" + Integer.toBinaryString(a));
        System.out.println("c=" + Integer.toBinaryString(result));
    }

    /**
     * 异或运算符(^)
     * 二进制数，两个相应位为“异”（值不同），则该位结果为1
     * 否则为0
     */
    public void xorOperation(){
        System.out.println("\n=======^=======");
        int result = a ^ (b - 1);
        System.out.println("a=" + Integer.toBinaryString(a));
        System.out.println("b=00" + Integer.toBinaryString(b-1));
        System.out.println("c=" + Integer.toBinaryString(result));
    }

    /**
     * 与或运算(|)
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
     * 位与运算(&)
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
