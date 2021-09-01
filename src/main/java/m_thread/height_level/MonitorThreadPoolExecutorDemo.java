package main.java.m_thread.height_level;

import java.sql.SQLOutput;
import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/5/17 10:54
 * @description
 *
 * 9.1 Java 线程池的监控
 */
public class MonitorThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(700L);
        ExecutorService executor = new MonitorThreadPoolExecutor(5,5,0L,TimeUnit.MILLISECONDS,new LinkedBlockingDeque<>());
        for (int i = 0; i < 3; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(runnable);
        }
        executor.shutdown();
        System.out.println("Thread Main End!");

    }

}
class MonitorThreadPoolExecutor extends ThreadPoolExecutor{


    public MonitorThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }


    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("work_task before:"+t.getName());
    }


    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        System.out.println("work_task after worker thread is:"+r);

    }


    @Override
    protected void terminated() {

        System.out.println("terminated getCorePoolSize:"+this.getCorePoolSize()+"; getPoolSize:"+this.getPoolSize()
                +"; getTaskCount:"+this.getTaskCount()+"; getCompletedTaskCount:"+this.getCompletedTaskCount()
                +"; getLargestPoolSize:"+this.getLargestPoolSize()+"; getActiveCount:"+this.getActiveCount());
        System.out.println("ThreadPoolExecutor terminated!");
    }
}