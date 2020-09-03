package com.hss.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HashMap
 * 特性：存储键值key-value
 * key不重复，可为nu11。
 * value值可重复
 * 存储结构：数组+链表+红黑树（jdk1.8）
 */
public class StuHashMapStringParam {

    public static void main(String[] args) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("a","a");
        hashMap.put("b","b");
        hashMap.put("c","c");
        hashMap.put("d","d");
        hashMap.put("e","e");
        hashMap.put("f","f");
        hashMap.put("g","g");
        hashMap.put("h","h");
        hashMap.put("i","i");
        hashMap.put("j","j");
        hashMap.put("k","k");
        hashMap.put("l","l");
        hashMap.put("m","m");
        hashMap.put("n","n");
        hashMap.put("o","o");
        hashMap.put("p","p");
        hashMap.put("q","q");
        hashMap.put("r","r");
        hashMap.put("s","s");
        hashMap.put("t","t");
        hashMap.put("u","u");
        hashMap.put("v","v");
        hashMap.put("w","w");
        hashMap.put("x","x");
        hashMap.put("y","y");
        hashMap.put("z","z");

        //2.遍历
        for(String str : hashMap.keySet()){
            System.out.println(str+"----"+hashMap.get(str));
            //不能这样删，会报错：并发修改异常
            /*if("x".equals(str)){
                hashMap.remove(str);
            }*/
        }

        //2.正确删除方式
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            if("x".equals(str)){
                iterator.remove();
            }
        }

        System.out.println("-----------------操作后的结果：----------------");
        for(String str : hashMap.keySet()){
            System.out.println(str+"----"+hashMap.get(str));
        }
    }
}
