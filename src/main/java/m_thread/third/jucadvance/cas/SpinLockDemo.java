package m_thread.third.jucadvance.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author l
 * @date 2021/11/24 14:48
 * @description
 * 自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void MyLock()  {
        System.out.println(Thread.currentThread().getName()+"--------------come in");
        while (!atomicReference.compareAndSet(null,Thread.currentThread())){
        }
        System.out.println(Thread.currentThread().getName()+"--------------持有锁成功");
    }

    public void MyUnLock()  {
        atomicReference.compareAndSet(Thread.currentThread(),null);
        System.out.println(Thread.currentThread().getName()+"--------------释放锁成功");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLock = new SpinLockDemo();
        new Thread(()->{
            spinLock.MyLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.MyUnLock();
        },"t1").start();

        new Thread(()->{
            spinLock.MyLock();
            spinLock.MyUnLock();
        },"t2").start();
    }
}
