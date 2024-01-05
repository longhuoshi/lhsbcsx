package annotation.version2;

import java.lang.annotation.*;

/**
 * @author l
 * @date 2023/7/17 10:26
 * @description
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldAnnotation {
    public String name() default "defaultName";
    public String value() default "defaultValue";
}
