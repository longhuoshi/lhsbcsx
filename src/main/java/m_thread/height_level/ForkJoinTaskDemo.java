package m_thread.height_level;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author l
 * @date 2021/5/12 17:03
 * @description
 *
 * 7.2 什么是Fork/Join框架
 *需求是：1+2+3+4地结果
 * 使用Fork/Join框架首先考虑到的是如何分割任务。如果我们希望每个子任务最多 执行两个数的相加,
 * 那么我们设置分割的阈值是2,由于是4个数字相加，所以Fork/Join框架会把这个任务fork成两个任务，
 * 子任务一负责计算1+2,子任务二负责计算3+4，然后再join两个子任务的结果 。
 *
 * 9.2 ForkJoin如何监控
 *
 */
public class ForkJoinTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,10);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(String.format("Fork/Join Pool：terminated:%s \n",forkJoinPool.isTerminated()));

        System.out.println("最终的结果 ："+result.get());
        showLog(forkJoinPool);
        System.out.println("Thread Main End!");




    }

    private static void showLog(ForkJoinPool join) {
        System.out.println("*******************************\n");
        System.out.printf("Fork/Join Pool Parallelism:%d\n",join.getParallelism());
        System.out.printf("Fork/Join Pool PoolSize:%d\n",join.getPoolSize());
        System.out.printf("Fork/Join Pool ActiveThreadCount:%d\n",join.getActiveThreadCount());
        System.out.printf("Fork/Join Pool RunningThreadCount:%d\n",join.getRunningThreadCount());
        System.out.printf("Fork/Join Pool QueuedSubmissionCount:%d\n",join.getQueuedSubmissionCount());
        System.out.printf("Fork/Join Pool QueuedTaskCount:%d\n",join.getQueuedTaskCount());
        System.out.printf("Fork/Join Pool hasQueuedSubmissions:%s\n",join.hasQueuedSubmissions());
        System.out.printf("Fork/Join Pool StealCount:%d\n",join.getStealCount());
        System.out.printf("Fork/Join Pool hasQueuedSubmissions:%s\n",join.isTerminated());
        System.out.println("*******************************\n");

    }


}

class CountTask extends RecursiveTask<Integer>{
    private static final long serialVersionUID = 33354345605690572L;
    private static int splitSize = 2;
    private int start,end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //如果任务已经不需要再拆分了就开始计算
        boolean canCompute = (end - start) <= splitSize;
        if (canCompute){
            //计算
            for (int i = start; i <= end; i++) {
                sum = sum + i;
            }
        }else {
            //拆分成 两个子任务
            int middle = (start + end)/2;
            CountTask firstTask = new CountTask(start,middle);
            CountTask secondTask = new CountTask(middle+1,end);
            firstTask.fork();//开始执行
            secondTask.fork();
            //获得第一个子任务的结果，得不到结果，此线程不会往下面执行。
            int firstResult = firstTask.join();
            int secondResult = secondTask.join();
            //合并两个儿子的执行结果 。
            sum = firstResult + secondResult;

        }
        return sum;
    }
}