package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/8 9:37
 * @description
 *
 * 33.线程的同步机制-synchronized同步语句-死锁
 *
 */
public class Demo23deadlock {
    public static void main(String[] args) throws InterruptedException {
        Demo23deadlockThread taskThread = new Demo23deadlockThread();

        taskThread.setFlag("a");
        Thread t1 = new Thread(taskThread);
        t1.start();

        Thread.sleep(10); //等t1先运行起来,制造死锁。

        taskThread.setFlag("b");
        Thread t2 = new Thread(taskThread);
        t2.start();

    }
}

class Demo23deadlockThread extends  Thread{
    private String flag;//标志，控制代码以什么样的方式运行
    private Object lock1 = new Object();
    private Object lock2 = new Object();
    public void setFlag(String flag){
        this.flag = flag;
    }

    public void run(){
        try {
            if ("a".equals(flag)){
                synchronized(lock1){
                    System.out.println("flag="+flag);
                    Thread.sleep(1000);
                    synchronized(lock2) {
                        System.out.println("按lock1=>lock2的顺序执行");
                    }
                }
            }else {
                synchronized(lock2){
                    System.out.println("flag="+flag);
                    Thread.sleep(1000);
                    synchronized(lock1) {
                        System.out.println("按lock2=>lock1的顺序执行");
                    }
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
