package m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/9/2 11:49
 * @description
 *
 * interrupt不会真正停止线程，而是在当前线程上打上一个停止标记。
 * Thread提供interrupted方法检测当前线程是否中断，isInterrupted方法测试线程是否已经中断。
 *
 */
public class Demo15Interrupt {
    public static void main(String[] args) {
        Thread t = new Demo15InterruptThread();
        t.start();
        t.interrupt();

        System.out.println("是否停止1?"+t.isInterrupted());
//        Thread.currentThread().interrupt();  //设置main的 停止 标致
        System.out.println("是否停止2?"+Thread.interrupted());
    }
}

class Demo15InterruptThread extends Thread{
    public void run(){
        for (int i = 0; i <10000 ; i++) {
            System.out.println("i="+i);
            
        }
    }
}

