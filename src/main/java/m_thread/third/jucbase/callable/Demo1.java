package m_thread.third.jucbase.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author l
 * @date 2021/10/18 16:09
 * @description
 *
 * 23-JUC高并发编程-Callable接口-概述
 *
 *Runnable和Callable接口
 * 1）是否有返回值
 * 2） 是否拋出异常
 * 3）实现方法名称不同，一个是run方法，一个是call方法
 *
 * 比较两个接口。
 */
class MyThread1 implements Runnable{
    @Override
    public void run() {

    }
}
class MyThread2 implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" come in callable");
        return 200;
    }
}


public class Demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Runnable接口 创建线程
        new Thread(new MyThread1(),"AA").start();

        //Callable接口 创建线程
//        new Thread(new MyThread2(),"AA").start(); //报错
        //分析 ：Thread里只有Runnable类型的参数， 没有Callable接口类型的参数 。但我们又要用Callable接口的功能。
        // 我要找个中间类，既和Runnable有关系 ，又和Callable也有关系。

        FutureTask<Integer>  futureTask1 = new FutureTask<>(new MyThread2());

        //lam表达式
        FutureTask<Integer> futureTask2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" come in callable");
           return 1024;
        });
        new Thread(futureTask2,"lucy").start();
        new Thread(futureTask1,"mary").start();


        //等待任务完成
//        while (!futureTask2.isDone()){
//            System.out.println("wait...");
//        }

        //调用FutureTask的get方法。
        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());


        


    }
}
