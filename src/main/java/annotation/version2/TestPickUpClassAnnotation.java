package annotation.version2;

import bcsx.typeinfo.Person;

/**
 * @author l
 * @date 2023/7/17 11:09
 * @description
 *
 *  用反射提取注解 1
 *
 *
 */
public class TestPickUpClassAnnotation {
    private static AnnotationDemo demo = new AnnotationDemo();

    public static void main(String[] args) {
        Class<? extends AnnotationDemo> aClass = demo.getClass();
        if (aClass.isAnnotationPresent(ClassAnnotation.class)){
            System.out.println("This is a class with annotation ClassAnnotation!");
            //通过getAnnotation可以获取注解对象
            ClassAnnotation annotation = aClass.getAnnotation(ClassAnnotation.class);
            if (null != annotation){
                System.out.println("BeanName = "+annotation.name());
                System.out.println("BeanVersion = "+annotation.version());
            }else
                System.out.println("The annotation that we get is null!");

        }else
            System.out.println("This is not the class that with ClassAnnotation!");
    }

}
