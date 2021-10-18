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
 * 2、停2秒在短信方法内，先打印短信还是邮件
 *----sendSMS
 * ----sendEmail
 *
 *sendSMS和sendEmail用的是同一个锁this，同一个锁是先抢到先执行.
 * 后面的线程要等前面的线程释放了锁，后面的线程抢到锁后才能执行。
 *
 */

class Phone02{
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

public class Lock_8_02 {
    public static void main(String[] args) throws InterruptedException {
        Phone02 phone = new Phone02();
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
