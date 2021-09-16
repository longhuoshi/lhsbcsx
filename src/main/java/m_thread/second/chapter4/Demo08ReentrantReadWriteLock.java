package m_thread.second.chapter4;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 * @date 2021/9/16 10:57
 * @description
 *
 * 60.Lock-ReentranLock-ReentrantReadWriteLock
 *
 */
public class Demo08ReentrantReadWriteLock {
    public static void main(String[] args) {
        Demo08Service service = new Demo08Service();
//        Thread t1 = new Demo08ReadThread(service);
//        t1.setName("读read线程A");
//        t1.start();
//        Thread t2 = new Demo08ReadThread(service);
//        t2.setName("读read线程B");
//        t2.start();
        // 写线程
        Thread t3 = new Demo08WriteThread(service);
        t3.setName("写write线程A");
        t3.start();
        Thread t4 = new Demo08WriteThread(service);
        t4.setName("写write线程B");
        t4.start();

    }
}

class Demo08Service{
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read(){
        try {

            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"获取读read锁于"+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"解除读read锁于"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        try {

            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"获取写write锁于"+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"解除写write锁于"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}

class Demo08ReadThread extends Thread{
    private Demo08Service service;

    public Demo08ReadThread(Demo08Service service) {
        this.service = service;
    }

    public void run(){
        service.read();
    }
}
class Demo08WriteThread extends Thread{
    private Demo08Service service;

    public Demo08WriteThread(Demo08Service service) {
        this.service = service;
    }

    public void run(){
        service.write();
    }
}