package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/8 11:50
 * @description
 * 38.线程间的通信-wait与notify-wait与notifty机制的实现
 */
public class Demo03notify {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Demo03notifyThreadA(lock);
        t1.setName("A");
        t1.start();
        Thread.sleep(12);
        Thread t3 = new Demo03notifyThreadA(lock);
        t3.setName("C");
        t3.start();

        Thread.sleep(3000);
        Thread t2 = new Demo03notifyThreadB(lock);
        t2.start();

    }
}

class Demo03notifyThreadA extends Thread{
    private Object lock;


    public Demo03notifyThreadA(Object lock) {
        this.lock = lock;
    }
    public void run(){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"线程开始等待在"+System.currentTimeMillis());
                Thread.sleep(1000);
                lock.wait(); //执行到wait方法会自动 释放锁。
                System.out.println(Thread.currentThread().getName()+"线程结束等待在"+System.currentTimeMillis());

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Demo03notifyThreadB extends Thread{
    private Object lock;
    public Demo03notifyThreadB(Object lock) {
        this.lock = lock;
    }
    public void run(){
        try {
            //notify代码块的锁对象必须要跟wait所在同步代码块的锁一致，否则报 IllegalMonitorStateException
    //        synchronized (new Object()){
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"线程准备发出通知在"+System.currentTimeMillis());
                lock.notify();
                System.out.println(Thread.currentThread().getName()+"线程结束发出通知在"+System.currentTimeMillis());
                Thread.sleep(1000);//要等synchronized代码块执行完成，才会执行被notify唤醒的线程。
            }
//            Thread.sleep(1000); 没有在synchronized代码块内，所以这里休眠不影响被notify唤醒线程的执行。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
