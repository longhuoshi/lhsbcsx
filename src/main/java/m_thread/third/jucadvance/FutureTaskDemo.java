package m_thread.third.jucadvance;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/10/25 15:16
 * @description
 *
 * D:\javaxxz\ed\javaEE\【No1417】大厂面试之JUC并发编程与源码分析教程\JUC并发编程与源码分析
 * 05_对Future的改进
 *不要阻塞，尽量用轮询替代
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask futureTask = new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+"\t---come in");
            TimeUnit.SECONDS.sleep(3);
            return 1024;
        });
        new Thread(futureTask,"t1").start();
//        System.out.println(futureTask.get());//不见不散
//        System.out.println(futureTask.get(1L,TimeUnit.SECONDS));//过时不候

        System.out.println("阳哥继续上课...");
        //不要阻塞，尽量用轮询替代
        while (true){
            if (futureTask.isDone()){
                System.out.println("----result："+futureTask.get());
                break;
            }else {
                System.out.println("还在计算中，别催，越催越慢，再催熄火");
            }
        }

    }
}
