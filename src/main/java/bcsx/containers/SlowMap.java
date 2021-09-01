package bcsx.containers;

import bcsx.net.mindview.util.Countries;

import java.util.*;

/**
 * @author l
 * @date 2020/10/10 9:56
 * @description
 * 17.9.1 理解hashCode();
 */

public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();
    public V put(K key,V value){
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }
        else
            values.set(keys.indexOf(key),value);
        return oldValue;

    }

    public V get(Object key){//key is type object,not k
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));

    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set = new HashSet<Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String,String> m = new SlowMap<>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BURUNDI"));
        System.out.println(m.entrySet());

    }

}
