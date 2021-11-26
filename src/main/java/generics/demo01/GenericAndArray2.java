package generics.demo01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author l
 * @date 2021/11/25 15:05
 * @description
 * 泛型与数组
 * 动态 的创建不同类型的数组
 * 推荐用泛型集合，不要用泛型数组。
 */
public class GenericAndArray2 {
    public static void main(String[] args) {
        Fruit<String> fruit = new Fruit<>(String.class,3);
        fruit.put(0,"苹果");
        fruit.put(1,"西瓜");
        fruit.put(2,"banana");

        System.out.println(Arrays.toString(fruit.getArray()));
        String s = fruit.get(2);
        System.out.println(s);

    }

}
