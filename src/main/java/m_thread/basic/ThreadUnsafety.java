package m_thread.basic;

import javax.security.auth.login.CredentialException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author l
 * @date 2021/4/26 17:12
 * @description
 * 3.2、什么是不安全
 *假设5个用户(一个线程是一个用户)，都来给一个数字加1的工作，那么最后数字应该是5
 *
 * 结论：web项目中Service和Servlet一般都是单例共享变量的情况下（一个线程处理一个用户的请求）极其容易出现 ，
 * 多个用户之间的数据串掉了，导致最终的统计 数据 不对。
 */

//干活类
class Count{
    public int num = 0;
//    public void add(){ //不安全
    public synchronized void add(){  //加上锁，变安全了。
        try {
            Thread.sleep(51);//干活耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num +=1;

        System.out.println(Thread.currentThread().getName()+"-"+num);

    }
}

//用户类
class ThreadUser extends Thread{
    private Count count;
    public ThreadUser(Count count){
        this.count = count;
    }

    public void run() {
        count.add();
    }
}


public class ThreadUnsafety {
    private final static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        Count count = new Count();
        for (int i = 0; i < 5 ; i++) {
            ThreadUser threadUser = new ThreadUser(count);
            threadUser.start();
        }
        try {
            Thread.sleep(600); //等干完活
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5个人干完活最后的值是："+count.num);
//        Lock , ReentrantLock

    }

}
