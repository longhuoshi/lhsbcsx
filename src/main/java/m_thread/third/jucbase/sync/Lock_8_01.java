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
 * 1、标准访问，先打印短信还是邮件
 *----sendSMS
 * ----sendEmail
 *
 *sendSMS和sendEmail用的是同一个锁this，同一个锁是先抢到先执行.
 * 后面的线程要等前面的线程释放了锁，后面的线程抢到锁后才能执行。
 */

class Phone01{
    public  synchronized  void sendSMS() throws Exception {
        System.out.println("----sendSMS");
    }
    public synchronized  void sendEmail() throws Exception {
        System.out.println("----sendEmail");
    }
    public  void getHello() {
        System.out.println("----getHello");
    }
}

public class Lock_8_01 {
    public static void main(String[] args) throws InterruptedException {
        Phone01 phone = new Phone01();
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
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
