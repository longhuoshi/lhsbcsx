package bcsx.arrays;


import bcsx.net.mindview.util.Generated;
import bcsx.net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;

import static bcsx.net.mindview.util.Print.*;
/**
 * @author l
 * @date 2020/9/3 16:50
 * @description
 * 16.7.4 数组排序.
 *生成随机字符串对象，并对其排序
 */
public class StringSorting {
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[10],new RandomGenerator.String(5));

        print("Before sort: " + Arrays.toString(sa));
        Arrays.sort(sa);
        print("After sort: " + Arrays.toString(sa));
        Arrays.sort(sa, Collections.reverseOrder());
        print("Reverse sort: " + Arrays.toString(sa));
        //CASE_INSENSITIVE_ORDER 不区分大小写，从底到高排序
        Arrays.sort(sa , String.CASE_INSENSITIVE_ORDER);
        print("case-insensitive sort: " + Arrays.toString(sa));



    }
}
