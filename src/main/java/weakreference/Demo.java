package main.java.weakreference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

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
 *      在内存不够时引用对象会被GC；
 *  *3、WeakReference
 *  *   每次GC都会被回收；
 *  *4、PhantomReference
 *  *   每次GC都会被回收；
 *
 *  * PhantomReference必须要和ReferenceQueue联合使用，
 *  * SoftReference和WeakReference可以选择和ReferenceQueue联合使用也可以不选择，这使他们的区别之一。
 *
 *
 */
class Car{
    String name = "亚州龙";
    public String toString(){
        return name;
    }
}
public class Demo {
    public static void main(String[] args) {


//        typeString();
        typeObj();

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
