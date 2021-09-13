package jvm_demo.chapter02;

import java.io.FileNotFoundException;

/**
 * 自定义用户类加载器
 *33-为什么需要用户自定义类加载器及具体实现
 * */
public class CustomClassLoader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if (result ==null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name,result,0,result.length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        //从自定义路径中加载指定类，细节略
        //如果指定路径的字节码文件 进行了加密，则需要在此方法 中进行解密操作。

        return null;
    }

    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        try {
            Class<?> clazz = Class.forName("one",true,customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
