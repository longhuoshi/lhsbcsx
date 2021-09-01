package main.java.m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/8/31 10:24
 * @description
 *
 * 多线程序共享数据安全
 *
 */
public class Demo07share {
    public static void main(String[] args) {
        Thread  t = new Demo07Thread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class Demo07Thread extends Thread{
    private  int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+",count="+count);
    }
}