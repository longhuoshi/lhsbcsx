package generics.demo01;

import java.util.ArrayList;

/**
 * @author l
 * @date 2021/11/25 9:52
 * @description
 * 类型通配符的上限
 * 语法：类/接口<? extends 实参类型>
 */
public class TestUp {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<MiniCat> miniCats = new ArrayList<>();

//        cats.addAll(animals)
        cats.addAll(miniCats);



//        showAnimal(animals);
        showAnimal(cats);
        showAnimal(miniCats);
    }

    /**
     * 泛型上限通配符，传递的集合类型，只能是Cat或Cat的子类型。
     * */
    public static void showAnimal(ArrayList<? extends Cat> list){
//        list.add(new Cat());
        //不能存储元素的list列表 ，存在有什么意义 ？
        //扩大思维半径，不要局限于list本身。
        // 从框架的维度云看，在java方法中当只想接受某个类型或这个类型子类 的list列表 时。这个上限通配符就有重要用途。
        //在方法外只要传ArrayList<具体类型就好>
        //例如 showAnimal(ArrayList<? extends Cat> list);调用时传ArrayList<Cat>和 ArrayList<MiniCat>类型就好。

        for (int i = 0; i < list.size(); i++) {
            Cat cat = list.get(i);
            System.out.println(cat);
        }
    }
}
