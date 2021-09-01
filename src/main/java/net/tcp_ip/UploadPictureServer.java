package net.tcp_ip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * //        BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter( new FileOutputStream("d:\\text.txt"),"UTF-8"));
 *
 *
 * */
public class UploadPictureServer {


    public static void main(String[] args) throws IOException {
        System.out.println("上传图片服务端开启.....");
        //服务对象
        ServerSocket ss = new ServerSocket(10004);
        while (true){
            //获取客户端的socket
            Socket s = ss.accept();
            new Thread(new UploadPictureServerTask(s)).start();

        }

//        ss.close();

    }

}
