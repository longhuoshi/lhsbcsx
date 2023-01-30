package m_thread.third.jucadvance;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/10/25 16:25
 * @description
 *
 * CompletableFuture<Void> runAsync(Runnable runnable)
 * CompletableFuture<Void> runAsync(Runnable runnable,Executor executor)
 *
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m1();
    }


    private static void m2()  throws ExecutionException, InterruptedException{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //异步编排，多线程异步调用 。
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        },threadPoolExecutor).thenApply((result) -> { //(result)当一个参数 的时候 可以不要括号 ，直接写成result
            System.out.println("----thenApply result+2");
            //result上一步的计算结果
            return result+2;
        }).whenComplete((v,e)->{
            if (e==null){
                System.out.println("----result:"+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            return null;
        });

        System.out.println("------main over");
        //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭；
        TimeUnit.SECONDS.sleep(3);

        threadPoolExecutor.shutdown();

    }


    private static void m1() throws InterruptedException, ExecutionException {
        //-----没有返回值的-----
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t----come in");
        });//如果没有指定Executor线程池，默认用ForkJoinPool.commonPool()执行异步代码 。
        System.out.println(future1.get());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t----come in");
        },threadPoolExecutor);
        System.out.println(future2.get());

        //-----有返回值 的-----
        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----come in");

            return 1024;
        });
        System.out.println(future3.get());

        CompletableFuture<Integer> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t----come in");

            return 1024;
        },threadPoolExecutor);
        System.out.println(future4.get());

        threadPoolExecutor.shutdown();
    }
}
