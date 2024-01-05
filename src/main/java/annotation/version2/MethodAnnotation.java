package annotation.version2;

import java.lang.annotation.*;

/**
 * @author l
 * @date 2023/7/17 10:29
 * @description
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
    public String name() default "defaultName";
    public MethodTypeEnum type() default MethodTypeEnum.TYPE1;
}
