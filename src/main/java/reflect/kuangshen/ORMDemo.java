package reflect.kuangshen;

import com.sun.javafx.binding.StringFormatter;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author l
 * @date 2021/11/23 16:39
 * @description
 * 练习反射操作注解。
 */
public class ORMDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflect.kuangshen.Student");
        //通过反射获得注解。
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获取注解value的值
        Tablekuang tablekuang = (Tablekuang)c1.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);


        System.out.println("字段的注解======================");
        //获得指定字段的注解 。
        Field field = c1.getDeclaredField("id");
        Fieldkuang fieldkuang = field.getAnnotation(Fieldkuang.class);
        System.out.println(fieldkuang.columnName());
        System.out.println(fieldkuang.type());
        System.out.println(fieldkuang.length());

    }
}

@Tablekuang("db_student")
class Student{
    @Fieldkuang(columnName = "db_id",type ="int",length = 10)
    private int id;
    @Fieldkuang(columnName = "db_age",type ="int",length = 3)
    private int age;
    @Fieldkuang(columnName = "db_name",type ="String",length = 20)
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang{
    String columnName();
    String type();
    int length();
}

