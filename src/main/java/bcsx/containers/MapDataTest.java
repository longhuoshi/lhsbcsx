package bcsx.containers;

import bcsx.net.mindview.util.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static bcsx.net.mindview.util.Print.*;


/**
 * @author l
 * @date 2020/9/21 14:24
 * @description
 *
 * 17.2.2 Map生成器
 */

class Letters implements bcsx.net.mindview.util.Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size = 9 ;
    private int number = 1 ;
    private char letter = 'A';


    @Override
    public Pair<Integer, String> next() {
        return new Pair<>(number++ , ""+letter++);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return  number<size;
            }

            @Override
            public Integer next() {
                return number++;
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        //pair generator
        print(bcsx.net.mindview.util.MapData.map(new Letters(),11));
        //Two separate generators ;
        print(bcsx.net.mindview.util.MapData.map(new bcsx.net.mindview.util.CountingGenerator.Character(),new bcsx.net.mindview.util.RandomGenerator.String(3),8));
        // A key Generator and a single value:
        print(bcsx.net.mindview.util.MapData.map(new bcsx.net.mindview.util.CountingGenerator.Character(),"value",6));
        // An Iterable and a value Generator:
        print(bcsx.net.mindview.util.MapData.map(new Letters(),new bcsx.net.mindview.util.RandomGenerator.String(3)));
        // An Iterable and a single value:
        print(bcsx.net.mindview.util.MapData.map(new Letters(),"Pop"));

    }
}
