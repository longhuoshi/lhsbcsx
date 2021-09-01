package main.java.bcsx.arrays;

import main.java.bcsx.net.mindview.util.Generated;
import main.java.bcsx.net.mindview.util.Generator;
import main.java.bcsx.net.mindview.util.RandomGenerator;

import java.util.Arrays;

/**
 * @author l
 * @date 2020/9/16 11:05
 * @description
 * 16.7.5 在已排序的数组中查找
 *
 */
public class AlphabeticSearch {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30],new RandomGenerator.String(5));
        System.out.println(Arrays.toString(sa));
        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));
        int index  =  Arrays.binarySearch(sa , sa[10],String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index :"+index+ "\n"+sa[index]);


    }
}
