package  generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2021/4/25 15:42
 * @description
 *
 * PECS 全称 Producter Extends, Consumer Super 原则
 * 即供应者使用 Extends,消费者使用 Super。（生产者使用“? extends T”通配符，消费者使用“? super T”通配符）
 *
 *
 *
 *
 */
public class Demo {
    static class Food{}
    static class Fruit extends Food{}
    static class Apple extends Fruit{}

    public static void main(String[] args) {
        System.out.println(1232111);
    }

    //上界<? extends T>
    public static void testExtends(){
        List<? extends Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food()); //compile error
//        fruits.add(new Fruit());
//        fruits.add(new Apple());
        /**
         * 为啥上面代码中的 add 全部编译失败了呢？因为 fruits 集合并不知道实际类型是 Fruit、Apple 还是 Food，所以无法对其赋值。
         * */

        fruits = new ArrayList<Fruit>();
        fruits = new ArrayList<Apple>();
//        fruits = new ArrayList<Food>();

        Fruit obj = fruits.get(0);
    }

    // 下界<? super T>
    public static void testSuper(){
        List<? super Fruit> fruits = new ArrayList<>();
//        fruits.add(new Food()); //compile error
        fruits.add(new Fruit());
        fruits.add(new Apple());

        /**
         * 这里 add 时 Fruit 及其子类均可成功，为啥呢？
         * 因为已知 fruits 的参数化类型必定是 Fruit 或其超类 T，那么 Fruit 及其子类肯定可以赋值给 T。
         * 这里的原因归根到底，还是“子类对象可以赋值给超类引用，而反过来不行”这一规则导致
         * */

        fruits = new ArrayList<Fruit>();
//        fruits = new ArrayList<Apple>();
        fruits = new ArrayList<Food>();

//        Fruit obj = fruits.get(0);

    }
}
