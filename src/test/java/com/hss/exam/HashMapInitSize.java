package com.hss.exam;

import java.util.HashMap;

/**
 * 有16个键值要放入HashMap
 * 那么HashMap的初始值应该设置为多少？
 * 考点，避免扩容
 */
public class HashMapInitSize {

    public static void main(String[] args) {
        /*
        要存入的元素个数已经确定，那么要避免扩容

        * 当n不是2的幂的时候，会根据n找到合适的数 m，并认为m是新的容量，阈值是m*0.75
        * 为了防止调用resize()，需要保证元素数量小于阈值（不可等于！）
        * 需要根据调用put(key,value)的次数count（准确的说是key不重复时），找到 第一个 比 n 大的 2的幂的数m

        判断装载因子loadFactor（默认0.75）*m是否仍然不小于count
        若满足（大于或等于），则设置为 (m/2) < n <= m
        否则（小于），设置为 (m+1) <= n  <= 2m

        例1，当我们需要在map里面装 100个元素时，已知128是第一个大于100并且是2的幂的数，但128*0.75 = 96 还是小于100，
        那么显然129-256(闭区间)作为初始化的参数更合适。
        例2，当我们需要在map里面装 80个元素时，已知128是第一个大于80并且是2的幂的数，且128*0.75 = 96 还是大于80，
        那么显然64-128(左开右闭)作为初始化的参数更合适。
        例3，当我们需要在map里面装 12个元素时，已知16是大于12并且是2的幂的数，且16*0.75 = 12 等于12，
        那么显然8-16(左开右闭)作为初始化的参数更合适。
         */
        HashMap<String, String> map = new HashMap<>(128);
        for (int i = 1; i <= 100; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
        System.out.println(map);
    }
}
