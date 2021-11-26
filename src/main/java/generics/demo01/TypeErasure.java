package generics.demo01;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author l
 * @date 2021/11/25 14:17
 * @description
 * 类型擦除
 * erasure [ɪ'reɪʒə(r)]
 */
public class TypeErasure {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();

        System.out.println(intList.getClass().getSimpleName());
        System.out.println(strList.getClass().getSimpleName());

        //内存地址相等的话就是同一Class类对象 ，也就是同一类型。
        System.out.println(intList.getClass() == strList.getClass());


        Erasure<Integer> erasure = new Erasure<>();
        System.out.println("=====利用反射，获取Erasure类的字节码文件的Class类对象 ======");
        Class<? extends Erasure> c = erasure.getClass();
        Field[] declaredFields = c.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()+":"+declaredField.getType().getSimpleName());
        }

    }
}
