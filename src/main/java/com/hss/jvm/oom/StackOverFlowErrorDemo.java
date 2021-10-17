package com.hss.jvm.oom;

/**
 * java.lang.stackOverFlowError
 * 栈空间溢出错误
 * -Xss512k
 */
public class StackOverFlowErrorDemo {

    public static void main(String[] args) {
        stackOverFlowError();
    }

    private static void stackOverFlowError() {
//        Exception in thread "main" java.lang.StackOverflowError
        stackOverFlowError();
    }
}
