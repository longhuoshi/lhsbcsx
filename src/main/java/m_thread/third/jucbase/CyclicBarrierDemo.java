package m_thread.third.jucbase;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author l
 * @date 2021/10/19 9:42
 * @description
 *
 * 27-JUC高并发编程-辅助类（CyclicBarrier）
 *    循环栅栏
 *    示例：集齐7颗龙珠就可以召唤神龙。
 *
 */
public class CyclicBarrierDemo {
    private static final int NUMBER = 7;

    public static void main(String[] args) {
        //创建CyclicBarrier
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            //CyclicBarrier的await()调用NUMBER次后，执行这个任务。
            System.out.println("*****集齐7颗龙珠就可以召唤神龙");
        });

        //集齐7颗龙珠过程。
        for (int i = 1; i <= 7 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"星龙被收集到了");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }

}
