package com.zx.test;

/**
 * 正则表达式
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUtils {
   public static void main(String[] args) {
      // * 出现0次或多次
      // ? 出现0次或一次
      // + 出现1次到N次
      // {n}出现n次
      // {n,m}出现n到m次
      // \d[0-9]
      // \D[^0-9]
      // .任意字符
      // \w [a-zA-Z_0-9]
      // \W [^\w]
      // \s  空白字符：[ \t\n\x0B\f\r]
      // \S  非空白字符：[^\s]

      // System.out.println("".matches("a*"));

      // "<a href=""></a>"
      String ht = "<a.*href=\".*\">(.+?)</a>";
      String html = "</p><p style=height:14px><a href=\"http://jingjia.baidu.com\">企业推广</a> | <a href=http://top.baidu.com>搜索风云榜</a> | <a href=/home.html>关于百度</a> | <a href=http://ir.baidu.com>About Baidu</a></p><p id=b>&copy;2008 Baidu <a href=http://www.baidu.com/duty>使用百度前必读</a> <a href=http://www.miibeian.gov.cn target=_blank>京ICP证030173号</a> <a href=http://www.hd315.gov.cn/beian/view.asp?bianhao=010202001092500412><img src=http://gimg.baidu.com/img/gs.gif></a></p></center></body></html><!--543ff95f18f36b11-->";
      Pattern pattern = Pattern.compile(ht);
      Matcher input = pattern.matcher(html);
      while (input.find()) {
         // 结果
         String result = input.group();
         // 连接
         String href = "\".*\"";
         String s3 = "href=.*?>";
         Pattern url = Pattern.compile(href);
         System.out.println(result);
         Matcher urls = url.matcher(result);
         while (urls.find()) {
            System.out.println("url:\t" + urls.group());

         }
         String title = ">.*?</a>";
         // 标题
         Pattern ts = Pattern.compile(title);
         Matcher titles = ts.matcher(result);
         while (titles.find()) {
            System.out.println("title:" + titles.group());
         }
      }
      String content = "javakkjjkjavajlkjkjljl12121jljljjavaapkjff";
      String regex = "(^java)+";
      Pattern p = Pattern.compile(regex);
      Matcher matcher = p.matcher(content);
      while (matcher.find()) {
         System.out.println(matcher.group());
      }
   }
}
