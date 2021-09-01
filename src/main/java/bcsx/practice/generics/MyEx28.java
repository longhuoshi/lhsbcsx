package main.java.bcsx.practice.generics;

import main.java.bcsx.typeinfo.pets.Dog;
import main.java.bcsx.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l
 * @date 2019/12/19 11:52
 * @description
 */



public class MyEx28 {

    class Generic1<T>{
        T t;
        void setT(T t){this.t = t;}

    }
    class Generic2<T>{
        T t;
        T takeT(){return t;}

    }

    <T> void  aaa(Generic1<? super   T> ct1,T t){
        ct1.setT(t);
    }

    <T> T get(Generic2<? extends T> ct2){
        return ct2.takeT();
    }

    public static void main(String[] args) {
        MyEx28 my = new MyEx28();
        my.aaa(my.new Generic1<Pet>(),new Dog());
        my.get(my.new Generic2<Pet>());


    }
}
