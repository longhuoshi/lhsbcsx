package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/7 11:38
 * @description
 * 19.线程的同步机制-synchronized同步方法-锁重入
 *锁重入性，线程调用 一个加锁的方法，要进入这个锁对象的另一个方法。
 * 有继承性。
 *
 */
public class Demo06 {
    public static void main(String[] args) {
        Thread t = new Demo06Thread();
        t.start();
    }
}
class Demo06Service{
    synchronized public void foo1(){
        foo2();
        System.out.println("foo1方法");
    }

    private void foo2() {
        foo3();
        System.out.println("foo2方法");
    }

    private void foo3() {
        System.out.println("foo3方法");
    }
}
class Demo06ServiceB extends Demo06Service{
    synchronized public void foo4(){
        System.out.println("foo4方法");
        super.foo1();
    }
}

class Demo06Thread extends Thread{
    public void run(){
        //锁重入性
//        Demo06Service service = new Demo06Service();
//        service.foo1();
        //锁继承性
        Demo06ServiceB service = new Demo06ServiceB();
        service.foo4();
    }
}