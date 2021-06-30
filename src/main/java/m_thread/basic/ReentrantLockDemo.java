package m_thread.basic;

import bcsx.net.mindview.util.Pair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/4/27 11:44
 * @description
 * 3.5、显示锁Lock和ReentrantLock
 * 一、两个方法之间的锁是独立的。
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final CountReentrant ct = new CountReentrant();

        for (int i = 0; i < 2; i++) {
            new Thread(){
                public void run(){
                    ct.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(){
                public void run(){
                    ct.put();
                }
            }.start();
        }

    }

}


class CountReentrant{
    public void get(){
        //每次执行都会new新锁
        final ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();//加锁
            System.out.println(Thread.currentThread().getName() + "get begin");
            Thread.sleep(900L);//模仿干活
            System.out.println(Thread.currentThread().getName() + "get end");
            lock.unlock();  //解锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void put(){
        final ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();//加锁
            System.out.println(Thread.currentThread().getName() + "put begin");
            Thread.sleep(900L);//模仿干活
            System.out.println(Thread.currentThread().getName() + "put end");
            lock.unlock();  //解锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}