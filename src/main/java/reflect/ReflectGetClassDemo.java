package reflect;

import reflect.domain.Person;

public class ReflectGetClassDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 反射技术：动态的获取类以及类中的成员，并可以调用该类成员 。
         *
         * 无论new什么对象，都需要先获取字节码文件。
         * 如何获取呢？发现java已对字节码文件进行了描述用的Class类完成的。
         *
         * 如何获取一个字节码文件 的对象 呢？
         *
         * 方式一、Object getClass();方法 ，发现在反射技术里，该方法不合适，反射技术不明确具体类。
         *
         * 方式二、所有的数据类型都有自己对应的Class对象。表示方式很简单
         * 每一个数据类型都有一个默认静态属性 .class 用该 属性就可以获取到字节码文件 对象 。
         * 虽然不用对象调用了，还是要用具体的类调用静态属性。
         *
         * 方式三、在Class类中找到了forName方法。通过名称就可以获取对应的字节码文件 对象 。重点。
         *
         *
         *
         * */

        methodDemo_1();
        methodDemo_2();
        methodDemo_3();
    }

    private static void methodDemo_3() throws ClassNotFoundException {
        String className = "myjava.reflect.domain.Person";
        Class c  = Class.forName(className);
        System.out.println(c);
    }

    //获取Class对象的方式二
    private static void methodDemo_2() {
        Class c1 = Person.class;
        Class c2 = Person.class;
        System.out.println(c1 == c2);

    }

    //获取Class对象的方式一
    private static void methodDemo_1() {
        Person p1 = new Person();
        Person p2 = new Person();
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.out.println(c1 == c2);
    }
}
