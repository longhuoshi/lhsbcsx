package m_thread.basic;

/**
 * @author l
 * @date 2021/4/28 15:45
 * @description
 * 3.11、单例模式的写法
 * 线程安全，性能又高的写法
 * */
public class Singleton {
    private static byte[] lock = new byte[1];
    private static Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if (instance==null){
            synchronized (lock){
                if (instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
