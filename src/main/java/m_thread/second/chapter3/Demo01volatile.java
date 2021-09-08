package m_thread.second.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2021/9/8 11:18
 * @description
 * 36.线程间的通信-wait与notify-不使用wait与notifty实现线程间通讯有什么问题
 */
public class Demo01volatile {
    public static void main(String[] args) {
        List list = new ArrayList();
        Thread t1 = new Demo01volatileThreadA(list);
        t1.start();
        Thread t2 = new Demo01volatileThreadB(list);
        t2.start();

    }
}

class Demo01volatileThreadA extends Thread{
    private List list;
    public Demo01volatileThreadA(List list) {
        this.list = list;
    }
    public void run(){
        try {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("添加了"+(i+1)+"个元素");

                Thread.sleep(600);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Demo01volatileThreadB extends Thread{
    //强制线程从公共堆栈中获取数据。
    volatile private List list;
    public Demo01volatileThreadB(List list) {
        this.list = list;
    }
    public void run(){
        try {
            while (true){
                if (list.size()==5){
                    System.out.println("List已经有5个数据了，线程B要退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


