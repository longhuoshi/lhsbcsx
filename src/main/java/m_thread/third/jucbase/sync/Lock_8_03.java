package m_thread.third.jucbase.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/10/18 11:16
 * @description
 * 18-JUC高并发编程-多线程锁-Synchronized锁的八种情况
 *synchronized this当前对象锁
 * static synchronized class字节文件当锁。
 *
 * 8个问题
 * 3、一个线程执行发送短信，一个线程执行普通方法getHello，先打印getHello还是短信
 *----getHello
 * ----sendSMS
 *
 * 因为getHello方法没有锁，所线程一启动不要等待就执行。
 *
 */

class Phone03{
    public  synchronized  void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("----sendSMS");
    }
    public synchronized  void sendEmail() throws Exception {
        System.out.println("----sendEmail");
    }
    public  void getHello() {
        System.out.println("----getHello");
    }
}

public class Lock_8_03 {
    public static void main(String[] args) throws InterruptedException {
        Phone03 phone = new Phone03();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                phone.getHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
