package net.tcp_ip;

import java.io.*;
import java.net.Socket;

public class UploadTextClient {
    public static void main(String[] args) throws IOException {
        /**
         * 上传文本的客户端。读取本地文本数据，发送给服务端，服务端接收完毕后，回馈“上传成功”字样
         * */
        System.out.println("上传文件客户端启动....");
        //客户端socket
        Socket s = new Socket("192.168.1.122",10003);

        //读取本地文件
        BufferedReader bffr = new BufferedReader(new FileReader("admin01.txt"));
        //写入对象根输出管道流关联，发送数据流到服务器
//        BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        String line=null;
        while ((line=bffr.readLine())!= null){
            pw.println(line);
        }
        //发送结束标致
//        pw.println("over");容易重复
        //使用socket的禁用输出流方法
        s.shutdownOutput();

        //接受服务器返回 消息
        BufferedReader bffIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String lineIn = bffIn.readLine();
        System.out.println(lineIn);

        //关闭流
        bffr.close();
        s.close();


    }


}
