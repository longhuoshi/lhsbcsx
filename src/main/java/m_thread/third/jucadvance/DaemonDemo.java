package m_thread.third.jucadvance;

/**
 * @author l
 * @date 2021/10/14 17:31
 * @description
 * 演示守护线程和用户线程。
 *
 */
public class DaemonDemo {
    public static void main(String[] args) {
        Thread t1 =  new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" come in:\t"+(Thread.currentThread().isDaemon() ? "守护线程" :"用户线程"));
            while (true){
            }
        },"t1");
        t1.setDaemon(true);
        t1.start();

        System.out.println(Thread.currentThread().getName()+"\t"+"----task is over");



    }
}
