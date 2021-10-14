package m_thread.common;

/**
 * @author l
 * @date 2021/10/12 17:11
 * @description
 * 3个售票员，卖出30张票。资源是票。
 * 售票员 资提供的方法就是卖票。
 */

//资源类
class Ticket{
    private int number = 30;

    public  int getNumber() {
        return number;
    }

    public  void counter() {
        this.number--;
    }
}

//售票员
class Seller implements Runnable{
    private Ticket ticket;
    public Seller(Ticket ticket) {
        this.ticket = ticket;
    }
    public void sale(){
        synchronized (ticket){
            if (ticket.getNumber()>0){
                //模拟卖票耗时
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":卖出票号："+ticket.getNumber()+" 剩下："+(ticket.getNumber()-1)+"张");
                ticket.counter();
            }
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            sale();
        }
    }
}

public class SaleTicket {
    public static void main(String[] args) {
        //创建一个资源
        Ticket ticket = new Ticket();
        //创建三个售票员
        Seller seller1 = new Seller(ticket);
        Seller seller2 = new Seller(ticket);
        Seller seller3 = new Seller(ticket);

        new Thread(seller1,"AA").start();
        new Thread(seller2,"BB").start();
        new Thread(seller3,"CC").start();
    }
}

