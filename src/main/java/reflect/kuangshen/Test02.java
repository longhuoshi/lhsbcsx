package reflect.kuangshen;

import java.util.Comparator;

/**
 * @author l
 * @date 2021/11/23 10:33
 * @description
 * 参考：B站 狂神说
 * 利用反射获类信息
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
       // 通过反射获取类的Class对象
        Class  c1 = Class.forName("reflect.kuangshen.User");
        System.out.println(c1);

        //一个类在内存中只有一个Class对象,但可以有多个实例对象。
        //一个类被加载后，类的整个结构都会被封装在Class对象 中。
        Class  c2 = Class.forName("reflect.kuangshen.User");
        System.out.println(c2.hashCode());
        Class  c3 = Class.forName("reflect.kuangshen.User");
        System.out.println(c3.hashCode());


    }
}


//实体类：pojo, entity
class User {
    public double version=1.0;
    private String name;
    private int id;
    private int age;

    public User() {
    }

    private User( int id, int age) {
        this.id = id;
        this.age = age;
    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    private void test(){}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}

