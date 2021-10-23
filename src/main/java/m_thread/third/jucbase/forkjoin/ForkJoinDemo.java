package m_thread.third.jucbase.forkjoin;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/10/21 11:12
 * @description
 *
 * 两个数差如果 大于10就从中间拆分，一直拆分到小于或等于10. 然后把拆分的数一起相加 。
 *
 */
class MyTask extends RecursiveTask<Integer>{

    //拆分时，不能大于10
    private static final Integer VALUE=10;
    private int begin;//拆分开始值
    private int end;//拆分结束值
    private int result;//返回结果。

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        //小于常量值 计算
        if ((end-begin) <= VALUE){
            //相加
            for (int i = begin; i <= end ; i++) {
                result = result + i;
            }
        }else {//拆分
            //计算中间值
            int middle = (begin+end)/2;
            //拆分左边
            MyTask task01 = new MyTask(begin,middle);
            //拆分右边
            MyTask task02 = new MyTask(middle+1,end);
            //调用方法拆分
            task01.fork();
            task02.fork();
            //合并结果
            result = task01.join()+task02.join();


        }
        return result;
    }
}

public class ForkJoinDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建task对象
        MyTask task = new MyTask(5,10);
        //创建分支合并对象池
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);
        //获取最终合并之后的结果 。
        Integer result = forkJoinTask.get();
        System.out.println(result);


    }
}
