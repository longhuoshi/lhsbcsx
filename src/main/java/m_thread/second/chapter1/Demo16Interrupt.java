package m_thread.second.chapter1;

/**
 * @author l
 * @date 2021/9/2 11:49
 * @description
 *利用interrupt停止线程
 */
public class Demo16Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Demo16InterruptThread();
        t.start();
        Thread.sleep(11);
        t.interrupt();

    }
}

class Demo16InterruptThread extends Thread{
    public void run(){
        try {
            for (int i = 0; i <10000 ; i++) {
                if (this.isInterrupted()){
                    System.out.println("已经是停止状态了，我要退出。");
                    break;
                    //也可直接抛出中断异常。
//                    throw new InterruptedException();
                }

                System.out.println("i="+i);
            }
            System.out.println("这里是结束循环后的代码。");

        } catch (Exception e) {//InterruptedException
            e.printStackTrace();
        }
    }
}

