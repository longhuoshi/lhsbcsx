package main.java.m_thread.basic;

/**
 * @author l
 * @date 2021/4/23 11:10
 * @description
 *
 * 2.7、线程副本：ThreadLocal
 */
public class ThreadLocalDemo {
    //1、通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值。
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){

        protected Integer initialValue() {
            return 0;
        }
    };
    public ThreadLocal<Integer> getThreadLocal(){
        return seqNum;
    }

    //2、获取下一个序列值。
    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return  seqNum.get();
    }

    public static void main(String[] args) {
//        new ExceptionHandlerThread();

        ThreadLocalDemo sn = new ThreadLocalDemo();
        //3、3个线程共享sn,各自产生序列号。
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        //设置捕获UncaughtException异常类(类似事件注册机制 | 观察者模式 )
        ExceptionHandlerThread handlerThread = new ExceptionHandlerThread();
        t1.setUncaughtExceptionHandler(handlerThread);
        t2.setUncaughtExceptionHandler(handlerThread);
        t3.setUncaughtExceptionHandler(handlerThread);

        t1.start();
        t2.start();
        t3.start();



    }

    static class TestClient extends Thread{
        private ThreadLocalDemo sn ;
        public TestClient(ThreadLocalDemo sn){
            this.sn = sn;
        }

        public void run() {
            String[] strArr = new String[1];
            for (int i = 0; i < 3; i++) {
                //4、每个线程打出3个序列值
                System.out.println("thread["+Thread.currentThread().getName()+"] --> sn["+sn.getNextNum()+"]");
//                strArr[i]="a"; //故意制造异常。
            }
            //每个线程用完的时候要删除。
            sn.getThreadLocal().remove();
        }
    }


}
