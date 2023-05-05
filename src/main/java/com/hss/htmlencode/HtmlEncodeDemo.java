package com.hss.htmlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 * java html片段操作
 * </p>
 *
 * @author Hss
 * @date 2023-05-05
 */
public class HtmlEncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //转码
        String html = "<p class=\"ql-align-left\">123</p>";
        String htmlEncode = URLEncoder.encode(html,"UTF-8");
        String res = htmlEncode.replaceAll("\\+","%20");
        System.out.println(res);

        //解码
        String content = "%3Cp%20class%3D%22ql-align-left%22%3E8468%3C%2Fp%3E";
        System.out.println(URLDecoder.decode(content,"UTF-8"));
    }
}
