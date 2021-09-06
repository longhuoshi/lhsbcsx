package m_thread.second.chapter1;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author l
 * @date 2021/9/6 11:06
 * @description
 */
public class Demo26deamon {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo26deamonThread();
        t.setDaemon(true);//设置为守护线程。注意要在start之前设置，否则 会报IllegalThreadStateException
        t.start();
        Thread.sleep(3000);
        System.out.println("main thread is over!");
    }
}

class Demo26deamonThread extends Thread{
    public void run(){

        try {
            while (true){
                System.out.println("time="+System.currentTimeMillis());
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
