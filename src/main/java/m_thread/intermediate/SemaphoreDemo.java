package main.java.m_thread.intermediate;

import java.util.concurrent.Semaphore;

/**
 * @author l
 * @date 2021/5/7 11:09
 * @description
 *
 * 5.11 同步计数器Semaphore
 *
 * 使用场景：排队场景，资源有限的房间，资源有限的群等等。
 * 常见的实际应用场景包括线程池，连接池等。
 *
 * 实例：假设一个服务器资源有限，只允许同时3个人进行访问，一共来了10个人的场景 。
 *
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(3);//一次只运行3个人进行访问。
        for (int i = 0; i < 10; i++) {
            final int no = i;
            Runnable thread = new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("用户"+no+"连接上了：");
                        Thread.sleep(300L);
                        semaphore.acquire();//获取接下来执行的许可
                        System.out.println("用户"+no+"开始访问后台程序...");
                        Thread.sleep(1000L);//模仿用户访问服务器过程
                        semaphore.release();//释放，允许下一个线程访问进入后台
                        System.out.println("用户"+no+"访问结束 。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(thread).start();

        }
    }
}
