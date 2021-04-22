package bcsx.containers;

import bcsx.net.mindview.util.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;
import static bcsx.net.mindview.util.Print.*;
/**
 * @author l
 * @date 2020/9/29 16:39
 * @description
 * 
 *17.8.2 SortedMap
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer,String> sortedMap = new TreeMap<>(new CountingMapData(10));
        print(sortedMap);

        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        print(low);
        print(high);
        Iterator<Integer> it = sortedMap.keySet().iterator();

        for(int i = 0; i <= 6; i++) {
            if(i == 3) low = it.next();
            if(i == 6) high = it.next();
            else it.next();
        }


        print(low);
        print(high);
        print(sortedMap.subMap(low, high));
        print(sortedMap.headMap(high));
        print(sortedMap.tailMap(low));


    }
}
