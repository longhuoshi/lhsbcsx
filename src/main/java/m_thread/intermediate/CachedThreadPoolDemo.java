package main.java.m_thread.intermediate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author l
 * @date 2021/5/11 11:31
 * @description
 * 6.3 newCachedThreadPool的使用
 * 创造一个缓存池，大小可根据需要自动伸缩.
 *适用：很多短期任务，时效性要求高。
 * 工作过程 ：
 * 1、当调用 execute方法，如果线程池里有线程并线程可用，就复用线程池的。
 * 如果线程池没有用可用的线程，则创建一个新线程并添加到池中。
 * 2、终止并移动60秒，未被使用的线程
 *   */
public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+" into "+no);
                        Thread.sleep(1000L);
                        System.out.println(" end "+no);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            executor.execute(runnable);
        }
        executor.shutdown();
        System.out.println("Thread main End ! ");

    }
}
