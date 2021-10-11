package m_thread.basic;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/9/24 10:53
 * @description
 * 一个简单的线程池 Demo
 * ThreadPoolExecutor
 * 执行任务
 */
public class ThreadPoolExecutorDemo  {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {
        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            CORE_POOL_SIZE,MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(QUEUE_CAPACITY),
            new ThreadPoolExecutor.CallerRunsPolicy()
        );
        /**
         * corePoolSize : 核心线程数定义了最小可以同时运行的线程数量。
         * maximumPoolSize : 当队列中存放的任务达到队列容量的时候，当前可以同时运行的线程数量变为最大线程数。
         * workQueue: 当新任务来的时候会先判断当前运行的线程数量是否达到核心线程数，如果达到的话，新任务就会被存放在队列中。
         *
         * keepAliveTime:当线程池中的线程数量大于 corePoolSize 的时候，如果这时没有新的任务提交，核心线程外的线程不会立即销毁，而是会等待，直到等待的时间超过了 keepAliveTime才会被回收销毁；
         * unit : keepAliveTime 参数的时间单位。
         * threadFactory :executor 创建新线程的时候会用到。
         * handler :饱和策略。关于饱和策略下面单独介绍一下。
         * */

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new ThreadPoolExecutorDemoRunnable(""+i);
            //执行Runnable
            executor.execute(worker);

        }
        //终止线程池
        System.out.println("Begin finish threads");
        executor.shutdown();
        while (!executor.isTerminated()){
        }
        System.out.println("Finished all threads");

    }


}
