package generics.plate;

/**
 * @author l
 * @date 2021/4/25 16:21
 * @description
 */
public class Test {
    public static void main(String[] args) {
        /**
         * Apple是Fruit类不错。(苹果 IS-A 水果)
         * 但Plate<Apple>并不是Plate<Fruit>
         *     报错：“装苹果的盘子”无法转换成“装水果的盘子”。
         * */
//        Plate<Fruit> p = new Plate<Apple>(new Apple());


    }
}
