package m_thread.second.chapter1;

import java.util.LinkedList;

/**
 * @author l
 * @date 2021/9/2 11:49
 * @description
 *利用interrupt停止线程2
 * interrupt只对 执行任务的线程里有 Thread.sleep(20000); 才会终止线程并抛异常InterruptedException。
 */
public class Demo17Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo17InterruptThread();
        t.start();
        Thread.sleep(11);
        t.interrupt();


    }
}

class Demo17InterruptThread extends Thread{
    public void run(){
        try {
            for (int i = 0; i <Integer.MAX_VALUE ; i++) {
                String s = new String(); //如果 是空字符串，java会直接忽略 循环体
//                System.out.println("i="+i);
            }
            System.out.println("开始线程。");
            Thread.sleep(20000);  //只有执行到这里interrupt 才会抛异常
            System.out.println("结束线程。");

        } catch (Exception e) {//InterruptedException
            e.printStackTrace();
        }
    }
}

