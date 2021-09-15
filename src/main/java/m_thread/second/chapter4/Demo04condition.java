package m_thread.second.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/9/14 11:52
 * @description
 *3. 使用Condition唤醒不同的线程
 *
 */
public class Demo04condition {
    public static void main(String[] args) throws InterruptedException {
        Demo04conditionService service = new Demo04conditionService();
        Thread t1 = new Demo04conditionThreadA(service);
        t1.setName("A");
        t1.start();


        Thread t2 = new Demo04conditionThreadB(service);
        t2.setName("B");
        t2.start();

        Thread.sleep(2000);
        service.signalAll_A();

    }
}

class Demo04conditionService{
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public void awaitA(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"，awaitA方法开始于"+System.currentTimeMillis());
            conditionA.await();//需要 在同步代码块中调用 ，否则 会抛出IllegalMonitorStateException
            System.out.println(Thread.currentThread().getName()+"，awaitA方法结束于"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"，awaitB方法开始于"+System.currentTimeMillis());
            conditionB.await();//需要 在同步代码块中调用 ，否则 会抛出IllegalMonitorStateException
            System.out.println(Thread.currentThread().getName()+"，awaitB方法结束于"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll_A(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "唤醒所有的线程在" +System.currentTimeMillis());
            conditionA.signalAll();
        }finally {
            lock.unlock();

        }
    }
    public void signalAll_B(){
        try{
            lock.lock();
            System.out.println(Thread.currentThread().getName()+ "唤醒所有的线程在" +System.currentTimeMillis());
            conditionB.signalAll();
        }finally {
            lock.unlock();

        }
    }
}

class Demo04conditionThreadA extends  Thread{
    private Demo04conditionService service;

    public Demo04conditionThreadA(Demo04conditionService service) {
        this.service = service;
    }

    public void run(){
        service.awaitA();
    }

}
class Demo04conditionThreadB extends  Thread{
    private Demo04conditionService service;

    public Demo04conditionThreadB(Demo04conditionService service) {
        this.service = service;
    }

    public void run(){
        service.awaitB();
    }

}

