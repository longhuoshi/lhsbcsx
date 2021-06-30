package bcsx.generics;

import bcsx.net.mindview.util.TwoTuple;
//注意这里是静态引入，所有静态方法可直接用方法名调用 ，不需要通过类名。
import static bcsx.net.mindview.util.Tuple.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author l
 * @date 2020/7/16 14:46
 * @description
 *
 * 15.15.4 与动态代理混合
 *
 */

class MixinProxy implements InvocationHandler{

    Map<String,Object> delegatesBymethod;

    public MixinProxy(TwoTuple<Object,Class<?>>... pairs){
        System.out.println("------MixinProxy-------");

        delegatesBymethod = new HashMap<String,Object>();
        for (TwoTuple<Object,Class<?>> pair : pairs){
            for (Method method : pair.second.getMethods()){
                String methodName = method.getName();
                //The first interface in the map implements the method.
                if(!delegatesBymethod.containsKey(methodName))
                    delegatesBymethod.put(methodName,pair.first);
            }
        }
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        System.out.println("------invoke-------methodName:"+methodName);
        Object delegate = delegatesBymethod.get(methodName);

        return method.invoke(delegate,args);
    }

    public static Object newInstance(TwoTuple... pairs){
        System.out.println("------newInstance-------");
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            interfaces[i] = (Class) pairs[i].second;
        }
        ClassLoader cl = pairs[0].getClass().getClassLoader();
        return Proxy.newProxyInstance(cl,interfaces, new MixinProxy(pairs));
    }

}

public class DynamicProxyMixin {
    public static void main(String[] args) {

        Object mixin = MixinProxy.newInstance(
                tuple(new BasicImp(),Basic.class),
                tuple(new TimeStampedImp(),TimeStamped.class),
                tuple(new SerialNumberedImp(),SerialNumbered.class)
        );

        Basic b = (Basic) mixin;
        TimeStamped t = (TimeStamped) mixin;
        SerialNumbered s = (SerialNumbered) mixin;
        b.set("Hello");
        System.out.println(b.get());
        System.out.println(t.getStamp());
        System.out.println(s.getSerialNumber());


    }
}
