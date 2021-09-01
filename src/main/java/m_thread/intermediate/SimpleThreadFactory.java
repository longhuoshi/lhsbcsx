package main.java.m_thread.intermediate;

import java.util.concurrent.ThreadFactory;

/**
 * @author l
 * @date 2021/5/12 10:10
 * @description
 *6.7 自定义线程池与ExecutortorService
 * 2、自用ThreadFactory他创建一个新线程
 *
 *
 */
public class SimpleThreadFactory implements ThreadFactory {

    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
