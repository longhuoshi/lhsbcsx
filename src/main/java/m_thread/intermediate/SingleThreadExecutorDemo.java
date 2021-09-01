package main.java.m_thread.intermediate;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author l
 * @date 2021/5/11 11:31
 * @description
 * 6.2 newSingleThreadExecutor的使用
 */
public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
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
