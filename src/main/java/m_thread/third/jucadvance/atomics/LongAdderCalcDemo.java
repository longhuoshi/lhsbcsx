package m_thread.third.jucadvance.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author l
 * @date 2021/12/2 10:59
 * @description
 * 50个线程，每个线程100W次，总点赞数出来 。
 * 5种不同的方式 收集点赞数。
 */

class ClickNumber{
    int number = 0;
    public synchronized void add_synchronized(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void add_atomicInteger(){
        atomicInteger.incrementAndGet();
    }

    AtomicLong atomicLong = new AtomicLong();
    public void add_atomicLong(){
        atomicLong.incrementAndGet();
    }


    LongAdder longAdder = new LongAdder();
    public void add_longAdder(){
        longAdder.increment();
    }

    LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);
    public void add_longAccumulator(){
        longAccumulator.accumulate(1);
    }
}

public class LongAdderCalcDemo {
    public static final int SIZE_THREAD = 50;
    public static final int _1W = 10000;

    public static void main(String[] args) throws InterruptedException {
        ClickNumber clickNumber = new ClickNumber();
        long startTime;
        long endTime;

        CountDownLatch countDownLatch1 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch2 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch3 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch4 = new CountDownLatch(SIZE_THREAD);
        CountDownLatch countDownLatch5 = new CountDownLatch(SIZE_THREAD);

        //=======================
        startTime = System.currentTimeMillis();
        for (int j = 0; j < SIZE_THREAD; j++) {
            new Thread(()->{
                try{
                    for (int i = 0; i < 100 * _1W ; i++) {
                        clickNumber.add_synchronized();
                    }
                }finally {
                    countDownLatch1.countDown();
                }
            },String.valueOf(j)).start();
        }
        countDownLatch1.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime)+" 毫秒---add_synchronized---"+clickNumber.number);

        startTime = System.currentTimeMillis();
        for (int j = 0; j < SIZE_THREAD; j++) {
            new Thread(()->{
                try{
                    for (int i = 0; i < 100 * _1W ; i++) {
                        clickNumber.add_atomicInteger();
                    }
                }finally {
                    countDownLatch2.countDown();
                }
            },String.valueOf(j)).start();
        }
        countDownLatch2.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime)+" 毫秒---add_atomicInteger---"+clickNumber.atomicInteger.get());

        startTime = System.currentTimeMillis();
        for (int j = 0; j < SIZE_THREAD; j++) {
            new Thread(()->{
                try{
                    for (int i = 0; i < 100 * _1W ; i++) {
                        clickNumber.add_atomicLong();
                    }
                }finally {
                    countDownLatch3.countDown();
                }
            },String.valueOf(j)).start();
        }
        countDownLatch3.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime)+" 毫秒---add_atomicLong---"+clickNumber.atomicLong.get());

        startTime = System.currentTimeMillis();
        for (int j = 0; j < SIZE_THREAD; j++) {
            new Thread(()->{
                try{
                    for (int i = 0; i < 100 * _1W ; i++) {
                        clickNumber.add_longAdder();
                    }
                }finally {
                    countDownLatch4.countDown();
                }
            },String.valueOf(j)).start();
        }
        countDownLatch4.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime)+" 毫秒---add_longAdder---"+clickNumber.longAdder.longValue());

        startTime = System.currentTimeMillis();
        for (int j = 0; j < SIZE_THREAD; j++) {
            new Thread(()->{
                try{
                    for (int i = 0; i < 100 * _1W ; i++) {
                        clickNumber.add_longAccumulator();
                    }
                }finally {
                    countDownLatch5.countDown();
                }
            },String.valueOf(j)).start();
        }
        countDownLatch5.await();
        endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime)+" 毫秒---add_longAccumulator---"+clickNumber.longAccumulator.longValue());
    }
}
