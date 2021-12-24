package m_thread.third.jucadvance.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 * @date 2021/12/23 11:44
 * @description
 */
public class LockDownGradingDemo {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

/*
        //======= 锁降级 =======
        writeLock.lock();
        System.out.println("------write..");

        readLock.lock();  //写锁可以变为读锁。
        System.out.println("----read...");

        writeLock.unlock();
*/

        //======= 读锁不能升级为写锁 =======
        readLock.lock();
        System.out.println("----read...");

        writeLock.lock();//写锁获取失败。
        System.out.println("------write..");

        readLock.unlock();



    }
}
