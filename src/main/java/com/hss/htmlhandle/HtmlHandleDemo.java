package com.hss.htmlhandle;

import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * <p>
 * java 操作处理 html片段
 * </p>
 *
 * @author Hss
 * @date 2023-05-05
 */
public class HtmlHandleDemo {

    private final static String IMG_TAG = "img";

    private final static String A_TAG = "a";

    private final static String SRC_ATTR = "src";

    private final static String HREF_ATTR = "href";

    private final static String VERSION_ATTR = "version";

    public static void main(String[] args) throws UnsupportedEncodingException {
        //转码
        /*String html = "<p class=\"ql-align-left\">123</p>";
        String htmlEncode = URLEncoder.encode(html,"UTF-8");
        String res = htmlEncode.replaceAll("\\+","%20");
        System.out.println(res);*/

        //解码
        /*String content = "%3Cp%3E%E6%A0%87%E9%A2%98%E5%85%9A1%3C/p%3E%3Cp%3E%3Ca%20href=%22asdffasdf%22%20target=%22_blank%22%3E%3Cstrong%3E%3Cs%3Easdffasdf%3C/s%3E%3C/strong%3E%3C/a%3E%3C/p%3E%3Cp%3E%3Cimg%20class=%22ql-img%22%20src=%22/tzt-managesystem/qdymanage/202305/1683184086705_63458.png%22%20filename=%22c7ca81826ff5807265ecf44ad1416df.png%22%3E%3C/p%3E%3Cp%3E%E6%A0%87%E9%A2%98%E5%85%9A2%3C/p%3E%3Cp%3E%3Ca%20href=%221234567%22%20target=%22_blank%22%3E1234567%3C/a%3E%3C/p%3E%3Cp%3E%3Cimg%20class=%22ql-img%22%20src=%22/tzt-managesystem/qdymanage/202305/1683266525461_45073.PNG%22%20filename=%2241e5b479b1b1e61020b851a6aa2b786.PNG%22%3E%3C/p%3E";
        System.out.println("\n" + URLDecoder.decode(content,"UTF-8"));
        String html = URLDecoder.decode(content,"UTF-8");
        //System.out.println(html);

        //html片段解析和操作
        Document document = Jsoup.parse(html);
        //图片
        Elements imgTags = document.getElementsByTag(IMG_TAG);
        for (Element imgTag : imgTags){
            String oldSrc = imgTag.attr(SRC_ATTR);
            imgTag.attr(SRC_ATTR,oldSrc + ".d");
            imgTag.attr(VERSION_ATTR,"10");
        }
        //链接
        Elements aTags = document.getElementsByTag(A_TAG);
        for (Element aTag : aTags){
            String aHref = aTag.attr(HREF_ATTR);
            aTag.attr(HREF_ATTR,aHref + ".d");
            aTag.attr(VERSION_ATTR,"10");
        }
        System.out.println("\n" + document.body().html());*/

        String url1 = "https://digittest.95358.com/api/v1/tzt-h5/fund-ia/index.html#/see/info?combineCode=A8182&isConfiig=true&isZyPage=1";
        String url2 = "https://digittest.95358.com/api/v1/tzt-h5/fund-ia/index.html#/see/info?combineCode=A8182&amp%3BisConfiig=true&amp%3BisZyPage=1";

        System.out.println(StringEscapeUtils.unescapeHtml(URLDecoder.decode(url1,"utf-8")));
        System.out.println(StringEscapeUtils.unescapeHtml(URLDecoder.decode(url2,"utf-8")));
    }
}
