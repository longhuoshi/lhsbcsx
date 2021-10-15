package m_thread.third.jucbase.sync;

/**
 * @author l
 * @date 2021/10/15 11:28
 * @description
 * 09-JUC高并发编程-线程间通信-Synchronized实现案例
 * 10-JUC高并发编程-线程间通信-虚假唤醒问题
 *
 * 有一个变量number
 * A线程负责加1 b线程负责减1
 * 效果：
 *AA 1
 *BB 0
 *AA 1
 *BB 0
 *
 */

//1、创建资源类，在资源类创建属性和方法。
class Share{
    //初始值
    private int number = 0;
    //+1的方法
    public synchronized void increase() throws InterruptedException {
        //2、在资源类操作方法
        //    判断->干活->通知 。
        while (number != 0 ){ // if判断会引起虚假唤醒的问题
            this.wait(); //在哪里睡，就在哪里醒。
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知其它线程
        this.notifyAll();

    }
    //-1的方法
    public synchronized void decrease() throws InterruptedException {
        //2、在资源类操作方法
        //    判断
        while (number != 1  ){
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知
        this.notifyAll();

    }

}
public class ThreadDemo1 {
    public static void main(String[] args) {
        //3、创建多个线程，调用 资源类中的操作方法。
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.increase();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    share.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

    }
}
