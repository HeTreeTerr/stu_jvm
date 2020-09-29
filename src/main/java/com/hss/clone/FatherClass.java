package com.hss.clone;

import java.io.*;

public class FatherClass implements Serializable,Cloneable{

    private String name;
    private int age;
    private Integer abjAge;
    private ChildClass childClass;

    /*@Override
    protected Object clone() throws CloneNotSupportedException {
        FatherClass cloneFather = (FatherClass) super.clone();
        //cloneFather.childClass = (ChildClass)this.childClass.clone();
        return cloneFather;
    }*/



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

    public Integer getAbjAge() {
        return abjAge;
    }

    public void setAbjAge(Integer abjAge) {
        this.abjAge = abjAge;
    }

    public ChildClass getChildClass() {
        return childClass;
    }

    public void setChildClass(ChildClass childClass) {
        this.childClass = childClass;
    }

    @Override
    public String toString() {
        return "FatherClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", abjAge=" + abjAge +
                ", childClass=" + childClass +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

       /* try {
            FatherClass fatherClass = new FatherClass();
            fatherClass.setName("name");
            fatherClass.setAge(50);
            fatherClass.setAbjAge(50);
            ChildClass childClass = new ChildClass();
            childClass.setAge(50);
            childClass.setName("cName");
            childClass.setObjAge(50);
            fatherClass.childClass = childClass;
            FatherClass clone = (FatherClass)fatherClass.clone();
            System.out.println(fatherClass.toString());

            fatherClass.setAge(40);
            fatherClass.setAbjAge(40);
            fatherClass.getChildClass().setObjAge(40);
            fatherClass.getChildClass().setAge(40);
            System.out.println(fatherClass.toString());
            System.out.println(clone.toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }*/
        FatherClass fatherClass = new FatherClass();
        fatherClass.setName("name");
        fatherClass.setAge(50);
        fatherClass.setAbjAge(50);
        ChildClass childClass = new ChildClass();
        childClass.setAge(50);
        childClass.setName("cName");
        childClass.setObjAge(50);
        fatherClass.setChildClass(childClass);

        /**
         * 深拷贝：序列化
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(fatherClass);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        FatherClass clone = (FatherClass)objectInputStream.readObject();

        fatherClass.setAge(40);
        fatherClass.setAbjAge(40);
        fatherClass.getChildClass().setObjAge(40);
        fatherClass.getChildClass().setAge(40);
        System.out.println(fatherClass.toString());
        System.out.println(clone.toString());
    }
}
