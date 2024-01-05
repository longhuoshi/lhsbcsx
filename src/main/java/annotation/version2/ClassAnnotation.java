package annotation.version2;

import java.lang.annotation.*;

/**
 * @author l
 * @date 2023/7/17 10:14
 * @description
 *
 * }
 */
// ===============================以下是第二个版本练习 =================================================
// 参考 https://juejin.cn/post/7122293903789096973
@Documented //定义可以被文档工具文档化。
@Retention(RetentionPolicy.RUNTIME) // 声明周期为runtime,支行时可以通过反射拿到 。
@Target(ElementType.TYPE) //注解 修饰范围为类、接口、枚举
public  @interface ClassAnnotation{
    public String name() default "defaultService";
    public String version() default "1.1.0";
}
