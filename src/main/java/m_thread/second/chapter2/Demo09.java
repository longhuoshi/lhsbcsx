package m_thread.second.chapter2;

/**
 * @author l
 * @date 2021/9/7 15:09
 * @description
 * 23.线程的同步机制-synchronized同步语句-synchronized方法的缺点
 */
public class Demo09 {
    public static void main(String[] args) throws InterruptedException {
        Demo09Service service = new Demo09Service();
        Thread t1 = new Demo09ThreadA(service);
        t1.setName("A");
        Thread t2 = new Demo09ThreadB(service);
        t2.setName("B");

        t1.start();
        t2.start();

        //7秒后，对两个方法的执行时间计算。
        Thread.sleep(7000);
        long start = Demo09Utils.start1 > Demo09Utils.start2 ? Demo09Utils.start2 : Demo09Utils.start1;
        long end = Demo09Utils.end1 > Demo09Utils.end2 ? Demo09Utils.end1 : Demo09Utils.end2;
        System.out.println("总耗时："+(end-start)/1000+"秒");

    }
}

class Demo09Utils{
    static long start1;
    static long start2;
    static long end1;
    static long end2;
}

class Demo09Service{
    synchronized public void foo(){
        try {
            System.out.println("开始任务");
            Thread.sleep(3000);
            System.out.println("长时任务处理完成，线程"+Thread.currentThread().getName());
            System.out.println("结束任务");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo09ThreadA extends Thread{
    public Demo09Service service;

    public Demo09ThreadA(Demo09Service service) {
        this.service = service;
    }
    public void run(){
        Demo09Utils.start1 = System.currentTimeMillis();
        service.foo();
        Demo09Utils.end1 = System.currentTimeMillis();
    }
}

class Demo09ThreadB extends Thread{
    public Demo09Service service;

    public Demo09ThreadB(Demo09Service service) {
        this.service = service;
    }
    public void run(){
        Demo09Utils.start2 = System.currentTimeMillis();
        service.foo();
        Demo09Utils.end2 = System.currentTimeMillis();
    }
}