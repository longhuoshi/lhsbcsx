package m_thread.second.chapter2;


/**
 * @author l
 * @date 2021/9/6 16:52
 * @description
 *
 * 16.线程的同步机制-synchronized同步方法-多个对象使用多个对象锁
 * synchronized取得的锁都是对象锁。多个线程访问多个对象，，JVM会创建出多个对象锁。
 *
 *
 *
 *
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo03Service ds = new Demo03Service();
        Demo03Service ds2 = new Demo03Service();

        Thread t = new Demo03ThreadA(ds);
        Thread t2 = new Demo03ThreadB(ds2);
        t.start();
        t2.start();
    }
}

class Demo03Service{
    private int num;
    synchronized public void add(String username){
        if ("a".equals(username)){
            num=100;
            System.out.println("a set over");
            //等待另外一个线程修改num。
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else {
            num = 200;
            System.out.println("b set over");
        }
        System.out.println("username="+username+",num="+num);
    }
}

class Demo03ThreadA extends Thread{
    private Demo03Service service;
    public Demo03ThreadA(Demo03Service service) {
        this.service = service;
    }

    public void run(){
        service.add("a");
    }
}

class Demo03ThreadB extends Thread{
    private Demo03Service service;
    public Demo03ThreadB(Demo03Service service) {
        this.service = service;
    }

    public void run(){
        service.add("b");
    }
}
