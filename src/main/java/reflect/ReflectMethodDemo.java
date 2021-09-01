package reflect;

import java.lang.reflect.Method;

public class ReflectMethodDemo {
    public static void main(String[] args) throws Exception{
        getMethodDemo();
        getMethodDemo2();
        getMethodDemo3();
    }

    //反射方法。非静态，有参数的paramShow方法。
    private static void getMethodDemo3() throws Exception {
        String className = "myjava.reflect.domain.Person";
        Class myClass = Class.forName(className);

        Method method = myClass.getMethod("paramShow",String.class,int.class);
        Object obj = myClass.newInstance();
        method.invoke(obj,"米依婷",18);
    }


    //反射方法。静态，无参数的staticShow方法。
    private static void getMethodDemo2() throws Exception {
        String className = "myjava.reflect.domain.Person";
        Class myClass = Class.forName(className);

        Method method = myClass.getMethod("staticShow",null);
        //静态方法不需要对象，传null
        method.invoke(null,null);

    }



    //反射方法。非静态，无参数的show方法。
    private static void getMethodDemo() throws Exception {
        String className = "myjava.reflect.domain.Person";
        Class myClass = Class.forName(className);

        Method method = myClass.getMethod("show",null);//参数传null
//        Person p = new Person();
//        p.show();
        //调用方法需要对象，方法名，和参数 。这里对象确定 了，
        // 那就只要对象和参数
        Object obj = myClass.newInstance();
        method.invoke(obj,null);


    }
}
