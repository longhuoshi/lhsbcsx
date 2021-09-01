package reflect;

import java.lang.reflect.Field;

public class ReflectFieldDemo {
    public static void main(String[] args)throws Exception {

        getFieldDemo();
    }

    private static void getFieldDemo() throws Exception {
        String className = "myjava.reflect.domain.Person";
        Class myClass = Class.forName(className);
        //获取指定age字段
//        Field field = myClass.getField("age"); //该方法只获取公有的。
        Field field = myClass.getDeclaredField("age");
//        System.out.println(field);

        //要对非静态的字段操作必须有对象。
        Object obj = myClass.newInstance();
        //使用父类的方法将访问权限检查能力取消。
        field.setAccessible(true);//暴力访问
        field.set(obj,38);
        System.out.println(field.get(obj));


    }
}
