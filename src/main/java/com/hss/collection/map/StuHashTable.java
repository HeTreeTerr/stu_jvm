package com.hss.collection.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * 底层结构：数组+链表
 * 特点：无序、无下标、键不重复、值可以重读。
 * 不允许null作为key或value;
 * 初始大小：10,阈值0.75
 * 扩容机制：当hashTable中元素个数大于（数组大小*阈值），触发自动扩容
 * (oldCapacity << 1) + 1 原大小乘二加一
 */
public class StuHashTable {

    public static void main(String[] args) {
        Hashtable<String, Object> hashtable = new Hashtable<String, Object>();
        //存值
        Object put = hashtable.put("aaa", "111");
        Object put1 = hashtable.put("bbb", "222");
       /* Object put2 = hashtable.put("ccc", "333");
        Object put3 = hashtable.put("ddd", "444");
        Object put4 = hashtable.put("eee", "555");
        Object put5 = hashtable.put("fff", "666");
        Object put6 = hashtable.put("ggg", "777");
        Object put7 = hashtable.put("hww", "888");*/
        Object put8 = hashtable.put("llh", "999");
        //取值
        System.out.println(hashtable.get("llh"));
        //遍历
        System.out.println("---------------遍历------------");
        for(String key : hashtable.keySet()){
            System.out.println(key+"----"+hashtable.get(key));
        }
    }
}
