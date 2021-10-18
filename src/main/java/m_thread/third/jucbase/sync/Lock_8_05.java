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
 * 5、两个静态同步方法，一部手机，先打印短信还是邮件
 *----sendSMS
 *----sendEmail
 *
 * 锁的范围是Class字节码对象。
 *两个方法持的都是class字节码锁。同一把锁要排队执行，抢到锁的才有执行权，其它 线程要等待。
 *
 */

class Phone05{
    public static synchronized  void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("----sendSMS");
    }
    public static synchronized  void sendEmail() throws Exception {
        System.out.println("----sendEmail");
    }
    public  void getHello() {
        System.out.println("----getHello");
    }
}

public class Lock_8_05 {
    public static void main(String[] args) throws InterruptedException {
        Phone05 phone = new Phone05();
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
