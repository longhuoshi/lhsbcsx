package reflect.kuangshen;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author l
 * @date 2021/11/23 11:18
 * @description
 * 获取类信息
 *
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("reflect.kuangshen.User");
        //获取类的名字
        System.out.println(c1.getName());//包名+类名
        System.out.println(c1.getSimpleName());//类名
        System.out.println("类的属性==============================");
        //获得类的属性
        Field[] fields = c1.getFields();//只能找到public属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("---------------------");
        fields = c1.getDeclaredFields();//全部属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //指定属性
        Field name = c1.getDeclaredField("name");
        System.out.println("指定："+name);

        System.out.println("类的方法==============================");
        //获得类的方法
        Method[] methods = c1.getMethods(); //获取本类及其父类的全部 public方法
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("---------------------");
        methods = c1.getDeclaredMethods();//获得本类的所有方法。
        for (Method method : methods) {
            System.out.println(method);
        }
        //指定方法(获取方法为什么要传入参数类型？因为方法有重载。)
        Method setName = c1.getDeclaredMethod("setName", String.class);
        Method getName = c1.getDeclaredMethod("getName",null);
        System.out.println("指定："+setName);
        System.out.println("指定："+getName);

        System.out.println("构造方法==============================");
        //获得类的构造方法
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("---------------------");
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        //指定构造方法
        Constructor declaredConstructor = c1.getDeclaredConstructor(int.class, int.class);
        System.out.println("指定："+declaredConstructor);



    }
}
