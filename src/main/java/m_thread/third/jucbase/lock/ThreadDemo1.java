package m_thread.third.jucbase.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/10/15 11:28
 * @description
 * 11-JUC高并发编程-线程间通信-Lock实现案例
 */

//1、创建资源类，在资源类创建属性和方法。
class Share{
    //初始值
    private int number = 0;

    //创建锁
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //+1的方法
    public void increase() throws InterruptedException {

        //加锁
        lock.lock();
        try {

            //2、在资源类操作方法
            //    判断->干活->通知 。
            while (number != 0 ){ // if判断会引起虚假唤醒的问题
                condition.await(); //在哪里睡，就在哪里醒。
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            //通知其它线程
            condition.signalAll();
        }finally {
            //解锁
            lock.unlock();
        }

    }
    //-1的方法
    public synchronized void decrease() throws InterruptedException {

        //加锁
        lock.lock();
        try {
            //2、在资源类操作方法
            //    判断
            while (number != 1  ){
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            //通知
            condition.signalAll();
        }finally {
            //解锁
            lock.unlock();
        }


    }

}

public class ThreadDemo1 {
    public static void main(String[] args) {
        //3、创建多个线程，调用 资源类中的操作方法。
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

    }
}
