package m_thread.third.jucadvance.interrupt;

import bcsx.typeinfo.interfacea.A;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author l
 * @date 2021/11/8 16:42
 * @description
 * 20_中断标志面试题.mp4
 * 如何优雅的中断一个线程
 */
public class InterruptDemo {
    static volatile boolean isStop = false;
    static AtomicBoolean  atomicBoolean = new AtomicBoolean(false);
    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("----isInterrupted() = true,程序结束 ");
                    break;
                }
                try {
                    // wait()，join() ,sleep()  methods of this class, then its interrupt status will be cleared and it
                    //            * will receive an {@link InterruptedException}
                    TimeUnit.MILLISECONDS.sleep(500);//注意正在睡眠的Thread不能调用 interrupt()中断它，
                    // 否则会报InterruptedException: sleep interrupted
                } catch (InterruptedException e) {
                    //要再调用一次interrupt()方法来停
                    Thread.currentThread().interrupt();
                    //aqs（AbstractQueuedSynchronizer）里有这个应用


                    e.printStackTrace();
                }
                System.out.println("----hello interrupt");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"----t1.interrupt()");
            t1.interrupt();
        },"t2").start();


    }
    //通过 interrupt
    private static void m3() {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("----isInterrupted() = true,程序结束 ");
                    break;
                }
                System.out.println("----hello interrupt");
            }
        }, "t1");
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"----t1.interrupt()");
            t1.interrupt();
        },"t2").start();
    }

    /**通过AtomicBoolean*/
    private static void m2() {
        new Thread(()->{
            while (true){
                if (atomicBoolean.get()){
                    System.out.println("----atomicBoolean.get() = true,程序结束 ");
                    break;
                }
                System.out.println("----hello atomicBoolean");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"----atomicBoolean.set(true)");
            atomicBoolean.set(true);
        },"t2").start();
    }

    //通过一个volatile变量实现。
    private static void m1() {
        new Thread(()->{
            while (true){
                if (isStop){
                    System.out.println("----isStop = true,程序结束 ");
                    break;
                }
                System.out.println("----hello isStop");
            }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"----set isStop = true");
           isStop = true;
        },"t2").start();
    }
}
