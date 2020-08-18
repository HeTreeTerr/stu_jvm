package com.hss.collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Vector集合使用
 * 数组结构实现，查询快、增删慢；
 */
public class StuVector {

    public static void main(String[] args) {
        //创建集合
        Vector<String> vector = new Vector<String>();
        //1.添加元素
        /*for (int i = 0; i < 10; i++) {
            vector.add("西瓜");
        }*/
        vector.add("西瓜");
        vector.add("梨子");
        vector.add("桃子");
        vector.add("梅子");
        //2.删除
        /*vector.remove(0);
        vector.remove("梨子");
        vector.clear();*/
        //3.遍历
        System.out.println("-------------遍历1-------------");
        for(int i=0; i<vector.size(); i++){
            System.out.println(vector.get(i));
        }
        System.out.println("-------------遍历2-------------");
        for(String str : vector){
            System.out.println(str);
        }
        System.out.println("-------------遍历3-------------");
        Iterator<String> iterator = vector.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-------------遍历3-------------");
        //使用枚举器
        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
        //4.判断
        System.out.println(vector.contains("西瓜"));
        System.out.println(vector.isEmpty());
        //5.vector 其他方法
        //firsetElement、lastElement、elementAt
    }
}
