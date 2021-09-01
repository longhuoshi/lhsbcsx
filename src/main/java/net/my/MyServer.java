package net.my;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        /**
         * 创建一个服务器为了获取浏览器发送过来的数据。
         * */
        ServerSocket ss = new ServerSocket(8090);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostName();
        System.out.println(ip+"......connected");

        //接收浏览器数据
        InputStream is = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = is.read(buf);

        System.out.println(new String(buf,0,len));

        //给浏览器一个回馈
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        pw.println("HTTP/1.1 200 OK");
        pw.println("Content-Type: text/html;charset=utf-8");
        pw.println();//空行
        pw.println("<font color='red' size='7'>欢迎光临，你访问的是自定义的服务器！</font>");//应答体


        s.close();
        ss.close();




    }

}

//www.fadmin.com......connected

//        GET / HTTP/1.1
//        Accept: text/html, application/xhtml+xml, image/jxr, */*
/*
Accept-Language: zh-CN
User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
Accept-Encoding: gzip, deflate
Host: 127.0.0.1:8090
Connection: Keep-Alive
空行
请求body...
*/
