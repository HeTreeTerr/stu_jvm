package com.hss.bean;

public class Worker {

    private String name;

    private Integer idCard;

    public Worker() {
    }

    public Worker(String name, Integer idCard) {
        this.name = name;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", idCard=" + idCard +
                '}';
    }
}
