package jvm_demo.chapter08;

import jdk.nashorn.internal.ir.WhileNode;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 74-代码举例与JVisualVM演示对象的分配过程
 * -Xms600m -Xmx600m
 *
 * */
public class HeapInstanceTest {
    byte[] buffer = new byte[new Random().nextInt(1024*200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list = new ArrayList<>();
        while (true){
            list.add(new HeapInstanceTest());
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
