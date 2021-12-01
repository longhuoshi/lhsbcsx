package m_thread.third.jucadvance.atomics;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * @author l
 * @date 2021/11/24 17:19
 * @description
 */
public class AtomicMarkableReferenceDemo {
    static AtomicMarkableReference atomicMarkableReference = new AtomicMarkableReference(100,false);

    public static void main(String[] args) {
        new Thread(()->{
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"----默认标识："+marked);
            try { TimeUnit.MILLISECONDS.sleep(1000);} catch (InterruptedException e) { e.printStackTrace(); }
            atomicMarkableReference.compareAndSet(100,101,marked,!marked);
        },"t1").start();
        new Thread(()->{
            boolean marked = atomicMarkableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"----默认标识："+marked);
            try { TimeUnit.MILLISECONDS.sleep(2000);} catch (InterruptedException e) { e.printStackTrace(); }
            boolean b = atomicMarkableReference.compareAndSet(100, 20211124, marked, !marked);
            System.out.println(Thread.currentThread().getName()+"----操作是否成功："+b+"---"+atomicMarkableReference.getReference()+"---"+atomicMarkableReference.isMarked());


        },"t2").start();


        //使用场景：双端检索
        if (!atomicMarkableReference.isMarked()){
            //业务逻辑...

            //写回主内存
            if (!atomicMarkableReference.isMarked()){
//                save() //
            }
        }



    }
}
