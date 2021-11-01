package com.hss.juc.synLock.enums;

public enum FrequencyEunm {
    t1(1,5),
    t2(2,10),
    t3(3,15);

    private int tid;

    private int num;

    FrequencyEunm(int tid,int num){
        this.tid = tid;
        this.num = num;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static  int getNumByTid(int tid){
        FrequencyEunm[] values = FrequencyEunm.values();
        for(int i = 0; i < values.length; i++){
            FrequencyEunm value = values[i];
            if(value.tid == tid){
                return value.num;
            }
        }
        return 0;
    }

    /*public static void main(String[] args) {
        System.out.println(FrequencyEunm.getNumByTid(1));
        System.out.println(FrequencyEunm.getNumByTid(2));
        System.out.println(FrequencyEunm.getNumByTid(3));
        System.out.println(FrequencyEunm.getNumByTid(4));
    }*/
}
