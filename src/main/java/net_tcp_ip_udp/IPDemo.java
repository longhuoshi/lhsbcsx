package main.java.net_tcp_ip_udp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机主机信息
        InetAddress ip  = InetAddress.getLocalHost();
        //获取远程主机信息
        ip = InetAddress.getByName("www.sina.com.cn");

        System.out.println(ip); //DESKTOP-CH7BT82/192.168.1.122

        String str_ip = ip.getHostAddress();
        String name = ip.getHostName();

        System.out.println(str_ip+":"+name);
    }
}
