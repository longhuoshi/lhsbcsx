package m_thread.third.jucbase.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author l
 * @date 2021/10/15 15:43
 * @description
 *
 * 14-JUC高并发编程-集合线程安全-异常演示
 * list集合线程不安全
 *拋异常 ConcurrentModificationException
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();  //拋异常 ConcurrentModificationException

//        List<String> list = new Vector<>(); // 比较古老的解决方案
//        List<String> list = Collections.synchronizedList(new ArrayList<>()); // 比较古老的解决方案

        //写时复制技术。就是写的时候，copy一份新的数据，在新的上面修改。
        List<String> list = new CopyOnWriteArrayList<>();//推荐

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

        //HashSet 线程不安全(不重复，无序 )
        //CopyOnWriteArraySet 线程安全

        //HashMap 线程不安全
        //ConcurrentHashMap 线程安全


    }
}
