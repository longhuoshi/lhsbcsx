package m_thread.third.jucbase.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/10/18 15:32
 * @description
 *
 * 22-JUC高并发编程-多线程锁-死锁
 * 两个或两个以上的进程(线程)在执行过程中，因为争夺资源而造 成一种互相等待的现象 ，
 * 如果 没有外力干涉，他们无法再执行下去 。
 * 产生死锁原因：
 * 第一 系统资源不足
 * 第二 进程运行推进顺序不合适
 * 第三 资源分配不当。
 *
 * 验证是否是死锁？
 *1) jps  类似linux ps -ef   查看程序对应的进程 id
 *  jps -l
 *2) jstack jvm自带堆栈跟踪工具。
 *  jstack 进程id
 *
 */
public class DeadLock {
    //创建两个对象
    static Object a = new Object();
    static Object b = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+" 持有锁a，试图获取锁b");

                //等待B线程进入锁b代码块。
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+" 获取锁b");
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+" 持有锁b，试图获取锁a");

                //等待A线程进入锁a代码块。
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+" 获取锁a");
                }
            }
        },"B").start();

    }
}
