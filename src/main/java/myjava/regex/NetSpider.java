package myjava.regex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 正则表达式-网络爬虫(爬邮箱)。
 * */
public class NetSpider {
    public static void main(String[] args) throws IOException {
        //将文件封装成File对象
        File file = new File("mail_government.mhtml");//下载了一个有邮箱的网页文件
        String regex ="\\w+@\\w+(\\.\\w+)+";
        List<String> mailList = getMails(file,regex);
        for (String mail : mailList){
            System.out.println(mail);
        }
    }

    private static List<String> getMails(File file,String regex) throws IOException {
        //1、读取数据
        BufferedReader buffer  = new BufferedReader(new FileReader(file));
        //2、将正则封装成对象
        Pattern  p = Pattern.compile(regex);
        //3、存放邮箱list
        List<String> list = new ArrayList<>();

        String line = null;
        while ((line = buffer.readLine()) !=null){
             //获取匹配器
            Matcher m = p.matcher(line);
            while (m.find()){
                list.add(m.group());
            }
        }

        return list;
    }
}
