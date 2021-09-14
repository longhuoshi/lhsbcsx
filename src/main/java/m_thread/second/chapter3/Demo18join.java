package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/14 9:46
 * @description
 * 方法join(long)的功能在内部使用wait(long)来实现同步，所以joing(long)方法具有释放同步锁的特点。
 *
 */
public class Demo18join {
    public static void main(String[] args) {
        Demo18joinThreadA t1 = new Demo18joinThreadA();
        Demo18joinThreadB t2 = new Demo18joinThreadB(t1);
        t2.start();
        Demo18joinThreadC t3 = new Demo18joinThreadC(t1);
        t3.start();
    }
}
class Demo18joinThreadA extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("线程A开始于" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("线程A结束于" + System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void foo(){
        System.out.println("方法执行时间" + System.currentTimeMillis());
    }
}
class Demo18joinThreadB extends Thread{
    private Demo18joinThreadA t;
    public Demo18joinThreadB(Demo18joinThreadA t){
        this.t = t;
    }

    @Override
    public void run() {
        synchronized (t) {
            try {
                t.start();
                Thread.sleep(6000);
//                t.join();
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    String s = new String();
                    Math.random();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class Demo18joinThreadC extends Thread{
    private Demo18joinThreadA t;
    public Demo18joinThreadC(Demo18joinThreadA t){
        this.t = t;
    }

    @Override
    public void run() {
        t.foo();
    }
}