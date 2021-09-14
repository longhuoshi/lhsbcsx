package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/14 11:17
 * @description
 */
public class Demo20threadLocal {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        Thread t1 = new Demo20threadLocalThreadA(tl);
        t1.setName("A");
        t1.start();

        Thread t2 = new Demo20threadLocalThreadA(tl);
        t2.setName("B");
        t2.start();
    }
}
class Demo20threadLocalThreadA extends Thread{
    private ThreadLocal tl;

    public Demo20threadLocalThreadA(ThreadLocal tl) {
        this.tl = tl;
    }

    public void run(){
        try {
            for (int i = 0; i < 100; i++) {
                tl.set(Thread.currentThread().getName()+(i+1));
                System.out.println(Thread.currentThread().getName()+" get value = "+tl.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
