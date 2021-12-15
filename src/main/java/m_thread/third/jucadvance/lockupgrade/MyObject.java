package m_thread.third.jucadvance.lockupgrade;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author l
 * @date 2021/12/15 11:40
 * @description
 *
 *
关闭延时(演示偏向锁时要开启)。
-XX:BiasedLockingStartupDelay=0

 */
public class MyObject {
    public static void main(String[] args) {

        //60_偏向锁演示.mp4
        Object o = new Object();
        new Thread(()->{
            synchronized(o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        },"t1").start();

    }

    private static void nolock() {
        Object o = new Object();
        System.out.println("10进制hash码："+o.hashCode());
//        System.out.println("16进制hash码："+Integer.toHexString(o.hashCode()));
//        System.out.println("2进制hash码："+Integer.toBinaryString(o.hashCode()));

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        //没有调用hashCode： 01 00 00 00 (00000001 00000000 00000000 00000000) (1)
        //  调用了hashCode：01 58 e8 0b (00000001 01011000 11101000 00001011) (199776257)
    }
}
