package bcsx.containers;

import java.util.*;

/**
 * @author l
 * @date 2021/2/22 10:37
 * @description
 * 17.11.3 Collection或Map的同步控制
 *
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection<String> c = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Set<String> s = Collections.synchronizedSet(new HashSet<String>());
        Set<String> ss = Collections.synchronizedSortedSet(new TreeSet<String>());
        Map<String,String> m = Collections.synchronizedMap(new HashMap<String,String>());
        Map<String,String> sm = Collections.synchronizedSortedMap(new TreeMap<String,String>());



    }
}
