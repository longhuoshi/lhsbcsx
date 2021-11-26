package generics.demo01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author l
 * @date 2021/11/25 9:52
 * @description
 * 类型通配符的下限 jdk中的应用
 */
public class TestDown2 {
    public static void main(String[] args) {
//        TreeSet<Cat> treeSet = new TreeSet<>(new ComparatorCat());
        TreeSet<Cat> treeSet = new TreeSet<Cat>(new ComparatorAnimal());
        treeSet.add(new Cat("jerry",20));
        treeSet.add(new Cat("amy",22));
        treeSet.add(new Cat("frank",35));
        treeSet.add(new Cat("jim",15));
        for (Cat cat : treeSet) {
            System.out.println(cat);
        }
    }

}

 class ComparatorAnimal implements Comparator<Animal>{
     @Override
     public int compare(Animal o1, Animal o2) {
         return o1.name.compareTo(o2.name);
     }
 }
 class ComparatorCat implements Comparator<Cat>{
     @Override
     public int compare(Cat o1, Cat o2) {
         return o1.age - o2.age;
     }
 }
 class ComparatorMiniCat implements Comparator<MiniCat>{
     @Override
     public int compare(MiniCat o1, MiniCat o2) {
         return o1.level - o2.level;
     }
 }
