package m_thread.basic;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/4/28 15:45
 * @description
 * 3.11、单例模式的写法
 * 线程安全，性能又高的写法
 * */
public class Singleton2 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Singleton2 instance;
    private Singleton2(){}
    public static Singleton2 getInstance(){
        if (instance==null){
            lock.lock();
            if (instance==null){
                instance = new Singleton2();
            }
            lock.unlock();

        }
        return instance;
    }
}
