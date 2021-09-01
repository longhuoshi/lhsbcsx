package net.tcp_ip;

import java.io.*;
import java.net.Socket;

public class UploadPictureClient {
    public static void main(String[] args) throws IOException {

        System.out.println("上传图片客户端开启.....");

        Socket socket = new Socket("192.168.1.122",10004);

        OutputStream out = socket.getOutputStream();

        File file = new File("py.jpg");
        FileInputStream fis = new FileInputStream(file);
        
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1){
            out.write(buf,0,len);
        }

        //告诉服务端写完了
        socket.shutdownOutput();

        //读取服务器端数据
        byte[] bufIn = new byte[1024];
        InputStream is = socket.getInputStream();
        int lenIn = is.read(bufIn);
        String str = new String(bufIn,0,lenIn);
        System.out.println("服务器返回："+str);

        fis.close();
        socket.close();

    }
}
