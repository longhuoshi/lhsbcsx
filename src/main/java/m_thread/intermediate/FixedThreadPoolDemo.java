package main.java.m_thread.intermediate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author l
 * @date 2021/5/11 11:31
 * @description
 *单个任务小，而任务数量巨大，最适合用线程池。
 *
 * 6.4 newFixedThreadPool的使用
 * 创造一个可重复使用线程，固定大小的线程池，
 * 往线程池里添加任务，如果线程池没有可用的线程，那么任务会添加到一个无界队列中等待。
 * 在某个线程被显式地关闭之前，池中的线程将一直存在。
 *
 *   */
public class FixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            final int no = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+" into "+no);
                        Thread.sleep(5000L);
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
