package m_thread.second.chapter3;

/**
 * @author l
 * @date 2021/9/14 11:17
 * @description
 */
public class Demo19threadLocal {
    public static void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        if (tl.get() == null){ // 获取当前线程存储的数据。
            System.out.println("从未放过值");
            tl.set("a"); //保存当前线程的数据。
        }

        System.out.println(tl.get());
        System.out.println(tl.get());
    }
}
