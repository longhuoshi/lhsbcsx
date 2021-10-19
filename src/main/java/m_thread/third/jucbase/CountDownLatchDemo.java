package m_thread.third.jucbase;

import java.util.concurrent.CountDownLatch;

/**
 * @author l
 * @date 2021/10/18 17:05
 * @description
 *
 * 26-JUC高并发编程-辅助类（CountDownLatch)
 *示例
 * 六个同学都离开教室后，班长才可以锁门。
 *
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        //创建CountDownLatch对象，设置初始值。
        CountDownLatch countDownLatch = new CountDownLatch(6);

        //六个同学陆续离开教室之后
        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" 号同学离开了教室");
                //计数器 -1
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        //阻塞 等待 (如果计数器不为0就一直await；等计数器变0之后，后面的代码才会被执行。)
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+" 班长锁门走人");


    }
}
