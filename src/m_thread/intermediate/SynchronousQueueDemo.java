package m_thread.intermediate;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

/**
 * @author l
 * @date 2021/4/30 17:29
 * @description
 * 5.6 同步队列  SynchronousQueue
 *
 * 就好像生产者在不断地产生数据 ，水费者在不断消费数据 。
 *
 *
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        System.out.println("begin:"+ (System.currentTimeMillis() / 1000));
        //定义一个Syychronous
        final SynchronousQueue<String> sq = new SynchronousQueue<String>();
        //定义一个数量为1的信号量，其作用相当于一个互拆锁。
        final Semaphore sem = new Semaphore(1);
        for (int i = 0; i < 10 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sem.acquire();
                        String input = sq.take();
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName()+":"+output);
                        sem.release();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            String input = i+"";
            try {
                sq.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}

class TestDo{
    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input+":"+ (System.currentTimeMillis() /1000);
        return output;
    }
}
