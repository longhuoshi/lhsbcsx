package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/9 17:20
 * @description
 * 41.线程间的通信-wait与notify-只唤醒一个线程或所有线程
 *
 */
public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Demo05ThreadA(lock);
        t1.setName("A");
        t1.start();
        Thread t2 = new Demo05ThreadA(lock);
        t2.setName("B");
        t2.start();
        Thread t3 = new Demo05ThreadA(lock);
        t3.setName("C");
        t3.start();
        Thread.sleep(1000);
        //启动换醒线程
        Thread t4 = new Demo05ThreadB(lock);
        t4.start();


    }
}

class Demo05Service{
    public void foo(Object lock){
        try {
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "进入了foo方法，准备执行wait方法");
                lock.wait();
                System.out.println(Thread.currentThread().getName()+"结束了foo方法");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo05ThreadA extends Thread{
    private Object lock;
    public Demo05ThreadA(Object lock) {
        this.lock = lock;
    }
    public void run(){
        Demo05Service service = new Demo05Service();
        service.foo(lock);
    }
}
class Demo05ThreadB extends Thread{
    private Object lock;
    public Demo05ThreadB(Object lock) {
        this.lock = lock;
    }
    public void run(){
        synchronized (lock){
//            lock.notify();//仅随机唤醒一个线程
            lock.notifyAll();
        }
    }
}