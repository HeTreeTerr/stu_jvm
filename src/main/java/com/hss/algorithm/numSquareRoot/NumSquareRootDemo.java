package com.hss.algorithm.numSquareRoot;

/**
 * <p>
 *
 * </p>
 *
 * @author Hss
 * @date 2022-07-29
 */
public class NumSquareRootDemo {

    public static void main(String[] args) {
        NumSquareRootDemo demo = new NumSquareRootDemo();
        int x = 8976;
        System.out.println("预期：" + (int)Math.sqrt(x));
        System.out.println("输出：" + demo.square(x));
    }

    public int square(int x){
        System.out.println("---------start--------");
        int left = 0;
        int right = x;
        int mid = -1;
        int res = 0;
        while (left <= right){
            mid = (left + right)/2;
            res = mid;
            if(mid*mid < x){
                left = mid + 1;
            }else if(mid*mid > x) {
                right = mid - 1;
            }else {
                break;
            }
        }
        if(res * res > x){
            res -= 1;
        }
        System.out.println("----------end---------");
        return res;
    }
}
