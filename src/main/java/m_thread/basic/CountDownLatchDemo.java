package m_thread.basic;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/10/21 11:50
 * @description
 * 子，有三个工人在为老板干活，这个老板有一个习惯，就是当三个工人把一天的活都干完了的时候，他就来检查所有工人所干的活。
 * 记住这个条件：三个工人先全部干完活，老板才检查。所以在这里用Java代码设计两个类，Worker代表工人，Boss代表老板
 *
 */

class Worker implements Runnable{
    private String name;
    private CountDownLatch downLatch;
    public Worker(String name,CountDownLatch downLatch){
        this.name = name;
        this.downLatch = downLatch;

    }

    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(6));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.name + " 活干完了！");
        downLatch.countDown();
    }

    private void doWork(){
        System.out.println(this.name + " 正在干活！");
    }
}


class Boss implements Runnable{
    private CountDownLatch downLatch;
    public Boss(CountDownLatch downLatch){
        this.downLatch = downLatch;

    }

    @Override
    public void run() {
        System.out.println("老板正在等待所有的工人干完活...");
        try {
            downLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( "工人都干完活了，老板开始检查了！");

    }

}

public class CountDownLatchDemo {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(4);
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch downLatch = new CountDownLatch(3);
        Worker worker1 = new Worker("吴亦凡",downLatch);
        Worker worker2 = new Worker("李云迪",downLatch);
        Worker worker3 = new Worker("黄海波",downLatch);
        Boss boss = new Boss(downLatch);
        executor.execute(worker1);
        executor.execute(worker2);
        executor.execute(worker3);
        executor.execute(boss);

        executor.shutdown();

    }
}
