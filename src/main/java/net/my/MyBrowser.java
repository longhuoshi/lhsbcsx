package net.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MyBrowser {
    public static void main(String[] args) throws IOException {
        /**
         * 模拟浏览器。发送一些http的消息 给Tomcat消息 。
         * */
        Socket s = new Socket("www.baidu.com",80);
//        Socket s = new Socket("127.0.0.1",8090);

        //获取输出流，给服务器发送数据
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        out.println("GET / HTTP/1.1");
        out.println("Accept: text/html, application/xhtml+xml, image/jxr, *//*");
        out.println("Accept-Language: zh-CN");
        out.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko");
        out.println("Connection: close");
        out.println();

        //接受 服务器数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String str = new String(buf,0,len);
        System.out.println(str);

        s.close();


    }
}
