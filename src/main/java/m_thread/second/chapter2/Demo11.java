package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/7 15:09
 * @description
 * 25.线程的同步机制-synchronized同步语句-使用同步代码块解决同步方法的弊端
 *
 */
public class Demo11 {
    public static void main(String[] args) throws InterruptedException {
        Demo11Service service = new Demo11Service();
        Thread t1 = new Demo11ThreadA(service);
        t1.setName("A");
        Thread t2 = new Demo11ThreadB(service);
        t2.setName("B");

        t1.start();
        t2.start();

        //7秒后，对两个方法的执行时间计算。
        Thread.sleep(7000);
        long start = Demo11Utils.start1 > Demo11Utils.start2 ? Demo11Utils.start2 : Demo11Utils.start1;
        long end = Demo11Utils.end1 > Demo11Utils.end2 ? Demo11Utils.end1 : Demo11Utils.end2;
        System.out.println("总耗时："+(end-start)/1000+"秒");

    }
}

class Demo11Utils{
    static long start1;
    static long start2;
    static long end1;
    static long end2;
}

class Demo11Service{
     public void foo(){
        try {
            System.out.println("开始任务"+Thread.currentThread().getName());
            Thread.sleep(3000);
            synchronized (this){
                System.out.println("处理计算结果"+Thread.currentThread().getName());
            }

            System.out.println("结束任务"+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo11ThreadA extends Thread{
    public Demo11Service service;

    public Demo11ThreadA(Demo11Service service) {
        this.service = service;
    }
    public void run(){
        Demo11Utils.start1 = System.currentTimeMillis();
        service.foo();
        Demo11Utils.end1 = System.currentTimeMillis();
    }
}

class Demo11ThreadB extends Thread{
    public Demo11Service service;

    public Demo11ThreadB(Demo11Service service) {
        this.service = service;
    }
    public void run(){
        Demo11Utils.start2 = System.currentTimeMillis();
        service.foo();
        Demo11Utils.end2 = System.currentTimeMillis();
    }
}