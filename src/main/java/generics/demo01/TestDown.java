package generics.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author l
 * @date 2021/11/25 9:52
 * @description
 * 类型通配符的下限
 * 语法：类/接口<? super 实参类型>
 */
public class TestDown {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();

        showAnimal(animals);
        showAnimal(cats);
//        showAnimal(miniCats);
    }

    /**
     * 泛型下限通配符，传递的集合类型，只能是Cat或Cat的父类型。
     *
     * 由于子类可自动转父类，父类不可自动转子类
     * 所以  list.add(new Animal()); 会报错。只能存储Cat及Cat的子类。
     * */
    public static void showAnimal(List<? super Cat> list){
//        list.add(new Animal());
        list.add(new Cat("cherry",16));
        list.add(new MiniCat("sola",14,2));

        for (Object o : list) {
            System.out.println(o);
        }
    }
}
