package com.hss.algorithm.sequence;

/**
 * <p>
 * 直接插入排序
 * </p>
 *
 * @author Hss
 * @date 2022-07-29
 */
public class DirectInsertionSort {

    public static void main(String[] args) {
        /*
        78 15 24 66 55 33 -0
        15 78 24 66 55 33 -1
        15 24 78 66 55 33 -2
        15 24 66 78 55 33 -3
        15 24 55 66 78 33 -4
        15 24 33 55 66 78 -5
         */
        int[] numArr = {78, 15, 24, 66, 55, 33};
        for (int i = 1; i < numArr.length; i++) {
            int curInt = numArr[i];
            int tmpIndex = -1;
            //System.out.println("[0-" + i + "]--" + curInt);
            for(int j = 0; j < i;j++){
                if(curInt < numArr[j]){
                    tmpIndex = j;
                    break;
                }
            }
            if(tmpIndex > -1){
                for(int k = i; k > tmpIndex; k--){
                    numArr[k] = numArr[k-1];
                }
                numArr[tmpIndex] = curInt;
            }
        }
        System.out.println(numArr);
    }
}
