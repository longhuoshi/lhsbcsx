package m_thread.third.jucadvance.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * @author l
 * @date 2021/12/23 17:28
 * @description
 */
public class StampedLockDemo {
    static int number = 37;
    static StampedLock stampedLock = new StampedLock();


    public void write(){
        long stamp = stampedLock.writeLock();
        System.out.println(Thread.currentThread().getName()+"---写线程准备修改");
        try {
            number = number + 13;
        }finally {
            stampedLock.unlockWrite(stamp);
        }
        System.out.println(Thread.currentThread().getName()+"---写线程结束修改");

    }
    //悲观读
    public void read(){
        long stamp = stampedLock.readLock();
        System.out.println(Thread.currentThread().getName()+" come in read lock block,4 seconds continue...");

        //暂停4秒
        System.out.println("4秒前stampedLock.validate值(true无修改，false有修改)---"+stampedLock.validate(stamp));
        for (int i = 1; i <= 4 ; i++) {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"---正在读取中...");
        }
        try {
            int result = number;
            System.out.println(Thread.currentThread().getName()+"---获得成员变量值 result:"+result);
            System.out.println("写线程没有修改值 ，因为stampedLock.readLock()读的时候，不可以写，读写互斥");
        }finally{
            stampedLock.unlockRead(stamp);
        }

    }
    //乐观读
    public void tryOptimisticRead(){
        long stamp = stampedLock.tryOptimisticRead();
        //先把数据获得一次
        int result = number;
        //间隔4秒，我们很乐观的认为没有其他线程修改number值 。
        System.out.println("4秒前stampedLock.validate值(true无修改，false有修改)---"+stampedLock.validate(stamp));
        for (int i = 1; i <= 4 ; i++) {
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+"---正在读取中..."+i+"秒后stampedLock.validate值："+stampedLock.validate(stamp));
        }
        if (!stampedLock.validate(stamp)){
            System.out.println("有人动过----存在写操作！");
            //有人动过了，需要从乐观读切换到普通读的模式。
            stamp = stampedLock.readLock();
            try {
                System.out.println("从乐观读升级为悲观读，并重新获取数据");
                result = number;
                System.out.println("悲观读重新获取到的值 result:"+result);
            }finally{
                stampedLock.unlockRead(stamp);
            }
        }
        System.out.println(Thread.currentThread().getName()+"\t finally value:"+ result);
    }

    public static void main(String[] args) {
        StampedLockDemo resource = new StampedLockDemo();
//        1、悲观读，和ReentrantReadWriteLock一样
        new Thread(()->{
           resource.read();
        },"readThread").start();

        //2、乐观读成功
/*
        new Thread(()->{
            resource.tryOptimisticRead();
        },"readThread").start();
        //5秒后，写线程才启动。5秒内不会有写线程抢锁，读为乐观读
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
*/

        //3、乐观读失败，重新转为悲观读，重读数据一次。
/*
        new Thread(()->{
            resource.tryOptimisticRead();
        },"readThread").start();
        //2秒后写线程抢锁，乐观读变为悲观读。
        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
*/


        //启动写线程
        new Thread(()->{
            resource.write();
        },"writeThread").start();


    }
}
