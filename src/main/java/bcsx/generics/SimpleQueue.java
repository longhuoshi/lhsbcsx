package bcsx.generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author l
 * @date 2020/8/11 17:38
 * @description
 */
public class SimpleQueue<T> implements  Iterable<T>{
    private LinkedList<T> storage = new LinkedList<>();
    public void add(T t ){ storage.offer(t);}
    public T get (){ return storage.poll(); }

    @Override
    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
