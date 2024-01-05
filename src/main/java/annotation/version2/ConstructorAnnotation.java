package annotation.version2;

import java.lang.annotation.*;

/**
 * @author l
 * @date 2023/7/17 10:19
 * @description
 */
@Documented
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstructorAnnotation {
    String constructorName() default "";
    String remark() default "构造器";
}
