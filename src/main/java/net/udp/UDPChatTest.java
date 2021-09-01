package net.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPChatTest {

    public static void main(String[] args) throws SocketException {
        /**
         * 通过UDP协议。
         * 完成一个聊天程序。
         * 一个负责发送数据的任务。一个负责接收数据的任务。
         * 两个任务 需要同时执行。
         * 可以使用多线程 技术 。
         * */

        //创建socket服务
        DatagramSocket send = new DatagramSocket();
        DatagramSocket receive = new DatagramSocket(10001);
        new Thread(new Send(send)).start();
        new Thread(new Receive(receive)).start();

    }
}

//发送任务
class Send implements Runnable{
    public static String END_SIGN = "over";

    private DatagramSocket datagramSocket;
    public Send(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        //1、发送数据来自哪？ 键盘录入
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        //读取数据
        String line = null;
        try {
            while ((line = buffer.readLine()) != null){

                //2、将数据封装到数据包中。
                byte[] buf = line.getBytes();
                DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.1.255"),10001);
                //192.168.1.255 这个地址为广播

                //3、将数据包发送出去。
                datagramSocket.send(dp);
                if (END_SIGN.equals(line)){
                    break;
                }
            }
            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//接受任务
class Receive implements Runnable{
    public static String END_SIGN = "over";
    private DatagramSocket datagramSocket;
    public Receive(DatagramSocket datagramSocket){
        this.datagramSocket = datagramSocket;
    }
    @Override
    public void run() {
        while (true){
            //1、因为接受的数据最终都会存储到数据包中。而数据包中必须有字节数组。
            byte[] buf = new byte[1024];
            //2、创建数据包对象
            DatagramPacket dp = new DatagramPacket(buf,buf.length);
            //3、将接受到的数据存储到数据包中。
            try {
                datagramSocket.receive(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //4、获取数据。
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(),0,dp.getLength());
            if (END_SIGN.equals(data)){
                System.out.println(ip+"....离开聊天室");
            }
            System.out.println(ip+":"+data);
        }
    }
}