package jvm_demo.chapter08;
/**
 * 堆大小设置
 * Xmx指定应用程序可用的最大堆大小
 * Xms指定应用程序可用的最小堆大小
 * -Xms10m -Xmx10m
 *
 * */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start...");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end...");
    }
}
