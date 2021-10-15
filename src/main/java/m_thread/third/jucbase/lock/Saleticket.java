package m_thread.third.jucbase.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/10/15 10:52
 * @description
 */
class Ticket{
    private int number = 30;
    private final ReentrantLock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if (number>0){
                System.out.println(Thread.currentThread().getName()+":卖出票号："+(number--)+" 剩下："+(number)+"张");
            }

        }finally{
            lock.unlock();
        }
    }

}
public class Saleticket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 0; i < 40 ; i++) {
                ticket.sale();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 40 ; i++) {
                ticket.sale();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 40 ; i++) {
                ticket.sale();
            }
        },"CC").start();

    }
}
