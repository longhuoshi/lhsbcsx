package m_thread.third.jucadvance.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author l
 * @date 2021/11/24 15:13
 * @description
 * ABA问题和解决
 *
 */
public class ABADemo {
    static AtomicInteger atomicInteger = new AtomicInteger(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"---默认版本号："+stamp);
            //暂停毫秒，让t4和t3获得一样的版本号。
            try { TimeUnit.MILLISECONDS.sleep(200);} catch (InterruptedException e) { e.printStackTrace(); }

            atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"---1次版本号："+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"---2次版本号："+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            //等待t3线程发生ABA
            try { TimeUnit.MILLISECONDS.sleep(800);} catch (InterruptedException e) { e.printStackTrace(); }

            boolean b = atomicStampedReference.compareAndSet(100, 20211124,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"----修改成功否："+b+"----版本号："+atomicStampedReference.getStamp()+"----值："+atomicStampedReference.getReference());
        },"t4").start();

    }

    private static void abaProblem() {
        new Thread(()->{
            atomicInteger.compareAndSet(100,101);
            atomicInteger.compareAndSet(101,100);
        },"t1").start();
        //暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(20);} catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(()->{
            boolean b = atomicInteger.compareAndSet(100, 20211124);
            System.out.println(Thread.currentThread().getName()+"----修改成功否："+b+"----"+atomicInteger.get());
        },"t2").start();
    }
}
