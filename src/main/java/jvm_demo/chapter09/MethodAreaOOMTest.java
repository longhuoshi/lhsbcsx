package jvm_demo.chapter09;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 91-OOM：PermGen和OOM：Metaspace举例
 * 方法区OOM演示
 *
 * -XX:MetaspaceSize=10m  -XX:MaxMetaspaceSize=10m
 * OutOfMemoryError: Compressed class space
 * */
public class MethodAreaOOMTest extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try {
            MethodAreaOOMTest test = new MethodAreaOOMTest();
            for (int i = 0; i < 10000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码。
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class"+i,null,"java/lang/Object",null);
                //返回byte[]
                byte[] codes = classWriter.toByteArray();
                //类加载，生成Class实例。
                test.defineClass("Class"+i,codes,0,codes.length);
                j++;
            }

        }finally {
            System.out.println(j);
        }
    }
}
