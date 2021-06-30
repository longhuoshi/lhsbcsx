package bcsx.containers;

import bcsx.net.mindview.util.Countries;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author l
 * @date 2020/10/14 11:06
 * @description
 * 17.9.2 为速度而散列
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {


    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997 ;

    // You can't have a physical array of generics,
    // but you can upcast to one:
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
    public V put(K key,V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair  = new MapEntry<K,V>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it =  bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
//                iPair.setValue(value);
                found=true;
                break;
            }
        }
        if(!found){
            buckets[index].add(pair);
//            bucket.add(pair);
        }

        return oldValue;

    }

    public  V  get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
//        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        for (MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }



    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<Entry<K,V>>();
        for (LinkedList<MapEntry<K,V>> bucket : buckets){
            if(bucket == null) continue;
            for (MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> m = new SimpleHashMap<String,String>();
        m.putAll(Countries.capitals(25));
        System.out.println(m);
        System.out.println(m.get("ERITREA"));
        System.out.println(m.entrySet());

    }
}
