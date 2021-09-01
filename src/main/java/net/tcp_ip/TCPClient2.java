package net.tcp_ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 给服务端发送数据，并授受服务器端发送过来的数据
 * */

public class TCPClient2 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端2启动了...");
        //创建socket,连接服务器端
        Socket s = new Socket("192.168.1.122",10003);
        //获取输出流
        OutputStream os = s.getOutputStream();
        //把数据写入输出流，发送到服务器端
        os.write("注意TCP来啦...".getBytes());

        //授受服务器端发送过来的数据
        InputStream input = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = input.read(buf);
        String serverInformation = new String(buf,0,len);
        System.out.println("服务返回："+serverInformation);

        s.close();


    }
}
