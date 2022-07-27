package myjava.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YourRegexTest {
    public static void main(String[] args) {
//        test();
//        checkMail();
        catchImagInHtml();
    }

    public static void catchImagInHtml(){//(http|https)
        String html = "<p><img src=\"https://txlcoss.oss-cn-hangzhou.aliyuncs.com/aliyuncs/resource/2022/07/05/20220705150655_535.png\" alt=\"D{T68$Y9(8(N)J3UK~H_)CR.png\"/></p>";
        html += "<p><img src=\"http://txlcoss.oss-cn-hangzhou.aliyuncs.com/aliyuncs/resource/2022/07/04/20220704164904_458.jpg\" alt=\"微信图片_20220704164219.jpg\" width=\"393\" height=\"483\" style=\"width: 393px; height: 483px;\"/></p>";
//        String urlRegex = "(http|https)://[^\":<>]*\\.(jpg|bmp|gif|ico|jpeg|tif|png)";
        String urlRegex = "http[s]{0,1}://[^\":<>]*\\.(jpg|bmp|gif|ico|jpeg|tif|png)";
        Pattern compile = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(html);
        while (matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));

        }


    }

    /**练习：对ip地址进行排序
     * 192.168.1.200   17.10.10.10     3.3.50.3    127.0.0.1
     * */
    public static void test(){
        String temp = "192.168.1.200   17.10.10.10     3.3.50.3    127.0.0.1";
        /**排序出现问题了。是按照字符串字典顺序排的序
         * 问题在哪呢？是因为每一个地址段的位数不一样导致 的。
         * 如果位数都是三位就可以了。 只有补0了。
         * 每一段位数都不同，咋补？
         * 干脆按照最大所需0的个数补齐。每一段都补两个0
         *
         * */

        //补两个0  示例：00192.00168.001.00200   0017.0010.0010.0010     003.003.0050.003    00127.000.000.001
        temp = temp.replaceAll("(\\d+)","00$1");
//        System.out.println(temp);

        //去掉多余的零，保留最后3位 示例：192.168.001.200   017.010.010.010     003.003.050.003    127.000.000.001
        temp = temp.replaceAll("0*(\\d{3})","$1");
//        System.out.println(temp);


        String[] ips = temp.split(" +");
        Arrays.sort(ips);
        for (String ip : ips ){
            System.out.println(ip.replaceAll("0*(\\d+)","$1"));
        }
    }

    /**
     * 效验邮箱地址
     * */
    public static void checkMail(){
        String main = "abc12@sina.com";//.cn
        String regex = "\\w+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,3}){1,3}";

        //通用匹配邮箱正则
//        regex ="\\w+@\\w+(\\.\\w+)+";

        //(\.[a-zA-Z]{2,3}) 这个部分有可能出现 1到3次，所以把它封装成组了(示例 .com.cn)
        boolean b = main.matches(regex);
        System.out.println(main+":"+b);

    }

}
