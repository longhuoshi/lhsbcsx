package main.java.m_thread.intermediate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author l
 * @date 2021/5/12 16:27
 * @description
 *
 *7.1 认识Future任务机制和FutureTask
 *
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SonTask task1 = new SonTask("Thread  Son1");
        FutureTask<String> f1 = new FutureTask<String>(task1);
        new Thread(f1).start();

        System.out.println(f1.get());  //只有得到返回结果后才会继续往下面执行

        FutureTask<Integer> f2 = new FutureTask<Integer>(new MyRun(),22);
        //执行完指定线程，返回指定结果 。
        new Thread(f2).start();
        System.out.println("result_"+f2.get());//只有得到指定结果后才会继续往下面执行



    }
}

class SonTask implements Callable<String>{
    private String name="";
    public SonTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000L);
        System.out.println(name + "任务计算完成");
        return "result_11";
    }
}

class MyRun implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("特定线程2完成");
    }
}
