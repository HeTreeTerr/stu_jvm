package com.hss.juc.synLock.enums;

/**
 * 国家
 */
public enum NationEunm {
    QI(1,"齐"),
    CHU(2,"楚"),
    YAN(3,"燕"),
    HAN(4,"韩"),
    ZHAO(5,"赵"),
    WEI(6,"魏");

    private int code;

    private String name;

    NationEunm(int code,String name){
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getNationName(Integer code){
        NationEunm[] values = NationEunm.values();
        for(int i = 0; i < values.length; i++){
//            System.out.println(values[i].code + "--" +values[i].name);
            if(code.equals(values[i].code)){
                return values[i].name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        NationEunm.getNationName(0);
    }
}
