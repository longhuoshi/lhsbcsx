package m_thread.basic;

import java.util.Date;

/**
 * @author l
 * @date 2021/9/24 10:53
 * @description
 * 一个简单的线程池 Demo
 * 任务
 */
public class ThreadPoolExecutorDemoRunnable implements Runnable {

    private String command;

    public ThreadPoolExecutorDemoRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Start Time = "+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" End Time = "+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
