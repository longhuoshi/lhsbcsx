package net.tcp_ip;

import java.io.*;
import java.net.Socket;

public class UploadPictureServerTask implements Runnable {
    private Socket s;
    public UploadPictureServerTask(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            String ip = s.getInetAddress().getHostName();
            System.out.println(ip+"..........connected!");
            
            File file = getFile("E:\\picture\\upload_img_test");
            //FileOutputStream如果要用BufferedWriter必须要用OutputStreamWriter包装起来。
            FileOutputStream fos = new FileOutputStream(file);

            //读取客户端传输的输入流，并写到服务磁盘。
            InputStream is = s.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = is.read(buf)) != -1){
                fos.write(buf,0,len);
            }

            //回复客户端数据
            OutputStream os  = s.getOutputStream();
            os.write("上传图片成功".getBytes());

            //关流
            fos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static File getFile(String dir) {
        //目录创建
        File pic_dir = new File(dir);
        if (!pic_dir.exists()){
            pic_dir.mkdir();
        }


        //确定文件存放位置
        int count =1 ;
        File file =  new File(pic_dir,"pucture.jpg");
        while (file.exists()){
            file =  new File(pic_dir,"pucture("+count+").jpg");
            count++;
        }

        return file;
    }
}
