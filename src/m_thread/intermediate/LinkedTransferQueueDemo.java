package m_thread.intermediate;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author l
 * @date 2021/5/6 15:15
 * @description
 *
 * 5.8 链表传输队列LinkedTransferQueue
 *
 */

class Consumer implements Runnable{

   private final TransferQueue<String> queue;
   public Consumer(TransferQueue<String> queue){
       this.queue = queue;
   }
    public void run() {
        try {
            System.out.println(" Consumer " + Thread.currentThread().getName()
                    +queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Producer implements Runnable{
    private final TransferQueue<String> queue;
    public Producer(TransferQueue<String> queue) {
        this.queue = queue;
    }
    private String produce(){
        return " yhour lucky number "+(new Random().nextInt(100));
    }

    @Override
    public void run() {
        while(true){
            try {
                if (queue.hasWaitingConsumer()){
                    queue.transfer(produce());
                }

                //产生者睡眠1s，这样可以看出程序的执行过程 。
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class LinkedTransferQueueDemo {
    public static void main(String[] args) {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();
        Thread producer = new Thread(new Producer(queue));
//        设置为守护进程使得线程执行结束后程序自动结束运行。
        producer.setDaemon(true);
        producer.start();

        for (int i = 0; i < 10; i++) {
            Thread consumer = new Thread(new Consumer(queue));
            consumer.setDaemon(true);
            consumer.start();

            try {
                //消费者进程休眠1s，以便生产者获得cpu，从而生产产品。
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
