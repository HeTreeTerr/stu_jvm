package com.hss.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达工具
 */
public class RegexUtil {

    /**
     * 1、需要有大小写字母
     * 2、需要特殊字符
     * 3、需要数字
     * 4、长度大于12位
     * @param pwd
     * @return
     */
	public static boolean pwdFormat(String pwd) {
		if (pwd == null) {
        	return false;
        }
        //长度
		if (pwd.length() < 12) {
        	return false;
        }
        //小写字母
        Pattern p1= Pattern.compile("[a-z]+");
		//大写字母
        Pattern p2= Pattern.compile("[A-Z]+");
        //数字
        Pattern p3= Pattern.compile("[0-9]+");
        //特殊字符
        Pattern p4 = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");
        Matcher m=p1.matcher(pwd);
        if(!m.find())
            return false;
        else{
            m.reset().usePattern(p2);
            if(!m.find())
                return false;
            else{
                m.reset().usePattern(p3);
                if(!m.find())
                    return false;
                else{
                    m.reset().usePattern(p4);
                    if(!m.find())
                        return false;
                    else{
                        return true;
                    }
                }
            }
        }
	}
}
