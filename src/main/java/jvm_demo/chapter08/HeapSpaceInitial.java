package jvm_demo.chapter08;

/**
 * 1、设置 堆空间大小的参数
 *"-Xms" 指定堆区的起始内存，等价于-XX:InitialHeapSize
 * "-X" 是jvm的运行参数
 * "ms" 是memory start
 *  "-Xmx" 指定堆区的最大内存，等价于-XX:MaxHeapSize
 *
 *  2、默认情况下，初始内存大小：物理电脑内存大小 / 64
 *              最大内存大小：物理电脑内存大小 / 4
 * */
public class HeapSpaceInitial {
    public static void main(String[] args) {
        //返回java虚拟机中的堆内存总量。
        long initialMemory = Runtime.getRuntime().totalMemory() /1024/1024;
        //返回Java虚拟机试图使用的最大堆内存量。
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("-Xms : "+initialMemory + "M");
        System.out.println("-Xmx : "+maxMemory + "M");

        System.out.println("系统内存大小为 : "+ initialMemory*64.0 /1024 + "G");
        System.out.println("系统内存大小为 : "+ maxMemory*4.0 /1024 + "G");

    }
}
