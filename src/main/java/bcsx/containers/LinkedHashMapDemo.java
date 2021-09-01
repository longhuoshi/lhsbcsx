package bcsx.containers;

import bcsx.net.mindview.util.CountingMapData;

import java.util.LinkedHashMap;
import static bcsx.net.mindview.util.Print.*;
/**
 * @author l
 * @date 2020/10/9 11:33
 * @description
 * 17.8.3 LinkedHashMap
 * 基于访问的最近最少使用(LRU)算法
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> linkedMap = new LinkedHashMap<>(new CountingMapData(9));
        print(linkedMap);
        // Least-recently-used order:
        linkedMap = new LinkedHashMap<>(16,0.75f,true);
        linkedMap.putAll(new CountingMapData(9));
        print(linkedMap);
        for (int i = 0; i < 6; i++) { // Cause accesses:
            linkedMap.get(i);
        }
        print(linkedMap);
        linkedMap.get(0);
        print(linkedMap);


    }
}
