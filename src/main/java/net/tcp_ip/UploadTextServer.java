package net.tcp_ip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UploadTextServer {
    public static void main(String[] args) throws IOException {
        /**
         * 上传文本的服务端。接受文本数据，并存储到文件中，服务端接收完毕后，回馈“上传成功”字样 。
         * */
        System.out.println("上传文件服务器启动....");
        //1、服务端对象
        ServerSocket ss = new ServerSocket(10003);
        //获取客户端socket
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostName();
        System.out.println(ip+".....connected!");

        BufferedReader buffIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        //把客户端数据写入文件
        FileWriter fileW = new FileWriter(System.currentTimeMillis()+"admin.txt");
//        BufferedWriter buffw = new BufferedWriter(fileW);
        PrintWriter pw = new PrintWriter(fileW,true);
        String line = null;
        while ((line = buffIn.readLine())!=null){
//            if ("over".equals(line)){
//                break;
//            }

//            buffw.write(line);
//            buffw.flush();

            pw.println(line);
        }

        //返回成功
//        BufferedWriter buffOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
//        buffOut.write("上传成功");
//        buffOut.flush();
        PrintWriter pwOut = new PrintWriter(s.getOutputStream(),true);
        pwOut.println("上传成功");


        //关闭流
//        buffw.close();
        pw.close();
        s.close();
        ss.close();


    }
}
