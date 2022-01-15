package com.hss.oop.inherit;

/**
 * 学生
 * oop之继承
 */
public class Student extends Person {

    /**
     * 学习
     */
    public void learn(){
        System.out.println("学习...");
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.speak();
        student.walk();
        student.learn();
    }
}
