package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/7 17:27
 * @description
 * 30.线程的同步机制-synchronized同步语句-静态同步synchronized方法与synchronized(class)代码块
 * 静态方法使用的synchronized锁是class
 * 非静态方法使用的synchronized锁是this
 * 不是同一个锁，所以两个线程可以同时进入方法里执行。
 */
public class Demo19 {
    public static void main(String[] args) {
        Demo19Service service = new Demo19Service();
        Thread t1 = new Demo19ThreadA(service);
        t1.setName("A");
        t1.start();

        Thread t2 = new Demo19ThreadB(service);
        t2.setName("B");
        t2.start();


    }
}

class Demo19Service{
    synchronized public static void foo1(){
        System.out.println(Thread.currentThread().getName()+"进入foo1方法在"+System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束f001方法在"+System.currentTimeMillis());
    }
//    synchronized public void foo2(){
    synchronized public void foo2(){
        synchronized(Demo19Service.class){ //用class对象可以同步。
            System.out.println(Thread.currentThread().getName()+"进入foo2方法在"+System.currentTimeMillis());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"结束foo2方法在"+System.currentTimeMillis());

        }
    }
}

class Demo19ThreadA extends Thread{
    private Demo19Service service;

    public Demo19ThreadA(Demo19Service service) {
        this.service = service;
    }
    public void run(){
        service.foo2();
    }
}

class Demo19ThreadB extends Thread{
    private Demo19Service service;

    public Demo19ThreadB(Demo19Service service) {
        this.service = service;
    }
    public void run(){
        service.foo1();
    }
}
