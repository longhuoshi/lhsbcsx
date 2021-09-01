package m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/8/31 10:58
 * @description
 * isAlive
 * 判断当前的线程是否处于活动的状态
 *
 */
public class Demo09isAlive {
    public static void main(String[] args) {
        Thread t = new Demo09isAlive_1();
        System.out.println("准备开始启动线程，状态："+t.isAlive());
        t.start();
        System.out.println("启动线程后，状态："+t.isAlive());

    }
}

class Demo09isAlive_1 extends Thread{
    public Demo09isAlive_1(){

        System.out.println("构造方法开始 ");
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(this.isAlive());
        System.out.println("构造方法结束 ");
    }
    public void run(){
        System.out.println("run方法开始 ");
        System.out.println(Thread.currentThread().isAlive());
        System.out.println("run方法运行状态："+this.isAlive());
        System.out.println("run方法结束 ");

    }
}
