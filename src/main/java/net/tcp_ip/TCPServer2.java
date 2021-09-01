package net.tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 授受客户端的数据，并给客户发送反馈数据。
 * */


public class TCPServer2 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端2启动...");

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
        System.out.println("客户端说："+str);

        //给客户发送反馈数据。
        OutputStream output = s.getOutputStream();
        output.write("感谢光临，我收到你的数据啦！".getBytes());


        //关闭服务
        s.close();
        ss.close();



    }
}
