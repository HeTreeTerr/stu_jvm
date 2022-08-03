package com.hss.algorithm.sequence;

/**
 * <p>
 * 希尔排序
 * </p>
 *
 * @author Hss
 * @date 2022-08-03
 */
public class HillSort {

    public static void main(String[] args) {
        /*
        7 -> gap->3 1
        15 48 99 55 66 78 1 - 0

         */
        int[] numArr = {15, 48, 99, 55, 66, 78, 1};
        int j;
        for (int gap = numArr.length/2; gap > 0; gap/=2) {
            //System.out.println(gap);
           for (int i = gap; i < numArr.length; i++) {
                //System.out.println(numArr[i] + "--" +numArr[i+gap]);
                int tmp = numArr[i];
                for (j = i; j >= gap && tmp < (numArr[j - gap]); j -= gap) {
                    numArr[j] = numArr[j - gap];
                }
               numArr[j] = tmp;
            }
        }
        System.out.println(numArr);
    }
}
