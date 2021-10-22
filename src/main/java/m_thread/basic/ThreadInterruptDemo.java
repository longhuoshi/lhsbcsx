package m_thread.basic;

/**
 * @author l
 * @date 2021/4/22 17:03
 * @description
 *
 *关于线程的中断机制
 */
public class ThreadInterruptDemo implements Runnable{
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new ThreadInterruptDemo(),"InterruptDemo Thread");
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(2000);
        System.out.println("线程是否中断："+thread.isInterrupted());
        System.out.println("interrupting thread...");
        thread.interrupt();
        System.out.println("线程是否中断："+thread.isInterrupted());
        Thread.sleep(2000);
        System.out.println("Stopping application...");


    }

    public void run() {
        boolean stop = false;
        while (!stop){
            System.out.println("My Thread is running...");
            long time = System.currentTimeMillis();
            while (System.currentTimeMillis()-time < 1000){
                //让该循环持续一段时间，使用上面的话打印次数 少点。

            }

            if (Thread.currentThread().isInterrupted()){
                //需要线程本身去处理下它的终止状态
                break;
            }

        }
        System.out.println("My Thread exiting under request...");

    }
}
