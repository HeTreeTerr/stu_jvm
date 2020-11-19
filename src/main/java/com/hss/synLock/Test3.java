package com.hss.synLock;

public class Test3 {

    private static int i = 0;

    public void method(){
        synchronized (Test3.class){
            i++;
        }
    }

    public static void main(String[] args) {

    }
}
