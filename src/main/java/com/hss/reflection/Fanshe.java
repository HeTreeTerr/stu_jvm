package com.hss.reflection;

import com.hss.bean.Person;

public class Fanshe {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.hss.bean.Person");
        Person person = (Person) aClass.newInstance();
        person.setAge(10);
        System.out.println(person);
    }
}
