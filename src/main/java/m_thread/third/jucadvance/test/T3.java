package m_thread.third.jucadvance.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author l
 * @date 2021/11/11 10:05
 * @description
 */
public class T3 {
    static ArrayList<Integer> list1 = new ArrayList();
    public static void main(String[] args) {
        m1();//----costTime:147毫秒
        m2();//----costTime:4390毫秒
    }

    private static void m2() {
        IntStream.range(0,3000000).forEach(list1::add);
        long startTime = System.currentTimeMillis();
        List<Integer> collect = list1.stream().map(m -> m * 2).collect(Collectors.toList()).stream().map(m->m*2).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime+"毫秒"));
    }
    private static void m1() {
        IntStream.range(0,3000000).forEach(list1::add);
        long startTime = System.currentTimeMillis();
        List<Integer> collect = list1.stream().map(m -> m * 2).map(m -> m * 2).collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        System.out.println("----costTime:"+(endTime-startTime+"毫秒"));
    }
}
