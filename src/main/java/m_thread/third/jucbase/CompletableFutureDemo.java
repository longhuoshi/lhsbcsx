package m_thread.third.jucbase;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author l
 * @date 2021/10/22 16:46
 * @description
 * 43-JUC高并发编程-异步回调
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同步调用
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+" :completableFuture1");
        });
        completableFuture1.get();

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+" :completableFuture2");
            //模拟异常
//            int i =  10/0;

           return 1024;
        });

        completableFuture2.whenComplete((t,u)->{
            System.out.println("-----t="+t); //正常返回值
            System.out.println("-----u="+u); //异常时，返回
        });


    }
}
