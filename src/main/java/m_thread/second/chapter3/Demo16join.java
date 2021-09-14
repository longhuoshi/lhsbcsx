package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/14 11:00
 * @description
 * 52.线程间的通信-join方法-join方法与异常
 */

public class Demo16join {
    public static void main(String[] args) throws InterruptedException {
        Demo16joinThreadB t = new Demo16joinThreadB();
        t.start();
        Thread.sleep(10);
        Thread t2 = new Demo16joinThreadC(t);
        t2.start();
    }
}

class Demo16joinThreadA extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            // 耗时操作
            String s = new String();
            Math.random();
        }
    }
}
class Demo16joinThreadB extends Thread{
    @Override
    public void run() {
        try {
            Thread t = new Demo16joinThreadA();
            t.start();
            t.join();
            System.out.println("B线程正常结束");
        }catch (InterruptedException e){
            System.out.println("B线程异常结束");
            e.printStackTrace();
        }
    }
}
class Demo16joinThreadC extends Thread{
    private Demo16joinThreadB t;
    public Demo16joinThreadC(Demo16joinThreadB t){
        this.t = t;
    }

    @Override
    public void run() {
        t.interrupt();
    }
}
