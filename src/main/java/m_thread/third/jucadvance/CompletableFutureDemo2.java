package m_thread.third.jucadvance;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/10/25 16:25
 * @description
 *
 * getNow
 * complete
 *
 */
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

//        System.out.println(completableFuture.get());
//        System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));

//        System.out.println(completableFuture.getNow(999));
        TimeUnit.SECONDS.sleep(2);
        System.out.println(completableFuture.complete(-33)+"\t"+completableFuture.get());
        //如果任务执行完成  complete(-33)返回false(打断失败)，get返回的是任务的值
        //如果任务未执行完成  complete(-33)返回true(打断成功)，get返回的是complete设置的值



        threadPoolExecutor.shutdown();
    }

}
