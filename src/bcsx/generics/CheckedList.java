package bcsx.generics;

import bcsx.typeinfo.pets.Cat;
import bcsx.typeinfo.pets.Dog;
import bcsx.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author l
 * @date 2020/7/9 16:31
 * @description
 *
 * 15.13 动态类型安全
 *
 * 使用Collections类检提供的工具方法。checkedList,checkedCollection, checkedMap
 * 查容器，存的对象是否合法。（容器泛型参数里存的对象类型。）
 *
 *
 */


public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1); //Quietly accepts a Cat

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(),Dog.class);
        try {
            oldStyleMethod(dogs2);//Throws an exception
        } catch (Exception e) {
            e.printStackTrace();
        }
        //derived types work fine
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(),Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());



    }


}
