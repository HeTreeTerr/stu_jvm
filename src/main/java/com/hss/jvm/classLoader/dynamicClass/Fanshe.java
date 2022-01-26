package com.hss.jvm.classLoader.dynamicClass;

import com.hss.bean.Person;

/**
 * 通过反射获取对象实例
 */
public class Fanshe {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.hss.bean.Person");
        Person person = (Person) aClass.newInstance();
        person.setAge(10);
        System.out.println(person);
    }
}
