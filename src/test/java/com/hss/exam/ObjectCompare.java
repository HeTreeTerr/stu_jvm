package com.hss.exam;

/**
 * Object
 * == 和 equals
 */
public class ObjectCompare {

    public static void main(String[] args) {
        Object o1 = new Object();

        Object o2 = new Object();
        System.out.println(o1 == o2);

        System.out.println(o1.equals(o2));
    }
}
