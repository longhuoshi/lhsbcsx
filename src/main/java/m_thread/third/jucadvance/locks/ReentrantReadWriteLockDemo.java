package m_thread.third.jucadvance.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 * @date 2021/12/22 17:23
 * @description
 */

class MyResource{
    Map<String,String> map = new HashMap<>();
    //----ReentrantLock 等价于  synchronized
    Lock lock = new ReentrantLock();
    //----ReentrantReadWriteLock  一体两面，读写互斥，读读共享
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    //---------- ReentrantLock 读写  -----------------
    public void write(String key,String value){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"----正在写入");
            map.put(key,value);
            //模拟业务耗时
            try { TimeUnit.MILLISECONDS.sleep(380); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"----完成写入");
        } finally {
            lock.unlock();
        }
    }

    public void read(String key){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----正在读取");
            String s = map.get(key);
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"----完成读取result:"+s);
        }finally {
            lock.unlock();
        }
    }


    //---------- ReentrantReadWriteLock 读写  -----------------
    public void writeWithRw(String key,String value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"----正在写入");
            map.put(key,value);
            //模拟业务耗时
            try { TimeUnit.MILLISECONDS.sleep(380); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"----完成写入");
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void readWithRw(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"----正在读取");
            String s = map.get(key);
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"----完成读取result:"+s);
        }finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 1; i <=10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.write(finalI+"",finalI+"");
//                myResource.writeWithRw(finalI+"",finalI+"");
            },String.valueOf(i)).start();
        }


        for (int i = 1; i <=10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.read(finalI+"");
//                myResource.readWithRw(finalI+"");
            },String.valueOf(i)).start();
        }

    }
}
