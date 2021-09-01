package main.java.m_thread.basic;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author l
 * @date 2021/4/28 15:14
 * @description
 *
 * 3.8、什么是死锁
 *
 */

//新建一个干活类的两个不同方法在等待锁
class Count3{
    private byte[] lock1 = new byte[1];
    private byte[] lock2 = new byte[1];
    public int num = 0;



    public void add(){
        synchronized (lock1){//注意这个锁的对象不一样
            try {
                Thread.sleep(801); //模仿用户干活
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock2){//产生死锁，等待lock2对象锁释放
                num+=1;
            }
            System.out.println(Thread.currentThread().getName()+"-"+num);
        }

    }

    public void lockMethod(){
        synchronized (lock2){//注意这个锁的对象不一样
            try {
                Thread.sleep(801); //模仿用户干活
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock1){//产生死锁，等待lock1锁释放
                num+=1;
            }
            System.out.println(Thread.currentThread().getName()+"-"+num);
        }

    }
}


//做两个线程，一个调用 add方法，一个调用lockMethod方法。
class ThreadB3 extends Thread{
    private Count3 count;
    public ThreadB3(Count3 count){
        this.count = count;
    }
    public void run(){
        count.lockMethod();
    }
}
class ThreadA3 extends Thread{
    private Count3 count;
    public ThreadA3(Count3 count){
        this.count = count;
    }
    public void run(){
        count.add();
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Count3 count3 = new Count3();

        ThreadB3 taskB = new ThreadB3(count3);
        taskB.setName("线程A");
        taskB.start();

        ThreadA3 task = new ThreadA3(count3);
        task.setName("线程A");
        task.start();

    }
}
