package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectConstructorDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        /**
         *演示如何根据给定名称获取到指定的Class象后建立该类的对象呢？
         *
         * */

        getObject();
        getObject2();

    }

    private static void getObject2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String className = "myjava.reflect.domain.Person";
        Class myClass = Class.forName(className);
        /**
         * 怎么实例 一个有参数 的类
         * 可以先获取指定的构造函数。在通过该构造函数进行实例化。
         *
         * */

        //1、通过Class 获取指定的构造函数。比如带两个参数。
        Constructor constructor = myClass.getConstructor(String.class,int.class);
        //2、通过指定 的构造器对象进行对象的初始化。
        Object obj = constructor.newInstance("杨幂",88);






    }

    private static void getObject() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //根据指定的类名获取class对象
        String className = "myjava.reflect.domain.Person";
        Class c  = Class.forName(className);
        Object obj = c.newInstance();//创建一个Person对象。默认调用该类的空参数构造函数。
        //java.lang.InstantiationException 没有调用到与之对应的构造函数。
        //记住了，一般被反射的类通常都有空参数的构造函数。

    }
}
