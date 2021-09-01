package net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendDemo {
    public static void main(String[] args) throws IOException {
        /**
         * 需求：建立udp的发送端。
         * 思路：
         * 1、建立可以实现udp传输的socket服务。
         * 2、明确具体发送数据
         * 3、通过socket服务将具体的数据发送出去
         * 4、关闭服务
         *
         * */

        System.out.println("UDP发送端启动....");
        DatagramSocket ds = new DatagramSocket();
        String str = "注意，UDP来了！！";
        byte[] buf = str.getBytes();
        //将数据封装到数据包对象中，数据包明确目的地址和端口
        DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("127.0.0.1"),10000);
        ds.send(dp);
        ds.close();


    }
}
