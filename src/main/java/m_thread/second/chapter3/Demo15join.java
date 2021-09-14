package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/14 9:46
 * @description
 */
public class Demo15join {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo15joinThread();
        t.start();
        t.join(); //把t子线程加到当前的(主)线程上来,要等t线程执行完成，主线程再继续执行。
        System.out.println("子线程执行完成以后再执行");

    }
}

class Demo15joinThread extends Thread{
    public void run(){
        try {
            int value = (int)(Math.random() *5000);
            System.out.println("需要等待"+value+"毫秒");
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}