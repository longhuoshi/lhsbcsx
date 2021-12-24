package m_thread.third.jucadvance.atomics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author l
 * @date 2021/11/29 15:00
 * @description
 */
class MyVar{
    public volatile Boolean isInit = Boolean.FALSE;
    AtomicReferenceFieldUpdater<MyVar,Boolean> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(MyVar.class,Boolean.class,"isInit");

    public void init(MyVar myVar){
        if (fieldUpdater.compareAndSet(myVar,Boolean.FALSE,Boolean.TRUE)){
            System.out.println(Thread.currentThread().getName()+"----start init");
            try {
                TimeUnit.MILLISECONDS.sleep(1200);
            } catch (InterruptedException e) {   e.printStackTrace();}
            System.out.println(Thread.currentThread().getName()+"----end init");
        }else {
            System.out.println(Thread.currentThread().getName()+"----抢锁失败，数据正在被其它线程修改！");
        }
    }
}

/**
 * 多线程并发调用 一个类的初始化方法，如果未被初始化过，将执行初始化工作 ，要求只能初始化一次。
 * */
public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyVar myVar = new MyVar();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                myVar.init(myVar);
            },String.valueOf(i)).start();
        }
    }
}
