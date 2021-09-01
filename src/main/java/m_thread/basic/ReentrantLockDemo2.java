package main.java.m_thread.basic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/4/27 11:44
 * @description
 * 3.5、显示锁Lock和ReentrantLock
 * 二、两个方法之间使用相同的锁。
 */
public class ReentrantLockDemo2 {
    public static void main(String[] args) {
        final CountReentrant2 ct = new CountReentrant2();

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


class CountReentrant2{
    final ReentrantLock lock = new ReentrantLock();
    public void get(){
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