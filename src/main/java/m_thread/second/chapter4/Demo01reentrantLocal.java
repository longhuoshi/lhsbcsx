package m_thread.second.chapter4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/9/14 11:52
 * @description
 */
public class Demo01reentrantLocal {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Demo01reentrantLocalThread(lock);
        Thread t2 = new Demo01reentrantLocalThread(lock);
        Thread t3 = new Demo01reentrantLocalThread(lock);
        t1.start();
        t2.start();
        t3.start();

    }
}

class Demo01reentrantLocalThread extends Thread{
    private Lock lock;

    public Demo01reentrantLocalThread(Lock lock) {
        this.lock = lock;
    }

    public void run(){
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+","+(i+1));
        }
        lock.unlock();
    }

}