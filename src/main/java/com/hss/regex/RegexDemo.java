package com.hss.regex;

import java.util.regex.Pattern;

/**
 * <p>
 * java 正则表达
 * </p>
 *
 * @author Hss
 * @date 2023-04-13
 */
public class RegexDemo {

    /**
     * 密码格式验证
     * 1、需要有大小写字母
     * 2、需要特殊字符
     * 3、需要数字
     * 4、长度大于12位
     */
    public static final String PW_PATTERN = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{12,}$";

    public static void main(String[] args) {

        //正常密码
        String pw1 = "Aa@100000000";
        //长度不足
        String pw2 = "Aa@10000000";
        //没有大写
        String pw3 = "aa@100000000";
        //没有小写
        String pw4 = "AA@100000000";
        //没有特殊符号
        String pw5 = "Aa1100000000";
        //没有数字
        String pw6 = "Aa@ooooooooo";
        //没有特殊符号，用中文来顶特殊符号位置
        String pw7 = "Aa冲100000000";

        //表达式
        /*System.out.println(pw1.matches(PW_PATTERN));
        System.out.println(pw2.matches(PW_PATTERN));
        System.out.println(pw3.matches(PW_PATTERN));
        System.out.println(pw4.matches(PW_PATTERN));
        System.out.println(pw5.matches(PW_PATTERN));
        System.out.println(pw6.matches(PW_PATTERN));
        //中文被当作了特殊字符，算个小瑕疵
        System.out.println(pw7.matches(PW_PATTERN));*/

        //工具类
        /*System.out.println(RegexUtil.pwdFormat(pw1));
        System.out.println(RegexUtil.pwdFormat(pw2));
        System.out.println(RegexUtil.pwdFormat(pw3));
        System.out.println(RegexUtil.pwdFormat(pw4));
        System.out.println(RegexUtil.pwdFormat(pw5));
        System.out.println(RegexUtil.pwdFormat(pw6));
        System.out.println(RegexUtil.pwdFormat(pw7));*/

        //matches
        System.out.println("---------正则和字符双向完全匹配---------");
        System.out.println(Pattern.matches("^H0", "H0"));
        System.out.println(Pattern.matches("^H0", "H01"));
        System.out.println(Pattern.matches("^H0", "1H0"));
        System.out.println(Pattern.matches("^H0", "1H01"));
        //matcher
        System.out.println("---------字符包含正则即可---------");
        System.out.println(Pattern.compile("^H0").matcher("H0").find());
        System.out.println(Pattern.compile("^H0").matcher("H01").find());
        System.out.println(Pattern.compile("^H0").matcher("1H0").find());
        System.out.println(Pattern.compile("^H0").matcher("1H01").find());

    }
}
