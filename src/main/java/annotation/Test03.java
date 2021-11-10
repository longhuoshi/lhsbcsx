package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 *
 * */
public class Test03 {
    //注解可以显示赋值，如果没有默认值 ，我们就必须给注解赋值。
    @MyAnnotation2(name = "李雲迪",schools = {"西北大学","湖南大学"})
    public void test1(){}

    @MyAnnotation3("张三")
    public void test2(){}

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数： 参数类型 + 参数名 ();
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在。

    String[] schools();
    String[] girlfriends() default {"苍老师","三上悠亚  "};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //参数名是value时，调用注解的地方可以省略参数名。
    String value();
}