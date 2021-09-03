package m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/9/2 15:05
 * @description
 */
public class Demo20suspend {
    public static void main(String[] args) throws InterruptedException {
        Demo20suspendService service = new Demo20suspendService();
        Thread t1 = new Thread(){
            public void run(){
                service.printString();
            }
        };
        t1.setName("A");
        t1.start();

        Thread.sleep(10);

        Thread t2 = new Thread(){
            public void run(){
                service.printString();
            }
        };
        t2.start();


    }
}
class Demo20suspendService{
    //加了synchronized锁后，一旦执行到方法的线程被暂停，其它 所有要执行此方法的线程都被堵塞。
    synchronized public void printString(){
        System.out.println(Thread.currentThread().getName()+" 线程开始");
        if("A".equals(Thread.currentThread().getName())){
            System.out.println("A线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println(Thread.currentThread().getName()+" 线程结束");
    }
}
