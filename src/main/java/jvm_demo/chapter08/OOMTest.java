package jvm_demo.chapter08;


import java.util.ArrayList;
import java.util.Random;

/**
 * 70-OOM的说明与举例.avi
 * -Xms600m -Xmx600m
 * */
public class OOMTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList<>();
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int length = new Random().nextInt(1024*1024);
            list.add(new Picture(length));
            System.out.println(length);
        }
    }
}

class Picture{
    private byte[] pixels;
    public Picture(int length){
        this.pixels = new byte[length];
    }
}
