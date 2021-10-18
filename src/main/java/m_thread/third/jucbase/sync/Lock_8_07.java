package m_thread.third.jucbase.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/10/18 11:16
 * @description
 * 18-JUC高并发编程-多线程锁-Synchronized锁的八种情况
 *synchronized this当前对象锁
 * static synchronized class字节对象当锁。
 *
 * 8个问题
 * 7、一个静态同步方法，一个普通同步方法，一部手机，先打印短信还是邮件。
 *----sendEmail
 * ----sendSMS
 *
 *两个方法用的锁对象不一样。sendEmail方法不用等待两秒，先执行。
 *
 */

class Phone07{
    public static synchronized  void sendSMS() throws Exception {
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

public class Lock_8_07 {
    public static void main(String[] args) throws InterruptedException {
        Phone07 phone = new Phone07();
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
