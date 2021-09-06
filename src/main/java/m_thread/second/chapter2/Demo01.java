package m_thread.second.chapter2;


/**
 * @author l
 * @date 2021/9/6 16:52
 * @description
 *
 *修改对象的局部变量，线程是安全的。
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        Demo01Service ds = new Demo01Service();
        Thread t = new Demo01ThreadA(ds);
        Thread t2 = new Demo01ThreadB(ds);
        t.start();
        t2.start();
    }
}

class Demo01Service{
    public void add(String username){
        int num=0;
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

class Demo01ThreadA extends Thread{
    private Demo01Service service;
    public Demo01ThreadA(Demo01Service service) {
        this.service = service;
    }

    public void run(){
        service.add("a");
    }
}

class Demo01ThreadB extends Thread{
    private Demo01Service service;
    public Demo01ThreadB(Demo01Service service) {
        this.service = service;
    }

    public void run(){
        service.add("b");
    }
}
