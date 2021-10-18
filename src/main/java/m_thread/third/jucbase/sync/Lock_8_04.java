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
 * 4、现在有两部手机，先打印短信还是邮件
 *----sendEmail
 * ----sendSMS
 *
 * 因为发送短信和邮件的方法是synchronized修饰的，用的是对象的this锁。
 * 两部手机(两个资源) 用的是两个对象。持的是两把锁。
 *
 */

//资源类
class Phone04{
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

public class Lock_8_04 {
    public static void main(String[] args) throws InterruptedException {
        Phone04 phone = new Phone04();
        Phone04 phone2 = new Phone04();
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
                phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
    }
}
