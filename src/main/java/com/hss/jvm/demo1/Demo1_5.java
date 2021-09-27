package com.hss.jvm.demo1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

/**
 * json的数据转化
 */
public class Demo1_5 {

    public static void main(String[] args) throws JsonProcessingException {
        Dept dept = new Dept();
        dept.setName("Market");

        Emp e1 = new Emp();
        e1.setName("张");
        e1.setDept(dept);

        Emp e2 = new Emp();
        e2.setName("李");
        e2.setDept(dept);
        //无限套娃
        dept.setEmps(Arrays.asList(e1,e2));

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(dept));
    }



}
//员工
class Emp{
    private String name;
    @JsonIgnore
    private Dept dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
//部门
class Dept{
    private String name;
    private List<Emp> emps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
