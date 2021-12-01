package m_thread.third.jucadvance.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author l
 * @date 2021/11/24 16:42
 * @description
 *
 * 基本类型原子类和CountDownLatch使用。
 */

class MyNumber{
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addPlusPlus(){
        atomicInteger.incrementAndGet();
    }
}

public class AtomicIntegerDemo {
    public static final int SIZE_ = 50;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(SIZE_);
        MyNumber myNumber = new MyNumber();

        for (int i = 0; i < SIZE_; i++) {
            new Thread(()->{
                try {
                    for (int j = 0; j < 1000; j++) {
                        myNumber.addPlusPlus();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            },String.valueOf(i)).start();
        }

        //等待上面所有线程执行完成
//        try { TimeUnit.MILLISECONDS.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"----result:"+myNumber.atomicInteger.get());
    }
}
