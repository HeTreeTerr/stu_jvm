package com.hss.clone;

import java.io.Serializable;

public class ChildClass implements Serializable,Cloneable{

    private String name;
    private int age;
    private Integer objAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getObjAge() {
        return objAge;
    }

    public void setObjAge(Integer objAge) {
        this.objAge = objAge;
    }

    @Override
    public String toString() {
        return "ChildClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", objAge=" + objAge +
                '}';
    }

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/

    public static void main(String[] args) {
        try {
            /**
             * 浅拷贝实用：会拷贝对象的基本类型属性和String
             * 其他类型拷贝地址，公用堆中的实例
             */
            ChildClass childClass = new ChildClass();
            childClass.setAge(10);
            childClass.setObjAge(10);
            ChildClass childClassClone = (ChildClass)childClass.clone();
            System.out.println(childClass);
            childClass.setAge(5);
            childClass.setObjAge(5);
            System.out.println(childClass);
            System.out.println(childClassClone);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
