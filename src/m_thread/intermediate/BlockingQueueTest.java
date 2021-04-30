package m_thread.intermediate;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author l
 * @date 2021/4/30 16:33
 * @description
 *
 * 5.1 阻塞队列BlockingQueue
 * 5.2 数组阻塞队列ArrayBlockingQueue
 *
 * 现有的程序代码模拟产生了16个日志对象，并且需要运行16s才能打印完这些日志。
 * 请在程序 中增加4个线程去调用 parseLong()方法来分头打印这16个日志对象，
 * 程序 只需要 运行4s即可打印完这些日志对象
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        //等待队列
        final BlockingQueue<String> bq = new ArrayBlockingQueue<String>(16) ;
        //4个线程
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){

                        try {
                            String log = (String) bq.take();
                            parseLog(log);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        //添加数据到队列
        for (int i = 0; i < 16; i++) {
            String log = (i+1)+" -->  ";
            bq.put(log);
        }

    }
    public static void parseLog(String log){
        System.out.println(log+System.currentTimeMillis());
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
