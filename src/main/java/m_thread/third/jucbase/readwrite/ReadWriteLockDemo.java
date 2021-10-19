package m_thread.third.jucbase.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author l
 * @date 2021/10/19 10:40
 * @description
 * 30-JUC高并发编程-读写锁
 *
 * 正常操作是写完了，才能读。读完后， 才能继续写。
 * 读是并发读的。写只能独占。
 *
 * 乐观锁，通过内置版本号来控制，最后修改数据的安全性。
 */


public class ReadWriteLockDemo {
    public static void main(String[] args) {

//        MyCache1 myCache = new MyCache1();

        //添加了读写锁
        MyCache2 myCache = new MyCache2();

        //创建线程放数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.put(num +"",num+"");
            },String.valueOf(i)).start();
        }

        //创建线程取数据
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                myCache.get(num +"");
            },String.valueOf(i)).start();
        }
    }




}

//资源类(添加了读写锁的)
class MyCache2{
    //创建map集合
    private volatile Map<String,Object> map = new HashMap<>();

    //创建读写锁对象
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();


    //放数据
    public void put(String key,Object value){
        //添加写锁
        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+" 正在写操作"+key);
            //模拟任务耗时
//            TimeUnit.SECONDS.sleep(300);
            TimeUnit.MICROSECONDS.sleep(300);
            //放数据
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写完了"+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放写锁
            rwLock.writeLock().unlock();
        }
    }

    //取数据
    public Object get(String key){

        //添加读锁
        rwLock.readLock().lock();

        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName()+" 正在读取操作"+key);
            //模拟任务耗时
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取完了"+key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放读锁
            rwLock.readLock().unlock();
        }
        return result;
    }

}


//资源类(有问题，没写完就去读，肯定是读不到的。问题就出来 了。)
class MyCache1{
    //创建map集合
    private volatile Map<String,Object> map = new HashMap<>();
    //放数据
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+" 正在写操作"+key);
        //模拟任务耗时
        try {
//            TimeUnit.SECONDS.sleep(300);
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //放数据
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+" 写完了"+key);
    }

    //取数据
    public Object get(String key){
        Object result = null;
        System.out.println(Thread.currentThread().getName()+" 正在读取操作"+key);
        //模拟任务耗时
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = map.get(key);
        System.out.println(Thread.currentThread().getName()+" 读取完了"+key);
        return result;
    }

}
