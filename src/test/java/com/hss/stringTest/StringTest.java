package com.hss.stringTest;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 测试类
 */
public class StringTest {

    public static void main(String[] args) {

        //demo1
        String templateInfo1 = "demo1====================>k1:%s;k2:%s";
        System.out.println(String.format(templateInfo1,"v1","v2"));

        //demo2
        String templateInfo2 = "demo2====================>k1:{0};k2:{1}";
        System.out.println(MessageFormat.format(templateInfo2,"v1","v2"));

        //demo3
        String templateInfo3 = "demo3====================>k1:{0};k2:{1}";
        String[] arr = {"v1","v2"};
        System.out.println(fillStringByArgs(templateInfo3,arr));
    }

    /**
     * 填充字符串位符
     * @param str
     * @param arr
     * @return
     */
    private static String fillStringByArgs(String str,String[] arr){
        Matcher m = Pattern.compile("\\{(\\d)\\}").matcher(str);
        while(m.find()){
            str=str.replace(m.group(),arr[Integer.parseInt(m.group(1))]);
        }
        return str;
    }
}
