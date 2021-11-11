package m_thread.third.jucadvance.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/11/9 14:00
 * @description
 * 23_LockSupport类中的park等待和unpark唤醒
 */
public class LockSupportDemo {
    static Object objectLock = new Object();

    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        //LockSupport
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "   ---come in");
            LockSupport.park();
            LockSupport.park();

            System.out.println(Thread.currentThread().getName() + "   ---被唤醒");

        }, "t1");
        t1.start();

        //第一个通知
        new Thread(()->{
           LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName()+"   ---发出通知");
            //两个park的情问下，要睡眠，等到被 通知 的代码码执行到第二个park，第二个unpark发出知道才有效。
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(t1);
            System.out.println(Thread.currentThread().getName()+"   ---发出通知");
        },"t2").start();
    }


    //1) Condition中的线程等待和唤醒方法要在锁代码块里(lock和unlock之间)
    //2) 一定要先await后signal。
    private static void syncAwaitSignal() {
        new Thread(()->{
            //暂时一下，让唤醒线程先启动。会出现 无法唤醒的错误 。
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"   ---come in");
                condition.await();
                System.out.println(Thread.currentThread().getName()+"   ---被唤醒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"   ---发出通知");

            }finally {
                lock.unlock();
            }
        },"t2").start();
    }


    //wait和notify必须 在synchronized同步代码块里面，且要成对出现 ,否则报IllegalMonitorStateException。顺序要求是先wait后notify。
    private static void syncWaitNotify() {

        new Thread(()->{
            synchronized(objectLock){
                System.out.println(Thread.currentThread().getName()+"   ---come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"   ---被唤醒");
            }
        },"t1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (objectLock){
                objectLock.notify();
                System.out.println(Thread.currentThread().getName()+"   ---发出通知");

            }
        },"t2").start();
    }
}
