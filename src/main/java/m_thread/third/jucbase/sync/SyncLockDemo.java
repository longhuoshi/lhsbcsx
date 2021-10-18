package m_thread.third.jucbase.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/10/18 15:15
 * @description
 *
 *21-JUC高并发编程-多线程锁-可重入锁（2）
 * 又叫递归锁。
 */
public class SyncLockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            try{
                //上锁
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" 外层");

                try{
                    //上锁
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+" 内层");
                }finally {
                    //解锁
                    lock.unlock();//如果这里没有释放锁，下面的t2线程就没法执行。
                }
            }finally {
                //解锁
                lock.unlock();
            }
        },"t1").start();

        //创建新线程t2
        new Thread(()->{
            lock.lock();
            System.out.println("aaaa");
            lock.unlock();
        },"t2").start();

    }
}
