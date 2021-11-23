package m_thread.third.jucadvance.cas;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author l
 * @date 2021/11/22 10:39
 * @description
 * 34_CAS底层原理和UnSafe的理解
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,308)+"\t"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,3333)+"\t"+atomicInteger.get());
        atomicInteger.getAndIncrement();
    }
}
