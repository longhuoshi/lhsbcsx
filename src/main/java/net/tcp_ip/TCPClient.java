package net.tcp_ip;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 给服务端发送数据
 * */


public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动了...");
        //创建socket,连接服务器端
        Socket s = new Socket("192.168.1.122",10003);
        //获取输出流
        OutputStream os = s.getOutputStream();
        //把数据写入输出流，发送到服务器端
        os.write("注意TCP来啦...".getBytes());
        s.close();


    }
}
