package m_thread.second.chapter4;

import java.lang.management.ManagementFactory;
import java.time.LocalDateTime;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

/**
 * @author l
 * @date 2021/9/15 10:50
 * @description
 *57.Lock-ReentranLock-使用Lock实现生产者、消费者
 */
public class Demo05producerConsumer {
    public static void main(String[] args) {

        Demo05producerConsumerService service = new Demo05producerConsumerService();
        int size = 3;
        Thread[] produces = new Thread[size];
        Thread[] consumers = new Thread[size];
        for (int i = 0; i < size; i++) {
            char c= (char)('A'+i);
            produces[i] = new Demo05producerThread(service);
            produces[i].setName("生产者"+c);
            produces[i].start();

            consumers[i] = new Demo05consumerThread(service);
            consumers[i].setName("消费者"+c);
            consumers[i].start();



        }

    }
}


class  Demo05producerConsumerService{
    private Lock lock = new ReentrantLock();
    private Condition conditionProducer = lock.newCondition();
    private Condition conditionConsumer = lock.newCondition();
    private String val = "";

    public void producer(){
        try{
            lock.lock();
            while (!"".equals(val)){
                conditionProducer.await();
            }
            val = "宝马X3-"+System.nanoTime();
            System.out.println(Thread.currentThread().getName()+",生产值："+val);
            conditionConsumer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void consumer(){
        try{
            lock.lock();
            while ("".equals(val)){
                conditionConsumer.await();
            }
            System.out.println(Thread.currentThread().getName()+",消费值："+val);
            val = "";
            conditionProducer.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Demo05producerThread extends Thread{
    private Demo05producerConsumerService service;

    public Demo05producerThread(Demo05producerConsumerService service) {
        this.service = service;
    }

    public void run(){
        while (true){
            service.producer();
        }
    }

}

class Demo05consumerThread extends Thread{
    private Demo05producerConsumerService service;

    public Demo05consumerThread(Demo05producerConsumerService service) {
        this.service = service;
    }

    public void run(){
        while (true){
            service.consumer();
        }
    }

}