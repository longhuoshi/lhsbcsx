package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/6 17:33
 * @description
 * 17.线程的同步机制-synchronized同步方法-synchronized方法锁定的是整个对象
 *
 * A线先持有Object对象的对象锁，B线程就不可以异步方式 调用 Object对象使用synchronized修饰 的方法(因为synchronized用的就是Object对象的对象锁)。
 * 线程B只有等线程A的方法执行完，释放Object对象的对象锁才能执行。
 */
public class Demo04synchronized {
    public static void main(String[] args) {
        Demo04synchronizedService service = new Demo04synchronizedService();
        Thread t = new Demo04synchronizedThreadA(service);
        Thread t2 = new Demo04synchronizedThreadB(service);
        t.start();
        t2.start();

    }
}

class Demo04synchronizedService{
    synchronized public void foo1(){
        System.out.println("开始运行foo1方法，threadName:"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo1方法运行结束");
    }
    synchronized public void foo2(){
        System.out.println("开始运行foo2方法，threadName:"+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("foo2方法运行结束");
    }
}

class Demo04synchronizedThreadA extends Thread{
    private Demo04synchronizedService service;

    public Demo04synchronizedThreadA(Demo04synchronizedService service) {
        this.service = service;
    }
    public void run(){
        service.foo1();
    }
}
class Demo04synchronizedThreadB extends Thread{
    private Demo04synchronizedService service;

    public Demo04synchronizedThreadB(Demo04synchronizedService service) {
        this.service = service;
    }
    public void run(){
        service.foo2();
    }
}