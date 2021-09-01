package main.java.m_thread.intermediate;


import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.CountDownLatch;

/**
 * @author l
 * @date 2021/5/6 16:08
 * @description
 *
 * 5.9 同步计数器CountDownLatch
 *
 *
 */
public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        Worker worker = new Worker("Jack 程序员1",latch);
        Student worker2 = new Student("Rose 程序员2",latch);
        Worker worker3 = new Worker("JSon 程序员3",latch);
        worker.start();
        worker2.start();
        worker3.start();
        System.out.println("Main Before latch.await()");
        latch.await(); // 所有任务执行完，再执行后面的代码
        System.out.println("Main thread end!");



    }

    static class Worker extends Thread{
        private String workerName;
        private CountDownLatch latch;
        public Worker(String workerName,CountDownLatch latch){
            this.workerName = workerName;
            this.latch = latch;
        }
        public void run(){
            try {
                System.out.println("Worker:"+workerName+"is begin.");
                Thread.sleep(1000L);
                System.out.println("Worker:"+workerName+" is end. ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }
    }

    static class Student extends Thread{
        private String workerName;
        private CountDownLatch latch;
        public Student(String workerName,CountDownLatch latch){
            this.workerName = workerName;
            this.latch = latch;
        }
        public void run(){
            try {
                System.out.println("Student:"+workerName+"is begin.");
                Thread.sleep(1000L);
                System.out.println("Student:"+workerName+" is end. ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            latch.countDown();
        }
    }
}
