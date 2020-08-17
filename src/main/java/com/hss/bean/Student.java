package com.hss.bean;

/**
 * 学生示例类
 */
public class Student {

    private String name;

    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        //1.判断是不是同一个对象
        if(this == obj){
            return true;
        }
        //2.判断是否为空
        if(null == obj){
            return false;
        }
        //3.判断是否是student类型
        if(obj instanceof Student){
            Student s = (Student) obj;
            //4.比较属性
            if(this.name.equals(s.getName()) && this.age == s.getAge()){
                return true;
            }
        }
        //不满足条件返回false
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
