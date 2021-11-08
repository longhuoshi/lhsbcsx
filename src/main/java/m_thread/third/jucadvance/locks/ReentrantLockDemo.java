package m_thread.third.jucadvance.locks;

/**
 * @author l
 * @date 2021/11/8 11:40
 * @description
 * 18_可重入锁.mp4
 */
public class ReentrantLockDemo {
    //同步方法
    public synchronized void m1(){
        m1();//如果 不支持可重入锁，那么方法里调用 自己就不行。可这双是正常的写法。所以java必须支持可重入锁。
        //如果不支持可重入锁，程序第2次进入 。被 自己阻塞了岂不是天大的笑话 ，出现了作茧自缚。
    }
    public static void main(String[] args) {
        new ReentrantLockDemo().m1();
    }

    static Object objectLock = new Object();

    private static void syncBlock() {
        new Thread(()->{
            synchronized (objectLock){
                System.out.println("---外层");
                synchronized (objectLock){
                    System.out.println("---中层");
                    synchronized (objectLock){
                        System.out.println("---内层");
                    }
                }
            }
        },"t1").start();
    }
}
