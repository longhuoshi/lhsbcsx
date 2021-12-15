package m_thread.third.jucadvance.objecthead;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author l
 * @date 2021/12/15 10:13
 * @description
 *
 *
查看java虚拟机启动时的默认参数
java -XX:+PrintCommandLineFlags -version

 * -XX:+UseCompressedClassPointers  开户压缩 (类型指针占4bit)
 * -XX:-UseCompressedClassPointers  关闭压缩 (类型指针占8bit)
 */
public class ObjectHeadDemo {
    public static void main(String[] args) {
        //Jvm的细节
//        System.out.println(VM.current().details());
        //所有的对象分配的字节都是8的整数倍。
//        System.out.println(VM.current().objectAlignment());

        Object object = new Object();
        MyObject myObject = new MyObject();

        System.out.println(ClassLayout.parseInstance(object).toPrintable());

    }
}

class MyObject{
    int age = 25;
    boolean flag = false;

//    long a = 43;
}
