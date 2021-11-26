package generics.demo01;

/**
 * @author l
 * @date 2021/11/25 10:12
 * @description
 * 类型通配符 ?
 *
 * 1）类型通配符一般是使用“?”代替具体的类型实参。
 * 2）所以，类型通配符是类型实参，而不是类型形参。
 *
 */
public class TypeWildcardTest {
    public static void main(String[] args) {
        Box<Number> box = new Box<>();
        box.setFirst(100);
        showBox(box);

        Box<Integer> box2 = new Box<>();
        box2.setFirst(101);

        //如果用showBox(Box<Number> box) 方法会报:
        //'showBox(generics.demo01.Box<java.lang.Number>)' in 'generics.demo01.TypeWildcardTest'
        // cannot be applied to '(generics.demo01.Box<java.lang.Integer>)'
        showBox(box2);



    }

    //?代表调用方法时传入 的实参。
    public static void showBox(Box<?> box){
        Object first = box.getFirst();
        System.out.println(first);
    }


/*    public static void showBox(Box<Number> box){
        Number first = box.getFirst();
        System.out.println(first);
    }*/
}
