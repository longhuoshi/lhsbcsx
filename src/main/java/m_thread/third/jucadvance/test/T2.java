package m_thread.third.jucadvance.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author l
 * @date 2021/11/11 10:21
 * @description
 */
public class T2 {
    private static List<Integer> list1= new ArrayList();
    private static List<Integer> list2= new ArrayList();
    private static List<Integer> list3= new ArrayList();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.range(0,1000000).forEach(list1::add);
        IntStream.range(0,1000000).parallel().forEach(value -> list2.add(value));
        IntStream.range(0,1000000).parallel().forEach(i->{
            lock.lock();
            try {
                list3.add(i);
            }finally {
                lock.unlock();
            }
        });

        System.out.println("串行流执行大小："+list1.size());
        System.out.println("并行流执行大小："+list2.size());
        System.out.println("并行流加锁执行大小："+list3.size());
    }
}
