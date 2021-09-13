package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/10 17:11
 * @description
 *
 * 说多生产者和多消费者，可能 出现 线程全部等待的问题，要用notifyAll解决
 * (我是没试出来 。)
 */
public class Demo10ProducerAndConsumer {
    public static void main(String[] args) {
        Object lock =  new Object();
        int size = 2;
        Thread[] producers = new Thread[size];
        Thread[] consumers = new Thread[size];
        String str =null;
        for (int i = 0; i < size; i++) {
            producers[i] = new Demo10ProducerThread(lock);
            producers[i].setName("生产者"+(i+1));

            consumers[i] = new Demo10ConsumerThread(lock);
            consumers[i].setName("消费者"+(i+1));

            producers[i].start();
            consumers[i].start();


        }

    }
}

class Demo10ProducerAndConsumerV0{
    public static String value="";
}

class  Demo10ProducerThread extends Thread{
    private Object lock;

    public Demo10ProducerThread(Object lock) {
        this.lock = lock;
    }

    public void run(){
        try {
            synchronized(lock){
                while (true){
                    if (!"".equals(Demo10ProducerAndConsumerV0.value)){
                        System.out.println(Thread.currentThread().getName()+"等待中...");
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName()+"生产中...");
                    String value = System.currentTimeMillis()+"_"+System.nanoTime();
                    Demo10ProducerAndConsumerV0.value = value;
                    lock.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class  Demo10ConsumerThread extends Thread{
    private Object lock;

    public Demo10ConsumerThread(Object lock) {
        this.lock = lock;
    }

    public void run(){
        try {
            synchronized(lock){
                while (true){
                    if ("".equals(Demo10ProducerAndConsumerV0.value)){
                        System.out.println(Thread.currentThread().getName()+"等待中...");
                        lock.wait();
                    }
                    System.out.println(Thread.currentThread().getName()+"消费中...");
                    Demo10ProducerAndConsumerV0.value = "";
                    lock.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}