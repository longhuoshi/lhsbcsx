package m_thread.basic;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author l
 * @date 2021/4/22 11:41
 * @description
 *
 * Thread的二种实现方法
 */
public class ThreeRealize {
    public static void main(String[] args) {

//        ThreeRealize realize = new ThreeRealize();
//       InsideThread insideThread = realize.new InsideThread(); // 内部类调用 方法
//        insideThread.start();


        //first  第一种、创建线程的方式是直接extends Thread覆盖run()方法即可
//        ThreadA a = new ThreadA();
//        a.start();

        //second 实现Runnable接口，实现run方法。
//        ThreadB  b =  new ThreadB();
//        Thread execute = new Thread(b);
//        execute.start();
//
//        System.out.println("这是主线程!");



    }

    class InsideThread extends Thread{

        public void run() {
            super.run();

            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是线程A");
        }
    }


}

/**
 * 第一种、创建线程的方式是直接extends Thread覆盖run()方法即可
 *
 * */
class ThreadA extends Thread{
    @Override
    public void run() {
        super.run();

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程A");
    }
}


//second
class ThreadB implements Runnable{
    //优点：Java里面可以有多个接口，解决extends的缺点。
    @Override
    public void run() {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程B");

    }
}
