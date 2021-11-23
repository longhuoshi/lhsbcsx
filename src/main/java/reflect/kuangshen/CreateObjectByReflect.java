package reflect.kuangshen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author l
 * @date 2021/11/23 14:04
 * @description
 * 参考：B站 狂神说
 * 通过反射动态的创建对象。
 */
public class CreateObjectByReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("reflect.kuangshen.User");

/*        //通过无参构造 创建对象
        User user = (User)c1.newInstance();
        System.out.println(user);

        //通过有参构造 创建对象 (首先需要一个构造器)
        Constructor constructor1 = c1.getDeclaredConstructor(String.class,int.class, int.class);
        user = (User)constructor1.newInstance("彭帅",1, 36);
        System.out.println(user);
        //通过私有 有参构造 创建对象
        Constructor constructor2 = c1.getDeclaredConstructor(int.class, int.class);
        constructor2.setAccessible(true);//私有构造器，要设置setAccessible 为true
        user = (User)constructor2.newInstance(2, 18);
        System.out.println(user);*/

        System.out.println("通过反射调用方法===========");
        //通过反射调用方法 (首先需要一个方法)
        User user2 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user2,"范冰冰");
        System.out.println(user2.getName());

        //通过反射操作属性
        User user3 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//开启私有属性访问权限
        name.set(user3,"狂神");
        System.out.println(user3.getName());


    }
}
