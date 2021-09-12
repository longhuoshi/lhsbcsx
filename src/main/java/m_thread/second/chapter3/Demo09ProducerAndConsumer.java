package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/10 17:11
 * @description
 *
 * 45.线程间的通信-生产者与消费者模式-一个生产者与一个消费者(操作值)
 * 如果在这个代码的基础上，设计出多生产者与多消费者，在运行过程很有可能会出现 『假死』的情况，也就是所有的线程都是WAIT状态。
 */
public class Demo09ProducerAndConsumer {
    public static void main(String[] args) {
        Object lock =  new Object();
        Thread t1 = new Demo09ProducerThread(lock);
        t1.start();
        Thread t2 = new Demo09ConsumerThread(lock);
        t2.start();

    }
}

class Demo09ProducerAndConsumerV0{
    public static String value="";
}

class  Demo09ProducerThread extends Thread{
    private Object lock;

    public Demo09ProducerThread(Object lock) {
        this.lock = lock;
    }

    public void run(){
        try {
            synchronized(lock){
                while (true){
                    if (!"".equals(Demo09ProducerAndConsumerV0.value)){
                        lock.wait();
                    }
                    String value = System.currentTimeMillis()+"_"+System.nanoTime();
                    System.out.println("Set的值是："+value);
                    Demo09ProducerAndConsumerV0.value = value;
                    lock.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class  Demo09ConsumerThread extends Thread{
    private Object lock;

    public Demo09ConsumerThread(Object lock) {
        this.lock = lock;
    }

    public void run(){
        try {
            synchronized(lock){
                while (true){
                    if ("".equals(Demo09ProducerAndConsumerV0.value)){
                        lock.wait();
                    }
                    System.out.println("Get的值是："+Demo09ProducerAndConsumerV0.value);
                    Demo09ProducerAndConsumerV0.value = "";
                    lock.notify();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}