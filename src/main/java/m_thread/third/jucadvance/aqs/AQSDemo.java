package m_thread.third.jucadvance.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/12/17 11:43
 * @description
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        //ABC三个顾客，去银行办理业务，A先到，此时窗口空无一人，他优先获得办理窗口的机会，办理业务。
        //A耗时严重，估计长期占有窗口
        new Thread(()->{
            reentrantLock.lock();
            try{
                System.out.println("----come in A");
                //暂停50分钟线程
                try {
                    TimeUnit.MILLISECONDS.sleep(50000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }finally {
                reentrantLock.unlock();
            }
        },"A").start();

        //B是第2个，B一看到受理窗口被A占用，只能去候客区等待，进入AQS队列 ，等待着A办理完成，
        new Thread(()->{
            reentrantLock.lock();
            try{
                System.out.println("----come in B");
            }finally {
                reentrantLock.unlock();
            }
        },"A").start();

    }
}
