package reflect.kuangshen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author l
 * @date 2021/11/23 15:03
 * @description
 * 分析效率和性能问题
 */
public class AnalyseEfficiency {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        test01();
        test02();
        test03();
    }


    //普通方式调用
    private static void test01() {
        User user = new User();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次："+(endTime-startTime)+"ms");
    }

    //反射方式调用
    private static void test02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class c1 = Class.forName("reflect.kuangshen.User");
        User user = (User) c1.newInstance();
        Method getName = c1.getDeclaredMethod("getName");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次："+(endTime-startTime)+"ms");
    }

    //反射方式调用 关闭检测
    private static void test03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class c1 = Class.forName("reflect.kuangshen.User");
        User user = (User) c1.newInstance();
        Method getName = c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("普通方式执行10亿次："+(endTime-startTime)+"ms");
    }

}
