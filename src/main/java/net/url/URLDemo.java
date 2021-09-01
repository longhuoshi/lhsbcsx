package net.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 23-网络编程-URL对象
 * 24-网络编程-URLConnection对象
 *http 1.0 建一次连接 ，只请求一个资源(一次请求和应答。)
 *http 1.1 建一次连接 ，只请求多个资源(多次请求和应答。)  效率更高。
 * */


public class URLDemo {
    public static void main(String[] args) throws IOException {
        //解析url中的数据。使用URL对象。
//        String str_url = "http://127.0.0.1:8090/myweb/2.html?name=lisa";
        String str_url = "https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9427182743460608474%22%7D&n_type=0&p_from=1";
        URL url = new URL(str_url);
        System.out.println("getProtocol:"+url.getProtocol());
        System.out.println("getHost:"+url.getHost());
        System.out.println("getPort:"+url.getPort());
        System.out.println("getPath:"+url.getPath());
        System.out.println("getFile:"+url.getFile());
        System.out.println("getQuery:"+url.getQuery());

        //通过openConnection();获取到该远程资源的连接对象
        URLConnection conn = url.openConnection();
        //调用 连接对象的读取方法。准备读取资源。
        InputStream in = conn.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String  str = new String(buf,0,len);
        System.out.println(str);



    }
}
