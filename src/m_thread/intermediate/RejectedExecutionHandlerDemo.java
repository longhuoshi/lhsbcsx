package m_thread.intermediate;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author l
 * @date 2021/5/12 10:44
 * @description
 *
 *     3、 理解RejectedExecutionHandler
 *         如果线程池里的线程已经饱和，并且任务队列也已满。那就要做丢弃处理。
 *         线程池任务拒绝策略
 *         1、不用线程池线程执行
 *             CallerRunsPolicy:只用调用者所在线程来运行任务。
 *         2、抛出异常
 *             AbortPolicy:直接抛出异常
 *         3、丢弃队列中最旧任务
 *             DiscardOldestPolicy:丢弃队列里离执行最近（在队列里呆得时间最长）的一个任务，并执行当前任务。
 *         4、直接丢弃任务。
 *             DiscardPolicy:不处理，丢弃掉。
 *
 */
public class RejectedExecutionHandlerDemo implements RejectedExecutionHandler {


    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("线程信息："+r.toString()+" 被遗弃的线程池："+ executor.toString());
    }
}
