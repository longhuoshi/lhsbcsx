package reflect.dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @author l
 * @date 2021/9/1 17:31
 * @description
 * 4.获取代理对象的工厂类
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),  // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)  // 代理对象对应的自定义 InvocationHandler
        );
    }
}
