package m_thread.third.jucbase.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/10/15 14:55
 * @description
 *
 * 13-JUC高并发编程-线程间定制化通信-案例实现
 *
 * 示例
 * 启动三个线程，按照如下要求
 * AA打印5次，BB打印10次，CC打印15次
 * AA打印5次，BB打印10次，CC打印15次
 * 进行10轮
 *
 * 解：
 * 定义 一个标致位flag
 * 1、AA线程 判断flag=1，打印5次。修改标致位flag=2，通知BB
 * 2、BB线程 判断flag=2，打印5次。修改标致位flag=3，通知CC
 * 3、CC线程 判断flag=3，打印5次。修改标致位flag=1，通知AA
 *
 * 2、在资源类操作方法
 *     判断->干活->通知 。
 * 3、创建多个线程，调用 资源类中的操作方法。
 * 4、防止虚假唤醒问题。
 */

//1、 创建资源类，在资源类创建属性和方法。
class ShareResource{
    //定位标致位
    private Integer flag=1; //1 AA;2 BB; 3 CC

    //创建lock
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //打印5次，参数第几轮
    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag != 1){
                c1.await();
            }
            //干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" ; 轮数:"+loop);

            }
            //修改标致
            flag=2;
            //通知BB线程
            c2.signal();

        }finally{
            lock.unlock();
        }
    }

    //打印10次，参数第几轮
    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag != 2){
                c2.await();
            }
            //干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" ; 轮数:"+loop);

            }
            //修改标致
            flag=3;
            //通知CC线程
            c3.signal();

        }finally{
            lock.unlock();
        }
    }

    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            //判断
            while (flag != 3){
                c3.await();
            }
            //干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+" :: "+i+" ; 轮数:"+loop);

            }
            //修改标致
            flag=1;
            //通知AA线程
            c1.signal();

        }finally{
            lock.unlock();
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    resource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

    }
}
