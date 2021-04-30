package m_thread.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author l
 * @date 2021/4/22 11:41
 * @description
 *
 * Thread的二种实现方法
 */
public class ThreeRealizeFuture {
    public static void main(String[] args) {

        //third 实现 implements Callable , 实现call()方法可以得到线程的执行结果 。
        ThreadC c = new ThreadC();
        FutureTask<String> futureTask = new FutureTask<>(c);
        new Thread(futureTask).start();

        System.out.println("这是主线程!");

        try {
            //返回结果 是堵塞的。要等线程执行完，才返回
            System.out.println("线程返回值："+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }



    }




}


//third
class ThreadC implements Callable<String> {

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     *
     * 有返回结果的线程
     */
    @Override
    public String call() throws Exception {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("这是线程C");
        return "thread B";

    }
}


