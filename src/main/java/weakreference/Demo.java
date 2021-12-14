package weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author l
 * @date 2021/4/26 10:17
 * @description
 *https://blog.csdn.net/coderder/article/details/80433444
 *
 *Java弱引用(WeakReference)的理解与使用
 * 一个对象被回收, 必须满足两个条件: 1)没有任何(强)引用指向它 2)GC被运行.
 *
 *  * ReferenceQueue
 *  * 在weak reference指向的对象被回收后, weak reference本身其实也就没有用了.
 *  * java提供了一个ReferenceQueue来保存这些所指向的对象已经被回收的reference.
 *  * 用法是在定义WeakReference的时候将一个ReferenceQueue的对象作为参数传入构造函数.
 *  *
 *  *
 *  *Reference 的子类
 *  * 4种引用
 *  *1、StrongReference
 *          A a=new A(); 此时引用a强引用对象A；不会被GC
 *  *2、SoftReference
 *      在内存不够时引用对象会被GC；  （一般开发高速缓存的系统要用到。）
 *  *3、WeakReference
 *  *   每次GC都会被回收；
 *  *4、PhantomReference
 *  *   每次GC都会被回收；
 *
 *  * PhantomReference必须要和ReferenceQueue联合使用，
 *  * SoftReference和WeakReference可以选择和ReferenceQueue联合使用也可以不选择，这使他们的区别之一。
 *
 *
 * 软引用实际案例：
 * 假如有一个应用需要读取大量的本地图片：
 *  如果每次读取图片都从硬盘读取则会严重影响性能
 *  如果一次性全部加载到内存中又可能造成内存溢出 OOM。
 * 此时使用软引用可以解决问题。
 * 设计思路：用一个hashmMap来保存图片的路径和相应 图片对象关联的软引用 之间的映射关系 ，在内存不足时，
 * JVM会自动回收这些缓存图片对象所占用的空间，人而有效地避免了OOM问题。
 * Map<String,SoftReference<Bitmap>> imageCache = new HashMap<String,SoftReference<Bitmap>>();
 *
 * 虚引用（写java虚拟机的人用的） 的主要作用是跟踪对象 被 垃圾回收的状态。仅仅是提供了一种确保对象被finalize以后，做某些事情的机制 。
 * PhantomReference的get方法总是返回 null，因此无法访问对应的引用 对象 。
 *
 *
 *
 */
class Car{
    String name = "亚州龙";
    public String toString(){
        return name;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("----gc,finalize() invoked ! ");
    }
}
public class Demo {
    public static void main(String[] args) {


//        typeString();
//        typeObj();
        phantomReferenceDemo();
    }

    //-Xms30m -Xmx30m
    public static void phantomReferenceDemo(){
        ReferenceQueue<Car> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Car> phantomReference = new PhantomReference<>(new Car(),referenceQueue);
        System.out.println(phantomReference.get());
        List<byte[]> list = new ArrayList<>();
        //内存里添加数据，当内存不足时,虚引用所引用的对象回收后 会装到referenceQueue里
        new Thread(()->{
            while (true){
                list.add(new byte[1*1024*1024]);
                try {
                    TimeUnit.MILLISECONDS.sleep(600);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(phantomReference.get());
            }
        },"t1").start();

        //引用队列里查看虚对象
        new Thread(()->{
            while (true){
                Reference<? extends Car> poll = referenceQueue.poll();
                if (poll != null)
                    System.out.println("----有虚对象进入了队列："+poll.get());
            }
        },"t2").start();
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void typeString(){
        String str = new String("aaa");
        WeakReference<String> wr = new WeakReference<>(str);// 给对象加上弱引用
        str = null; //去掉强引用
        System.gc();
        String wrStr = wr.get(); //从弱引用里获取对象
        if (wrStr!= null){
            System.out.println(wrStr);
        }else {
            System.out.println("对象被回收了！");

        }
    }

    public static void typeObj(){
        ReferenceQueue<Car> rq = new ReferenceQueue<>(); //弱引用对象，被gc回收后会放到引用队列。

        Car car = new Car();
        WeakReference<Car> wr = new WeakReference<>(car,rq);// 给对象加上弱引用
        car = null; //去掉强引用

        System.out.println("g调用前！");
        Reference<? extends  Car> reference2 = null;
        while ((reference2 = rq.poll()) != null){
            System.out.println("2回收的对象有："+reference2.get());
        }
        System.gc();
        System.out.println("g调用后！");

        //给gc回收一点时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //通过wr获取它所指向的Car对象car呢？  答：wr.get();
        Car wrCar = wr.get(); //从弱引用里获取对象
        if (wrCar!= null){
            System.out.println(wrCar);
        }else {

            System.out.println("对象被回收了！");
            Reference<? extends  Car> reference = null;
            while ((reference = rq.poll()) != null){
                System.out.println("回收的对象有："+reference);
            }
        }
    }

}
