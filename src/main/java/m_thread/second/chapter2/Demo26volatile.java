package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/8 10:31
 * @description
 *
 * 35.线程的同步机制-volatile关键字
 *
 * 如果下面的代码运行在服务器模式(JDK8及以上版本默认就是使用服务器模式( Server VM)、JDK7默认使用的客户端模式)
 * 中的JVM时就会出现死循环。
 */
public class Demo26volatile {
    public static void main(String[] args) throws InterruptedException {
        Demo26volatileService service = new Demo26volatileService();
//        service.foo();
        service.start();
        Thread.sleep(100);//等待线程执行到while循环里面，这样设置falg为false,也停止不了线程。
        System.out.println(Thread.currentThread().getName()+"准备停止foo方法的循环");
        service.flag = false;

    }
}

class Demo26volatileService extends Thread{
    //标志，控制循环
    volatile public boolean flag = true;

    public void run(){
        foo();
    }

    public void foo(){
        System.out.println("foo开始运行");
        while (flag){

        }
        System.out.println("foo运行结束");
    }
}