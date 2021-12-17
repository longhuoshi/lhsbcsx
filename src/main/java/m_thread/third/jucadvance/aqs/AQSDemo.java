package m_thread.third.jucadvance.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/12/17 11:43
 * @description
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

    }
}
