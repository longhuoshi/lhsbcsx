package m_thread.second.chapter4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/9/14 11:52
 * @description
 *
 */
public class Demo03condition {
    public static void main(String[] args) throws InterruptedException {
        Demo03conditionService service = new Demo03conditionService();
        Thread t = new Demo03conditionThread(service);
        t.start();
        Thread.sleep(2000);
        service.signal();

    }
}

class Demo03conditionService{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void await(){
        try {
            lock.lock();
            System.out.println("await方法开始于"+System.currentTimeMillis());
            condition.await();//需要 在同步代码块中调用 ，否则 会抛出IllegalMonitorStateException
            System.out.println("await方法结束于"+System.currentTimeMillis());
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void signal(){
        lock.lock();
        System.out.println("signal方法开始于"+System.currentTimeMillis());
        condition.signal();
        lock.unlock();
    }
}

class Demo03conditionThread extends  Thread{
    private Demo03conditionService service;

    public Demo03conditionThread(Demo03conditionService service) {
        this.service = service;
    }

    public void run(){
        service.await();
    }

}
