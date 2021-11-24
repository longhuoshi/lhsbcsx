package m_thread.third.jucadvance.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/11/24 14:11
 * @description
 */
public class DeadLock {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        ReentrantLock reentrantLock2 = new ReentrantLock();
        new Thread(()->{
            try {

                reentrantLock.lock();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("111111111");
                    reentrantLock2.lock();
                    System.out.println("2222222222222");
                    reentrantLock2.unlock();
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


        new Thread(()->{
            try {
                reentrantLock2.lock();
                TimeUnit.SECONDS.sleep(1);
                System.out.println("33333333333333");
                    reentrantLock.lock();
                    System.out.println("44444444444444");
                    reentrantLock.unlock();
                reentrantLock2.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }
}
