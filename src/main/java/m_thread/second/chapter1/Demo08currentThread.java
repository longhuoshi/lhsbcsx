package main.java.m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/8/31 10:33
 * @description
 * currentThread方法
 * 返回代码正在那个线程调用的详细信息
 */
public class Demo08currentThread {
    public static void main(String[] args) {
        Thread t = new Demo08currentThread_1();
        t.start();
        System.out.println("main方法："+Thread.currentThread().getName());
    }
}

class Demo08currentThread_1 extends Thread{

    public Demo08currentThread_1() {
        System.out.println("构造方法开始 ");
        System.out.println("构造方法："+Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("构造方法结束 ");
    }


    @Override
    public void run() {
        System.out.println("run方法开始 ");
        System.out.println("run方法："+Thread.currentThread().getName());
        System.out.println(this.getName());
        System.out.println("run方法结束 ");

    }
}