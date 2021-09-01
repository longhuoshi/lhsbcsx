package bcsx.generics;

import bcsx.generics.coffee.Coffee;
import bcsx.generics.coffee.Latte;
import bcsx.generics.coffee.Mocha;
import bcsx.net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author l
 * @date 2020/8/12 11:32
 * @description
 *
 * 15.17.4 用适配器仿真潜在类型机制
 */

interface Addable<T> { void add(T t); }

public class Fill2 {
    // Classtoken version:
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> classToken, int size) {
        for(int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
    }
    // Generator version:
    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for(int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

// To adapt a base type, you must use composition.
// Make any Collection Addable using composition:
class AddableCollectionAdapter<T> implements Addable<T>{
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }
    @Override
    public void add(T item) {
        c.add(item);
    }
}
//A helper to capture the type automatically .
class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

//to adapt a specific type , you can use inheritance.
//make a SimpleQueue Addable use inheritance.
class AddableSimpleQueue<T> extends bcsx.generics.SimpleQueue<T> implements Addable<T>{
    public void add(T item) {
        super.add(item);
    }
}

class Fill2Test{
    public static void main(String[] args) {
        //Adapt a Collection
        List<Coffee> carrier = new ArrayList<Coffee>();
        Fill2.fill(new AddableCollectionAdapter<Coffee>(carrier),Coffee.class,3);
        //Helper method captures the type:
        Fill2.fill(Adapter.collectionAdapter(carrier), Latte.class,2);
        for (Coffee c:carrier)
            System.out.println(c);

        System.out.println("----------------------");
        //Use an adapted class:
        AddableSimpleQueue<Coffee> coffeeQueue = new AddableSimpleQueue<>();
        Fill2.fill(coffeeQueue, Mocha.class,4);
        Fill2.fill(coffeeQueue, Latte.class,1);
        for(Coffee  c:coffeeQueue)
            System.out.println(c);


    }
}
