package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/7 14:31
 * @description
 *
 * 22.线程的同步机制-synchronized同步方法-同步不具有继承性
 *
 */
public class Demo08 {
    public static void main(String[] args) {
        Demo08ServiceB service = new Demo08ServiceB();
        Thread t = new Demo08Thread(service);
        t.setName("A");
        t.start();

        Thread t2 = new Demo08Thread(service);
        t2.setName("B");
        t2.start();
    }
}

class Demo08ServiceA{
    synchronized public void foo(){
        try {
            System.out.println("父类："+Thread.currentThread().getName()+",开始于"+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("父类："+Thread.currentThread().getName()+",结束于"+System.currentTimeMillis());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Demo08ServiceB extends Demo08ServiceA{
    synchronized public void foo(){
        try {
            System.out.println("子类："+Thread.currentThread().getName()+",开始于"+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("子类："+Thread.currentThread().getName()+",结束于"+System.currentTimeMillis());
            super.foo();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo08Thread extends Thread{
    Demo08ServiceB service;

    public Demo08Thread(Demo08ServiceB service) {
        this.service = service;
    }

    public void run(){
        service.foo();
    }
}