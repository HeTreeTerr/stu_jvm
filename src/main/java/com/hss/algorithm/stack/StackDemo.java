package com.hss.algorithm.stack;

import java.util.Stack;

/**
 * <p>
 * 栈结构，基本使用
 * </p>
 *
 * @author Hss
 * @date 2022-07-14
 */
public class StackDemo {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        //入栈
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        //出栈
        while (!stack.empty()){
            //查看
            System.out.println(stack.peek());
            //出栈
            stack.pop();
        }
    }
}
