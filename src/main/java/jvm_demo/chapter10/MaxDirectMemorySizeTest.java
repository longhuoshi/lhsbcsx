package jvm_demo.chapter10;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存的00M与内存大小的设置
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 *
 * */
public class MaxDirectMemorySizeTest {
    private static final long _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        //通过字段获取对象
        Unsafe unsafe = (Unsafe)unsafeField.get(null);//静态字段可以传null获取，非静态字段则不能。
        while (true){
            unsafe.allocateMemory(_1MB);
        }

    }
}
