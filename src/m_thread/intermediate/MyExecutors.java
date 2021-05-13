package m_thread.intermediate;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/5/11 17:00
 * @description
 *6.7 自定义线程池与ExecutortorService
 *
 */
//public class MyExecutors extends Executors {
public class MyExecutors implements Executor {
//    public MyExecutors(){
//        //@Contract(pure = true)
//    }

    public static ExecutorService newMyWebThreadPool(int minSpareThreads, int maxThreads,int maxIdleTime){

        return new ThreadPoolExecutor(minSpareThreads,maxThreads,maxIdleTime, TimeUnit.MILLISECONDS,new PriorityBlockingQueue<>());
    }


    @Override
    public void execute(Runnable command) {

    }
}
