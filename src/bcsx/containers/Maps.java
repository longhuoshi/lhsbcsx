package bcsx.containers;

import bcsx.net.mindview.util.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static bcsx.net.mindview.util.Print.*;

/**
 * @author l
 * @date 2020/9/28 16:23
 * @description
 * 17.8.1 性能
 */
public class Maps {
    public static void printKeys(Map<Integer,String> map){
        printnb("Size = " + map.size() + ", ");
        printnb("Keys : ");
        print(map.keySet());

    }
    public static void test(Map<Integer,String> map){
        print(map.getClass().getSimpleName()+"============================================");
        map.putAll(new CountingMapData(25));
        // Map has 'Set' behavior for keys:
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a Collection of the values:
        printnb("Values: ");
        print(map.values());
        print(map);
        print("map.containsKey(11): " + map.containsKey(11));
        print("map.get(11): " + map.get(11));
        print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Integer key = map.keySet().iterator().next();
        print("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        print("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        print("map.isEmpty(): " + map.isEmpty());



    }

    public static void main(String[] args) {

        test(new HashMap<Integer,String>());
        test(new TreeMap<Integer,String>());
        test(new LinkedHashMap<Integer,String>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<Integer,String>());
        test(new WeakHashMap<Integer,String>());
    }

}
