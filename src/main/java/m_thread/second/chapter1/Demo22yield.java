package m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/9/6 10:19
 * @description
 */
public class Demo22yield {
    public static void main(String[] args) {
        Thread t = new Demo22yieldThread();
        t.start();

    }
}

class Demo22yieldThread extends Thread{
    public void run(){
        int count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Thread.yield();//让此线程占用cpu资源少点。
            count += i+1;
        }
        long end = System.currentTimeMillis();
        System.out.println("用时："+(end-start)+" 毫秒");

    }
}