package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 创建udp的接收端。
         * 思路：
         * 1、创建socket服务。明确一个端口
         * 2、收数据
         * 3、将其中所需要的数据取出来 ip,data,端口
         * 4、关闭资源。
         * */

        System.out.println("UDP接受端启动了.....");
        //1、创建socket服务。并指定监听端口。
        DatagramSocket ds = new DatagramSocket(10000);

        // 2、使用socket的接收方法。接收数据。需要将收到的数据存储到数据包中。
        //可以通过数据包对象的方法对收到的数据进行解析。
        //2.1、创建一个数据包。
        byte[] buffer = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buffer,buffer.length);
        ds.receive(dp);
//        3、通过数据包对象解析收到的数据，使用数据包的方法 。
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String text = new String(dp.getData(),0,dp.getLength());
        System.out.println(ip+":"+port+"----"+text);
        ds.close();

        
    }
}
