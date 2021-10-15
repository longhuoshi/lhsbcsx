package m_thread.second.chapter5;

import java.util.concurrent.*;

/**
 * @author l
 * @date 2021/10/13 11:41
 * @description
 * 在jdk 1.5中引入的Callable接口是一种具有类型参数的泛型，它的类型参数表示从方法call中返回的值的类型。
 *
 */
public class Demo05Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Demo05CallableSub();
        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        Thread t1 = new Thread(task);
        t1.start();
        System.out.println("线程返回的值是："+task.get());//task.get() 会阻塞当前线程。

//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.execute();


    }
}

class Demo05CallableSub implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"调用了callable接口的实现类。");
        Thread.sleep(2000);
        return (int)(Math.random()*10);
    }
}
