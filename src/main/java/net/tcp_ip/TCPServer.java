package net.tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 授受客户端的数据
 * */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动...");

        //创建socket服务器端服务,并设置ip和port
        ServerSocket ss = new ServerSocket(10003);
        //获取请求过来 的客户端的socket
        Socket s = ss.accept();
        String clientIP = s.getInetAddress().getHostAddress();
        System.out.println(clientIP+".....connected!");
        //从客户端的socket里获取数据
        InputStream is = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = is.read(buf);
        String str = new String(buf,0,len);
        System.out.println(str);


        //关闭服务
        s.close();
        ss.close();



    }
}
