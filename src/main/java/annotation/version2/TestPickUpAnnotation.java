package annotation.version2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author l
 * @date 2023/7/17 11:09
 * @description
 *
 *  用反射提取注解2
 *
 *
 */
public class TestPickUpAnnotation {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("annotation.version2.AnnotationDemo");
        System.out.println("============类注解解析=================");
        printClassAnno(aClass);
        System.out.println("============成员变量注解解析=================");
        printFieldAnno(aClass);
        System.out.println("============成员方法注解解析=================");
        printMethodAnno(aClass);
        System.out.println("============构造器注解解析=================");
        printConstructorAnno(aClass);
        
    }


    /**
     *
     * 打印类的注解
     * */
    private static void printClassAnno(Class<?> clazz) {
        //判断是否有ClassAnnotation 注解
        if (clazz.isAnnotationPresent(ClassAnnotation.class)){
            //获取 ClassAnnotation类型的注解。
            ClassAnnotation annotation = clazz.getAnnotation(ClassAnnotation.class);
            System.out.println(annotation.name()+" : "+annotation.version());
        }
    }
    /**
     *
     * 打印成员变量的注解
     * */
    private static void printFieldAnno(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FieldAnnotation.class)){
                FieldAnnotation annotation = field.getAnnotation(FieldAnnotation.class);
                System.out.println(annotation.name()+" : "+annotation.value());

            }
        }
    }
    /**
     *
     * 打印成员方法的注解
     * */
    private static void printMethodAnno(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodAnnotation.class)){
                MethodAnnotation annotation = method.getAnnotation(MethodAnnotation.class);
                System.out.println(annotation.name()+" : "+annotation.type().ordinal());


            }
        }
    }


    /**
     *
     * 打印构造器的注解
     * */
    private static void printConstructorAnno(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();


        for (Constructor<?> constructor : constructors) {
            if (constructor.isAnnotationPresent(ConstructorAnnotation.class)){
                ConstructorAnnotation annotation = constructor.getAnnotation(ConstructorAnnotation.class);
                System.out.println(annotation.constructorName()+" : "+annotation.remark());

            }
        }
    }

}
