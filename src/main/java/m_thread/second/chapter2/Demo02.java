package m_thread.second.chapter2;


/**
 * @author l
 * @date 2021/9/6 16:52
 * @description
 *
 * 成员变量不是线程安全的。需要加synchronized锁来保证线程的安全。
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        Demo02Service ds = new Demo02Service();
        Thread t = new Demo02ThreadA(ds);
        Thread t2 = new Demo02ThreadB(ds);
        t.start();
        t2.start();
    }
}

class Demo02Service{
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

class Demo02ThreadA extends Thread{
    private Demo02Service service;
    public Demo02ThreadA(Demo02Service service) {
        this.service = service;
    }

    public void run(){
        service.add("a");
    }
}

class Demo02ThreadB extends Thread{
    private Demo02Service service;
    public Demo02ThreadB(Demo02Service service) {
        this.service = service;
    }

    public void run(){
        service.add("b");
    }
}
