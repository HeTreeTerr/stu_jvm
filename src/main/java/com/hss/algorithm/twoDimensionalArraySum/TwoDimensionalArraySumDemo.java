package com.hss.algorithm.twoDimensionalArraySum;

/**
 * 二维数组求和
 * 侧面验证：CPU高速缓存
 */
public class TwoDimensionalArraySumDemo {

    private static final int RUNS = 100;

    private static final int DIMENSION_1 = 1024 * 1024;

    private static final int DIMENSION_2 = 6;

    private static long[][] longs;

    public static void main(String[] args) {
        System.out.println("\n=====Array初始化...=====");
        longs = new long[DIMENSION_1][];
        for (int i = 0; i < DIMENSION_1; i++) {
            longs[i] = new long[DIMENSION_2];
            for (int j = 0; j < DIMENSION_2; j++) {
                longs[i][j] = 1L;
            }
        }
        System.out.println("\n=====一维驱动二维遍历...=====");
        long sum = 0L;
        long start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {
            for (int j = 0; j < DIMENSION_1; j++) {
                for (int k = 0; k < DIMENSION_2; k++) {
                    sum += longs[j][k];
                }
            }
        }
        System.out.println("spend time1" + (System.currentTimeMillis() - start));
        System.out.println("sum1:" + sum);

        System.out.println("\n=====二维驱动一维遍历...=====");
        sum = 0L;
        start = System.currentTimeMillis();
        for (int i = 0; i < RUNS; i++) {
            for (int j = 0; j < DIMENSION_2; j++) {
                for (int k = 0; k < DIMENSION_1; k++) {
                    sum += longs[k][j];
                }
            }
        }
        System.out.println("spend time2" + (System.currentTimeMillis() - start));
        System.out.println("sum2:" + sum);
    }
}
