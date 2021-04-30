package m_thread.basic;

/**
 * @author l
 * @date 2021/4/26 16:14
 * @description
 *
 * 2.8 线程异常处理。
 * 1、try/catch块
 * 2、注册实现UncaughtExceptionHandler，并注册到Thread里。例：Thread.setUncaughtExceptionHandler(handlerThread);
 */
public class ExceptionHandlerThread implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程出异常了："+t.getName());
        e.printStackTrace();
    }
}