package m_thread.third.jucadvance.atomics;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author l
 * @date 2021/11/29 14:19
 * @description
 *
 * 思想 ：锁住一个对象的属性
 *
 */
class BankAccount{
    String bankName = "ccb";
    //以一种线程安全的方式操作 非线程安全对象内的某些字段。
    //1、更新的对象属性必须 使用public volatile修饰
    public volatile int money = 0;

    //2、因为对象的属性修改类型原子类都是抽象类，所以每次使用都必须使用
    // 静态方法newUpdater()创建一个更新器，并且需要设置想要更新的类和属性。
    AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(BankAccount.class,"money");
    public void transfer(BankAccount bankAccount){
        fieldUpdater.incrementAndGet(bankAccount);

        /*//更新自定义数据
        while (!fieldUpdater.compareAndSet(bankAccount,bankAccount.money,bankAccount.money+3)){
        }*/

    }

}

public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(size);
        BankAccount bankAccount = new BankAccount();
        for (int i = 0; i <size ; i++) {
            new Thread(()->{
                bankAccount.transfer(bankAccount);
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"-----bankAccount:"+bankAccount.money);
    }
}
