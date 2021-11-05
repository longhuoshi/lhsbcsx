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
public class CompletableFutureAPIDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println(CompletableFuture.supplyAsync(() -> {
            return 2;
        }).thenCompose(r -> CompletableFuture.supplyAsync(() -> r + "to string")).join());

        //对计算结果进行合并
        System.out.println(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----1");
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----2");
            return 20;
        }), (r1, r2) -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----3");
            return r1 + r2;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----4");
            return 5;
        }), (r1, r2) -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----5");
            return r1 + r2;
        }).join());

        //结果是124步是同时执行。124步完成后，然后是第3步获取结果 ，然后再第5步获取结果。
    }

    /**
     * 对计算速度进行选用。
     * */
    private static void m4() throws InterruptedException {


        System.out.println(CompletableFuture.supplyAsync(() -> {
            //任务1
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("----1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        }).applyToEither(CompletableFuture.supplyAsync(() -> {
            //任务2
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("----2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        }), result -> {
            //谁快用谁的结果 。
            return result;
        }).join());
        TimeUnit.SECONDS.sleep(3);
    }

    /**
     * 对任务的结果进行消费处理，无返回结果 。
     * */
    private static void m3() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture.supplyAsync(()->{
            return 1;
        },threadPoolExecutor).thenApply((f)->{
            return f+2;
        }).thenApply((f)->{
            return f+3;
        }).thenAccept(result -> System.out.println(result));
        threadPoolExecutor.shutdown();


        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenRun(()->{}).join());   //thenRun 无输入，无返回
        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenAccept( resultA -> {}).join());  //有输入，无返回
        System.out.println(CompletableFuture.supplyAsync(()->"resultA").thenApply( resultA -> resultA+" resultB").join()); //有输入，有返回
    }

    /**
     * 对计算结果进行处理。
     * */
    private static void m2() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,2L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        System.out.println(CompletableFuture.supplyAsync(()->{
            return 1;
        },threadPoolExecutor).handle((f,e)->{
            System.out.println("----1");
            int i= 10/0;
            return f+2;
        }).handle((f,e)->{
            System.out.println("----2");
            return f+3;
        }).handle((f,e)->{
            System.out.println("----3");
            return f+4;
        }).whenComplete((v,e) -> {
            //最后计算完成 ，获取结果
            if (e==null)
                System.out.println("----result:"+v);
        }).exceptionally(e->{
            //有异常，就抛出异常
            e.printStackTrace();
            return null;
        }).join());

        threadPoolExecutor.shutdown();
    }

    /**
     * 获取结果 和触发计算。
     * */
    private static void m1() throws InterruptedException, ExecutionException {
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
