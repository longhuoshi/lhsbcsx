package jvm_demo.chapter02;

public class ClassLoaderTest{
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //获取其上层：扩展类加载器
        ClassLoader extensionClassLoader = systemClassLoader.getParent();
        System.out.println(extensionClassLoader);

        //获取其上层：Bootstrap Class Loader
        ClassLoader bootstrapClassLoader = extensionClassLoader.getParent();
        System.out.println(bootstrapClassLoader); //null

        //对于用户自定义类来说：默认使用系统类加载器进行加载 。
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //String类使用引导类加载器进行加载的。 --》Java的核心类库都是使用引导类加载器进行加载 的。
//        ClassLoader classLoaderString = String.class.getClassLoader();
        ClassLoader classLoaderString = Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoaderString);

        //线程上下文加载器。  rt.jar中spi接口是 引导类加载器加载。具体jdbc.jar具体实现了spi接口的类是由线程上下文加载器加载
//        Thread.currentThread().getContextClassLoader();

    }
}