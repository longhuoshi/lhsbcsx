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
 * 6、两个静态同步方法，两部手机，先打印短信还是邮件
 *----sendSMS
 * ----sendEmail
 **两个方法持的都是class字节码锁。同一把锁要排队执行，抢到锁的才有执行权，其它 线程要等待。
 */

class Phone06{
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

public class Lock_8_06 {
    public static void main(String[] args) throws InterruptedException {
        Phone06 phone = new Phone06();
        Phone06 phone2 = new Phone06();
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
