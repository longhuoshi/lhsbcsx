package main.java.m_thread.intermediate;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author l
 * @date 2021/5/7 11:43
 * @description
 *
 * 5.12 同步计数器CyclicBarrier
 *
 * 使用场景：大数据运算需要拆分成多步骤的时候，比如这么一个实际应用场景：我们需要统计全国的
 * 业务数据，其中各省的数据库是独立的，也就是说按省分库，并且统计的数据量很大，统计过程也比
 * 较慢。为了提高性能，快速计算，我们采取并发的方式，多个线程同时计算各省数据，每个省下面又
 * 用多线程，最后再汇总统计
 *
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4,new TotalTask());
        BillTask worker = new BillTask("111",barrier);
        BillTask worker2 = new BillTask("222",barrier);
        BillTask worker3 = new BillTask("333",barrier);
        worker.start();
        worker2.start();
        worker3.start();
        System.out.println("Main thread end! ");


    }

    static class TotalTask extends Thread{
        public void run(){
            System.out.println("所有子任务都执行完了，就开始执行主任务了");
        }
    }

    static class BillTask extends Thread{
        private String billName;
        private CyclicBarrier barrier;
        public BillTask(String workerName,CyclicBarrier barrier){
            billName = workerName;
            this.barrier = barrier;
        }

        public void run(){
            try {
                System.out.println("市区："+billName+"运算开始：");
                Thread.sleep(1000L);//模仿第一次运算
                System.out.println("市区："+billName+"运算完成，等待...");
                //假设一次运算不完，第二次要依赖第一次的运算结果 ，
                //都到达这个节点之后后面才会继续执行。
                barrier.await();
                System.out.println("全部都结束 ，市区"+billName+"才开始后面的工作。");

            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
