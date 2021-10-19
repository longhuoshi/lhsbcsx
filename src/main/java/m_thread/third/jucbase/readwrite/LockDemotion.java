package m_thread.third.jucbase.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 * @date 2021/10/19 16:55
 * @description
 * 32-JUC高并发编程-读写锁-读写锁的降级
 *
 *
锁降级：将写入锁降级为读锁。读锁不能升级为写锁。
jdk8说明 ：获取写锁->获取读锁->释放写锁->释放读锁
 */
public class LockDemotion {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock(); //读锁
        ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock(); //写锁

        //锁降级
        //1、获取写锁
        writeLock.lock();
        System.out.println("lhs");
        //2、获取读锁。
        readLock.lock();
        System.out.println("---read");
        //3、释放写锁。
        writeLock.unlock();
        //4、释放读锁。
        readLock.unlock();


    }
}
